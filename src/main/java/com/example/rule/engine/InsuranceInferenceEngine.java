package com.example.rule.engine;

import com.example.rule.engine.details.InsuranceDetails;
import com.example.rule.engine.details.PolicyHolderDetails;
import com.example.rule.engine.model.RuleNamespace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InsuranceInferenceEngine extends InferenceEngine<PolicyHolderDetails, InsuranceDetails>{
    @Override
    protected RuleNamespace getRuleNamespace() {
        return RuleNamespace.INSURANCE;
    }

    @Override
    protected InsuranceDetails initializeOutputResult() {
        return InsuranceDetails.builder().build();
    }
}
