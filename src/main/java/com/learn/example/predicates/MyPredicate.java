package com.learn.example.predicates;

/**
 * @author csl
 */
@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
