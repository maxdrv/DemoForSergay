package org.example.demo;

import org.example.demo.model.ComparableStudent;
import org.example.demo.model.Student;
import org.example.demo.model.StudentComparator;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ComparatorTest {

    private final static Student[] STUDENTS_ARRAY = new Student[]{
            new Student(new int[]{3, 2, 4}),
            new Student(new int[]{1, 2, 3})
    };

    private final static List<Student> STUDENT_LIST = Arrays.asList(STUDENTS_ARRAY);

    @Test
    void comparatorAsAClass() {
        Comparator<Student> comparator = new StudentComparator();
        Arrays.sort(STUDENTS_ARRAY, comparator);
        System.out.println(Arrays.toString(STUDENTS_ARRAY));
    }

    @Test
    void comparatorAsAClassV2() {
        StudentComparator comparator = new StudentComparator();
        Arrays.sort(STUDENTS_ARRAY, comparator);
    }

    @Test
    void comparatorAsAnonymousClass() {
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAvgGrade() - o1.getAvgGrade();
            }
        };

        Arrays.sort(STUDENTS_ARRAY, comparator);
    }

    @Test
    void comparatorAsLambdaFunction() {
        Comparator<Student> comparator = (o1, o2) -> o1.getAvgGrade() - o1.getAvgGrade();

        Arrays.sort(STUDENTS_ARRAY, comparator);
    }

    @Test
    void comparatorForList() {
        Comparator<Student> comparator = new StudentComparator();
        Collections.sort(STUDENT_LIST, comparator);
        System.out.println(STUDENT_LIST);
    }

    @Test
    void passComparatorToList() {
        Comparator<Student> comparator = new StudentComparator();

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(new int[]{1}));

        studentList.sort(comparator);
    }

    @Test
    void canNotCompareWithoutComparator() {
        Arrays.sort(STUDENTS_ARRAY);
    }

    @Test
    void canCompareComparableObjects() {
        ComparableStudent[] students = new ComparableStudent[]{
                new ComparableStudent(new int[]{2}),
                new ComparableStudent(new int[]{1})
        };
        Arrays.sort(students);
    }

}
