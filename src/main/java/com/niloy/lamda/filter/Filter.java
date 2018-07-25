package com.niloy.lamda.filter;

@FunctionalInterface
public interface Filter<T> {
    public boolean test(T t);

    default public void fest(T t){
        System.out.println("Just another method!");
    }
}
