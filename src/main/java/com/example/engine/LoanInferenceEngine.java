package com.example.engine;

import com.example.rule.engine.InferenceEngine;
import com.example.rule.details.LoanDetails;
import com.example.rule.details.UserDetails;
import com.example.rule.model.RuleNamespace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanInferenceEngine extends InferenceEngine<UserDetails, LoanDetails> {
    @Override
    protected RuleNamespace getRuleNamespace() {
        return RuleNamespace.LOAN;
    }
    @Override
    protected LoanDetails initializeOutputResult() {
        return new LoanDetails();
    }
}
