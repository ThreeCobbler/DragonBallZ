package com.dragon.demo.lambda;


import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ljn
 * @date 2019/6/6.
 */
public class EncodeUrl {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String param = URLEncoder.encode("Helloworld", "UTF-8");
        System.out.println(param);

        Scanner s = new Scanner(System.in);
        boolean b = s.hasNextInt();
        String next = s.next();
        if (StringUtils.isNumeric(next)) {
            System.out.println(next);
        }else {
            System.out.println("no int");
        }

        int[] arr = new int[]{1, 2, 5};
        List list = Arrays.asList(arr);
//        list = new ArrayList<>(list);
        list.add(8);

    }
}
