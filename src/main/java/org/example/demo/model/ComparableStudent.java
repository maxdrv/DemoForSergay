package org.example.demo.model;

public class ComparableStudent implements Comparable<ComparableStudent>{

    private int[] grades;

    public ComparableStudent(int[] grades) {
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
    public int compareTo(ComparableStudent o) {
        return this.getAvgGrade() - o.getAvgGrade();
    }
}
