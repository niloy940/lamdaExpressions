package com.niloy.lamda.filter;

public class FilterStringTooSmall implements Filter<String> {
    @Override
    public boolean test(String s) {
        if (s.length() < 5)
            return true;
        return false;
    }
}
