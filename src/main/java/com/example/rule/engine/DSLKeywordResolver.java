package com.example.rule.engine;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DSLKeywordResolver {
    Map<String, DSLResolver> dslKeywordResolverList;
    @Autowired
    public DSLKeywordResolver(List<DSLResolver> resolverList) {
        dslKeywordResolverList = resolverList.stream()
                .collect(Collectors.toMap(DSLResolver::getResolverKeyword, Function.identity()));
    }
    public Optional<DSLResolver> getResolver(String keyword) {
        return Optional.ofNullable(dslKeywordResolverList.get(keyword));
    }
}
