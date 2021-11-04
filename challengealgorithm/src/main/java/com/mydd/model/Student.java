package com.mydd.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    public static ArrayList<Student> sortedCreate(int teamNo, String... names) {
        Arrays.stream(names).sorted(String::compareToIgnoreCase);
        return batchCreate(teamNo, names);
    }
    public static ArrayList<Student> batchCreate(int teamNo, String... names) {
        ArrayList<Student> results = new ArrayList<>();
        for(String name : names) {
            results.add(new Student(teamNo, name));
        }
        return results;
    }

    private String name;
    private int teamNo;
    public Student(int teamNo, String name) {
        this.teamNo = teamNo;
        this.name = name;
    }

    public int key() {
        return teamNo;
    }

    public void setKey(int teamNo) {
        this.teamNo = teamNo;
    }

    public String name() {
        return name;
    }
}
