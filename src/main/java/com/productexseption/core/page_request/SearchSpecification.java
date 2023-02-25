package com.productexseption.core.page_request;

import com.google.common.base.CaseFormat;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SearchSpecification<T> implements Specification<T> {
    private final List<SearchCriteria> params;

    public SearchSpecification(List<SearchCriteria> params) {
        this.params = params;
    }

    @Override
    public Predicate toPredicate(@Nullable Root<T> root, @Nullable CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();
        if (params != null)
            for (SearchCriteria param : params) {
                if (param.getKey().split("_").length > 1)
                    param.setKey(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, param.getKey()));
                Predicate predicateParam = getPredicate(param, criteriaBuilder, root);
                predicate = criteriaBuilder.and(predicate, predicateParam);
            }
        return predicate;
    }

    private Predicate getPredicate(SearchCriteria param, CriteriaBuilder builder, Root<T> root) {
        return switch (param.getOperation()) {
            case ">" -> builder.greaterThan(root.get(param.getKey()), param.getValue().toString());
            case ">=" -> builder.greaterThanOrEqualTo(root.get(param.getKey()), param.getValue().toString());
            case "<" -> builder.lessThan(root.get(param.getKey()), param.getValue().toString());
            case "<=" -> builder.lessThanOrEqualTo(root.get(param.getKey()), param.getValue().toString());
            case "%_" ->
                    builder.like(builder.lower(root.get(param.getKey())), "%" + param.getValue().toString().toLowerCase());
            case "_%" ->
                    builder.like(builder.lower(root.get(param.getKey())), param.getValue().toString().toLowerCase() + "%");
            case "%_%" ->
                    builder.like(builder.lower(root.get(param.getKey())), "%" + param.getValue().toString().toLowerCase() + "%");
            case "!=" -> getPredicateOnNotEqual(param, builder, root);
            default -> getPredicateOnEqual(param, builder, root);
        };
    }

    private Predicate getPredicateOnEqual(SearchCriteria param, CriteriaBuilder builder, Root<T> root) {
        String[] keys = param.getKey().split("\\.");
        Class<?> paramType = root.get(keys[0]).getJavaType();
        String value = param.getValue() == null ? null : (String) param.getValue();
        if (keys.length == 2) {
            return builder.equal(builder.function(
                    "jsonb_extract_path_text",
                    String.class,
                    root.get(keys[0]), builder.literal(keys[1])), value);
        } else if (value == null)
            return builder.isNull(root.get(keys[0]));
        else if (paramType.equals(String.class))
            return builder.equal(root.get(keys[0]), value);
        else if (paramType.equals(UUID.class))
            return builder.equal(root.get(param.getKey()), UUID.fromString(value));
        else if (paramType.equals(HashMap.class))
            return builder.or(
                    builder.like(builder.lower(builder.function(
                            "jsonb_extract_path_text",
                            String.class,
                            root.get(param.getKey()), builder.literal("uz"))), "%" + value.toLowerCase() + "%"),
                    builder.like(builder.lower(builder.function(
                            "jsonb_extract_path_text",
                            String.class,
                            root.get(param.getKey()), builder.literal("ru"))), "%" + value.toLowerCase() + "%"),
                    builder.like(builder.lower(builder.function(
                            "jsonb_extract_path_text",
                            String.class,
                            root.get(param.getKey()), builder.literal("en"))), "%" + value.toLowerCase() + "%"));
        else if (Enum.class.isAssignableFrom(paramType))
            return builder.equal(root.get(param.getKey()), Enum.valueOf((Class<Enum>) paramType, value));
        else
            return builder.equal(root.get(param.getKey()), param.getValue());
    }

    private Predicate getPredicateOnNotEqual(SearchCriteria param, CriteriaBuilder builder, Root<T> root) {
        String[] keys = param.getKey().split("\\.");
        Class<?> paramType = root.get(keys[0]).getJavaType();
        String value = param.getValue() == null ? null : (String) param.getValue();
        if (keys.length == 2) {
            return builder.notEqual(builder.function(
                    "jsonb_extract_path_text",
                    String.class,
                    root.get(keys[0]), builder.literal(keys[1])), value);
        } else if (value == null)
            return builder.isNotNull(root.get(keys[0]));
        if (paramType.equals(String.class))
            return builder.notEqual(root.get(param.getKey()), value);
        else if (paramType.equals(UUID.class))
            return builder.notEqual(root.get(param.getKey()), UUID.fromString(value));
        else if (paramType.equals(HashMap.class))
            return builder.and(
                    builder.notLike(builder.lower(builder.function(
                            "jsonb_extract_path_text",
                            String.class,
                            root.get(param.getKey()), builder.literal("uz"))), "%" + value.toLowerCase() + "%"),
                    builder.notLike(builder.lower(builder.function(
                            "jsonb_extract_path_text",
                            String.class,
                            root.get(param.getKey()), builder.literal("ru"))), "%" + value.toLowerCase() + "%"),
                    builder.notLike(builder.lower(builder.function(
                            "jsonb_extract_path_text",
                            String.class,
                            root.get(param.getKey()), builder.literal("en"))), "%" + value.toLowerCase() + "%"));
        else if (paramType.isEnum())
            return builder.notEqual(root.get(param.getKey()), Enum.valueOf((Class<Enum>) paramType, value));
        else
            return builder.notEqual(root.get(param.getKey()), param.getValue());
    }

}
