package com.example.rule.engine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


import java.io.Serializable;

@Table(name = "rules")
@Entity
@Getter
@IdClass(RuleDbModel.IdClass.class)
public class RuleDbModel {
    @Id
    @Column(name = "rule_namespace")
    private String ruleNamespace;
    @Column(name = "rule_id")
    private String ruleId;
    @Column(name = "condition_text", length = 2000)
    private String condition;
    @Column(name = "action_text",  length = 2000)
    private String action;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "description_text",  length = 2000)
    private String description;

    @Data
    static class IdClass implements Serializable {
        private String ruleNamespace;
        private String ruleId;
    }
}