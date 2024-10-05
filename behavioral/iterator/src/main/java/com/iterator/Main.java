package com.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Iterator is a behavioral design pattern that lets you traverse elements
 * of a collection without exposing its underlying representation
 * (list, stack, tree, etc.)
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 70000));

        Company company = new Company(employees);
        Iterator<Employee> iterator = company.createIterator();

        double totalSalary = 0;
        while (iterator.hasNext()) {
            totalSalary += iterator.next().getSalary();
        }

        System.out.println("Total salary: " + totalSalary);
    }
}

@Data
@AllArgsConstructor
class Employee {
    String name;
    int salary;
}

interface Iterator<T> {
    boolean hasNext();

    T next();
}

interface Aggregate<T> {
    Iterator<T> createIterator();
}

class EmployeeIterator implements Iterator<Employee> {
    private int currentIndex = 0;
    private List<Employee> employees;

    public EmployeeIterator(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < employees.size();
    }

    @Override
    public Employee next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return employees.get(currentIndex++);
    }
}

class Company implements Aggregate<Employee> {
    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Iterator<Employee> createIterator() {
        return new EmployeeIterator(employees);
    }
}