package org.example.demo.model;

public class Student {

    private int[] grades;

    public Student(int[] grades) {
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }

    public int getAvgGrade() {
        if (grades.length == 0) {
            return 0;
        }
        int avg = 0;
        for (int grade : grades) {
            avg += grade;
        }
        return avg / grades.length;
    }

    @Override
    public String toString() {
        return "Student{" +
                "avg=" + getAvgGrade() +
                '}';
    }
}
