package com.dragon.demo.compare;

import com.dragon.demo.Role;

import java.util.*;

/**
 * @author ljn
 * @date 2019/6/14.
 * TreeSet与TreeMap去重自定义比较器
 */
public class MyComparator {



    static Comparator comparator = new Comparator<Role>() {
        @Override
        public int compare(Role o1, Role o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };


    public static void main(String[] args) {
//        Set<Role> set = new TreeSet<Role>(new Comparator<Role>() {
//            @Override
//            public int compare(Role o1, Role o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Set<Role> set = new TreeSet<Role>(comparator);
        Role role = new Role();
        role.setId(1L);
        role.setName("jack");
        Role role2 = new Role();
        role2.setId(2L);
        role2.setName("lucy");
        Role role3 = new Role();
        role3.setId(3L);
        role3.setName("lucy");
        set.add(role);
        set.add(role2);
        set.add(role3);
        System.out.println(set);

        Map<Role, Long> map = new TreeMap<>(comparator);
        map.put(role, role.getId());
        map.put(role2, role2.getId());
        map.put(role3, role3.getId());
        System.out.println(map);
    }
}
