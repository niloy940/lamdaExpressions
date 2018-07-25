package com.niloy.lamda.filter;

import com.niloy.lamda.model.Person;

public class FilterAgeAtLeast30 implements Filter<Person> {
    @Override
    public boolean test(Person person) {
        if (person.getAge() >= 30)
            return true;
        else return false;
    }
}
