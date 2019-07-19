package com.dragon.demo.unmodifiable;

/**
 * @author ljn
 * @date 2019/7/18.
 */
public class Demo {

    public static void main(String[] args) {

        int i = 0;
        for(;;) {
            i++;
            System.out.println(i);
            if (i == 5) {
                return;
            }
        }

//        Map<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        Map<String, String> stringMap = Collections.unmodifiableMap(map);
//        map.put("1", "2");
//        System.out.println(stringMap);
    }
}
