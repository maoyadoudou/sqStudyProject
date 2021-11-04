package com.mydd.algorithm.code.topics;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TryThisWord extends AbstractList {
    List<Integer> stringList = new ArrayList<>();
    Integer[] strings;

    public List<String> getList(Integer[] strings) {
        this.strings = strings;
        return this;
    }

    public TryThisWord() {

    }

    @Override
    public Object get(int index) {
        System.out.println("get" + index);
        return stringList.get(index);
    }

    @Override
    public int size() {
        if (stringList.size() == 0) {
            for (Integer item : strings) {
                stringList.add(item);
            }
            System.out.println("里size");
        }
        System.out.println("外size");
        System.out.println(this.getClass().getName());
        return stringList.size();
    }

    public static void main(String[] args) {
        List<String> list = new TryThisWord().getList(new Integer[]{1, 2, 3});
        System.out.println("finish");
    }
}
