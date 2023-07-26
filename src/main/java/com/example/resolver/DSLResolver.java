package com.example.resolver;

public interface DSLResolver {
    String getResolverKeyword();
    Object resolveValue(String keyword);
}
