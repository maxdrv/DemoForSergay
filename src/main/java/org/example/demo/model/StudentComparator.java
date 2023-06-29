package org.example.demo.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        int number = o1.getAvgGrade() - o2.getAvgGrade();

        return number;
    }

}
