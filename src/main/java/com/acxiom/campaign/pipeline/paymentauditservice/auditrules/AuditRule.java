package com.acxiom.campaign.pipeline.paymentauditservice.auditrules;

import com.acxiom.campaign.pipeline.paymentauditservice.PaymentInputData;

/**
 * Created by mlalapet on 9/25/18.
 */
public interface AuditRule {
    AuditRuleResult executeRule(PaymentInputData inputData);
}
