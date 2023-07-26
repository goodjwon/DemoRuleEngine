package com.example.rule.engine;

import com.example.rule.engine.details.LoanDetails;
import com.example.rule.engine.details.UserDetails;
import com.example.rule.engine.model.RuleNamespace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanInferenceEngine extends InferenceEngine<UserDetails, LoanDetails>{
    @Override
    protected RuleNamespace getRuleNamespace() {
        return RuleNamespace.LOAN;
    }
    @Override
    protected LoanDetails initializeOutputResult() {
        return new LoanDetails();
    }
}
