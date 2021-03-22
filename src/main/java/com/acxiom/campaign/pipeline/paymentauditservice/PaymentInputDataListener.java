package com.acxiom.campaign.pipeline.paymentauditservice;

import com.acxiom.campaign.pipeline.paymentauditservice.auditrules.AuditRuleResult;
import com.acxiom.campaign.pipeline.paymentauditservice.auditrules.Auditor;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlalapet on 9/21/18.
 */
@Component
public class PaymentInputDataListener {

    @Inject
    Auditor auditor;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${auditeddata.topic.name}")
    private String auditedDataTopic;

    private Gson gson = new Gson();

    @KafkaListener(topics = "${message.topic.name}", group = "${kafka.consumerGrpId}", containerFactory = "kafkaListenerContainerFactory")
    public void receivePaymentInputData(String message) {

        PaymentInputData paymentInputData = convertJSONToDataObject(message);

        boolean auditPassed = executeAuditRules(paymentInputData, message);

        if(auditPassed) {
            this.kafkaTemplate.send(auditedDataTopic,message);
        }

    }

    private boolean executeAuditRules(PaymentInputData paymentInputData, String json) {

        boolean returnResult = true;
        List<AuditRuleResult> logResults = new ArrayList<>();

        List<AuditRuleResult> results = auditor.audit(paymentInputData);

        for(AuditRuleResult result : results) {
            if(!result.passed()) {
                returnResult = false;
                logResults.add(result);
            }
        }

        if(!returnResult) {
            String errorMsg = buildReadableErrorMessage(json, logResults);
            System.err.println(errorMsg);
        }

        return returnResult;
    }

    private String buildReadableErrorMessage(String json, List<AuditRuleResult> logResults) {
        StringBuilder builder = new StringBuilder("Failed to process message ")
                .append(json).append(". Failed Audit Rules ").append(gson.toJson(logResults));
        /**for(AuditRuleResult result : logResults)
            builder = builder.append("{").append(result.getRuleName()).append(" - ").append(result.getErrorMessage()).append("},");
        builder.append("]");**/
        return builder.toString();
    }

    private PaymentInputData convertJSONToDataObject(String message) {
        return gson.fromJson(message, PaymentInputData.class);
    }

}
