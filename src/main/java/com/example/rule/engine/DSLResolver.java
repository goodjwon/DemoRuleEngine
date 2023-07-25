package com.example.rule.engine;

public interface DSLResolver {
    String getResolverKeyword();
    Object resolveValue(String keyword);
}
