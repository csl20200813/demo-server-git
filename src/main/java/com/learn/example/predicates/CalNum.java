package com.learn.example.predicates;

@FunctionalInterface
public interface CalNum<T> {
    T getVal(T i);
}
