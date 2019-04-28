package com.dragon.demo;

import java.util.*;

/**
 * @author ljn
 * @date 2019/4/8.
 */
public class ListTest {

    private  String a ;
    private Test test;
    private String b;

    private Integer c;

    public static void main(String[] args) {
        List list = Collections.synchronizedList(new LinkedList<>());
        List list2= new Vector<>();
        Map<String,Object> map = new HashMap<>();
        map.containsKey("s");
        Set<String> strings = map.keySet();
        Object[] objects = map.values().toArray();
        List list3 = new ArrayList<>(map.values());
        list3.isEmpty();
        Map<String,Object> treemap = new TreeMap<>(map);
        String s = "s  tr in  g";
        System.out.println(s.length());
        String s1 = s.replaceAll("  ", " ");
        System.out.println(s1);
        System.out.println(s1.length());

    }

    public String getA() {
        return a;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getB() {
        return b;
    }

    public Integer getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListTest listTest = (ListTest) o;

        if (a != null ? !a.equals(listTest.a) : listTest.a != null) return false;
        if (test != null ? !test.equals(listTest.test) : listTest.test != null) return false;
        if (b != null ? !b.equals(listTest.b) : listTest.b != null) return false;
        return c != null ? c.equals(listTest.c) : listTest.c == null;

    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }
}
