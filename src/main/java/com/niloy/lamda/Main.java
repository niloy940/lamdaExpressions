package com.niloy.lamda;

import com.niloy.lamda.filter.Filter;
import com.niloy.lamda.io.Reader;
import com.niloy.lamda.model.Person;
import com.niloy.lamda.model.Sex;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public Main(){
        Reader reader = new Reader();
        List<Person> personList = reader.readPersonsFromCSV("persons.csv");
//        personList.forEach(action -> System.out.println(action.getName()));

        Filter<Person> filter = person -> person.getSex() == Sex.FEMALE;

        /*for (Person person : personList)
            if (filter.test(person))
                System.out.println(person);*/

        long countOfYoungFemale = personList
                .stream()
                .parallel()
                .filter(person -> person.getSex() == Sex.FEMALE)
                .filter(person -> person.getAge() < 30)
                .count();
        System.out.println(countOfYoungFemale);

        String youngFemaleName = personList
                .stream()
                .parallel()
                .filter(person -> person.getSex() == Sex.FEMALE)
                .filter(person -> person.getAge() < 30)
                .findAny()
                .orElse(new Person("Nobody", Sex.FEMALE, 99))
                .getName();
        System.out.println(youngFemaleName);

        //map can convert data type into stream
        List<Integer> ageList = personList
                .stream()
                .filter(person -> person.getAge() < 30)
                .map(person -> person.getAge())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(ageList);
    }


    public static void main(String args[]){
        new Main();
    }
}
