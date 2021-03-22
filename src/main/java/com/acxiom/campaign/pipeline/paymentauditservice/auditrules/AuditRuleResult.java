package com.acxiom.campaign.pipeline.paymentauditservice.auditrules;

/**
 * Created by mlalapet on 9/25/18.
 */
public class AuditRuleResult {
    private boolean result;
    private String errorMessage;
    private String ruleName;

    private AuditRuleResult(boolean result, String errorMessage, String ruleName) {
        this.result = result;
        this.errorMessage = errorMessage;
        this.ruleName = ruleName;
    }

    public boolean passed() {
        return result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getRuleName() {
        return ruleName;
    }

    public static class Builder {
        private String ruleName;
        private boolean ruleResult;
        private String ruleErrorMessage;

        public Builder() {};
        public Builder withRuleName(String ruleName) {
            this.ruleName = ruleName;
            return this;
        }
        public Builder withRuleResult(boolean ruleResult) {
            this.ruleResult = ruleResult;
            return this;
        }
        public Builder withRuleErrorMessage(String ruleErrorMessage) {
            this.ruleErrorMessage = ruleErrorMessage;
            return this;
        }
        public AuditRuleResult build() {
            return new AuditRuleResult(ruleResult, ruleErrorMessage, ruleName);
        }
    }
}
