package com.example.rule.engine;

import com.example.rule.engine.model.Rule;
import com.example.rule.engine.model.RuleNamespace;
import com.example.rule.engine.parser.RuleParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class InferenceEngine <INPUT_DATA, OUTPUT_RESULT> {
    @Autowired
    private RuleParser<INPUT_DATA, OUTPUT_RESULT> ruleParser;
    public OUTPUT_RESULT run (List<Rule> listOfRules, INPUT_DATA inputData){
        //STEP 1 MATCH
        List<Rule> conflictSet = match(listOfRules, inputData);
        //STEP 2 RESOLVE
        Rule resolvedRule = resolve(conflictSet);
        if (null == resolvedRule){
            return null;
        }
        //STEP 3 EXECUTE
        OUTPUT_RESULT outputResult = executeRule(resolvedRule, inputData);
        return outputResult;
    }

    //Here we are using Linear matching algorithm for pattern
    protected List<Rule> match(List<Rule> listOfRules, INPUT_DATA inputData){
        return listOfRules.stream()
                .filter(
                        rule -> {
                            String condition = rule.getCondition();
                            return ruleParser.parseCondition(condition, inputData);
                        }
                )
                .collect(Collectors.toList());
    }
    //Here we are using find first rule logic.
    protected Rule resolve(List<Rule> conflictSet){
        Optional<Rule> rule = conflictSet.stream()
                .findFirst();
        if (rule.isPresent()){
            return rule.get();
        }
        return null;
    }
    protected OUTPUT_RESULT executeRule(Rule rule, INPUT_DATA inputData){
        OUTPUT_RESULT outputResult = initializeOutputResult();
        return ruleParser.parseAction(rule.getAction(), inputData, outputResult);
    }
    protected abstract OUTPUT_RESULT initializeOutputResult();
    protected abstract RuleNamespace getRuleNamespace();
}