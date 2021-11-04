package com.mydd.algorithm.code.topics;

import com.mydd.model.Student;

import java.util.List;

public class KeyIndexedCounting {
    public Student[] KIC(List<Student> inputStudent, int teamTotal) {
        int len = inputStudent.size();
        if (len == 0) return new Student[0];
        int[] count = new int[teamTotal + 1];
        count[0] = 0;
        for(int i = 1; i < len; i++) {
            count[inputStudent.get(i).key() + 1]++;
        }
        for(int i = 1; i < teamTotal + 1; i++) {
            count[i] += count[i - 1];
        }
        Student[] aux = new Student[len];
        for(int i = 0; i < len; i++) {
            aux[count[inputStudent.get(i).key()]++] = inputStudent.get(i);
        }
        return aux;
    }
}
