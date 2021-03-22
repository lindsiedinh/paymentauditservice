package com.acxiom.campaign.pipeline.paymentauditservice.auditrules;

import com.acxiom.campaign.pipeline.paymentauditservice.PaymentInputData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlalapet on 9/25/18.
 */
@Component
public class Auditor {

    private List<AuditRule> rules = new ArrayList();

    public Auditor() {
        this.rules.add(new CustomerIdLengthRule());
        this.rules.add(new PaymentDueDateCounterRule());
    }

    public List<AuditRuleResult> audit(PaymentInputData inputData) {
        List<AuditRuleResult> ruleResults = new ArrayList();

        for(AuditRule rule : rules)
            ruleResults.add(rule.executeRule(inputData));

        return ruleResults;
    }

    private class CustomerIdLengthRule implements AuditRule {

        @Override
        public AuditRuleResult executeRule(PaymentInputData inputData) {

            String customerId = inputData.getCustomerId();

            if(customerId == null || customerId.trim().length() == 0 || customerId.trim().length() > 1)
                return (new AuditRuleResult.Builder())
                        .withRuleResult(false)
                        .withRuleName("CUSTOMER_ID_LENGTH")
                        .withRuleErrorMessage("Customer Id is not 1 char length").build();

            return (new AuditRuleResult.Builder())
                    .withRuleResult(true)
                    .withRuleName("CUSTOMER_ID_LENGTH").build();
        }
    }

    private class PaymentDueDateCounterRule implements AuditRule {

        @Override
        public AuditRuleResult executeRule(PaymentInputData inputData) {

            int paymentDueDateCounter = inputData.getCt_pay_due_date_counter();

            if(paymentDueDateCounter > 9)
                return (new AuditRuleResult.Builder())
                        .withRuleResult(false)
                        .withRuleName("PAYMENT_DUE_DATE_COUNTER")
                        .withRuleErrorMessage("Payment due date counter should not be > 9").build();

            return (new AuditRuleResult.Builder())
                    .withRuleResult(true)
                    .withRuleName("PAYMENT_DUE_DATE_COUNTER").build();
        }
    }

}
