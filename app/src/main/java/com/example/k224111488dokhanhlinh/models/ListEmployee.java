package com.example.k224111488dokhanhlinh.models;

import java.util.ArrayList;
import java.util.List;

public class ListEmployee {
    private List<Employee> employees;

    public ListEmployee() {

        employees=new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void generate_sample_dataset()
    {
        Employee e1=new Employee();
        e1.setName("John");
        e1.setEmail("john@gmail.com");
        e1.setUsername("John");
        e1.setPassword("123");
        employees.add(e1);

        Employee e2=new Employee();
        e2.setName("Peter");
        e2.setEmail("peter@gmail.com");
        e2.setUsername("Peter");
        e2.setPassword("456");
        employees.add(e2);

        Employee e3=new Employee();
        e3.setName("Tom");
        e3.setEmail("tom@gmail.com");
        e3.setUsername("Tom");
        e3.setPassword("789");
        employees.add(e3);

        Employee e4 = new Employee();
        e4.setName("Alice");
        e4.setEmail("alice@gmail.com");
        e4.setUsername("Alice");
        e4.setPassword("111");
        employees.add(e4);

        Employee e5 = new Employee();
        e5.setName("Bob");
        e5.setEmail("bob@gmail.com");
        e5.setUsername("Bob");
        e5.setPassword("222");
        employees.add(e5);

        Employee e6 = new Employee();
        e6.setName("Charlie");
        e6.setEmail("charlie@gmail.com");
        e6.setUsername("Charlie");
        e6.setPassword("333");
        employees.add(e6);

        Employee e7 = new Employee();
        e7.setName("Diana");
        e7.setEmail("diana@gmail.com");
        e7.setUsername("Diana");
        e7.setPassword("444");
        employees.add(e7);

        Employee e8 = new Employee();
        e8.setName("Ethan");
        e8.setEmail("ethan@gmail.com");
        e8.setUsername("Ethan");
        e8.setPassword("555");
        employees.add(e8);

        Employee e9 = new Employee();
        e9.setName("Fiona");
        e9.setEmail("fiona@gmail.com");
        e9.setUsername("Fiona");
        e9.setPassword("666");
        employees.add(e9);

        Employee e10 = new Employee();
        e10.setName("George");
        e10.setEmail("george@gmail.com");
        e10.setUsername("George");
        e10.setPassword("777");
        employees.add(e10);
    }
}
