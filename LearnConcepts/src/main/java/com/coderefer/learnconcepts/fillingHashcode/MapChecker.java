package com.coderefer.learnconcepts.fillingHashcode;

import java.util.HashMap;

public class MapChecker {
    public static void main(String[] args) {
        HashMap<Employee, Integer> map = new HashMap<>();
        map.put(new Employee(),1);
        map.put(new Employee(),2);
        map.put(new Employee(),3);
        map.put(new Employee(),4);
        System.out.println(map.size());
//        new Employee().check(null);
    }
}
