package com.niloy.lamda.io;

import com.niloy.lamda.model.Person;
import com.niloy.lamda.model.Sex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public Reader(){

    }
    public List<Person> readPersonsFromCSV(String filename){

        List<Person> personList = new ArrayList<Person>();

        try {
            InputStream inputStream = new FileInputStream(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split("\\,");
                /*for (String token : tokens)
                    System.out.println(token);*/

                String name = tokens[0];
                Sex sex = Sex.valueOf(tokens[1].toUpperCase());
                int age = Integer.valueOf(tokens[2]);

                Person person = new Person(name, sex, age);

                personList.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
