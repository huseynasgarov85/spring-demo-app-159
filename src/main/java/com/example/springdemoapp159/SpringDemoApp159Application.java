package com.example.springdemoapp159;

import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class SpringDemoApp159Application {

    public static void main(String[] args) {
//        SpringApplication.run(SpringDemoApp159Application.class, args);
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println("first one");
        System.out.println(A.length() + B.length());
        System.out.println("second one");
        if (A.length() > B.length()) {
            System.out.println("yes");
        } else {
            System.out.println("");
        }
        System.out.println("third one");
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                String num = String.valueOf(A.charAt(i)).toUpperCase();
                String geriKalan = A.substring(1).toLowerCase();
                String number = num + geriKalan;
                System.out.println(number);
                String ikinciSayi = String.valueOf(B.charAt(j)).toUpperCase();
                String geriKalanSayi = B.substring(1).toLowerCase();
                String numberSayi =  ikinciSayi + geriKalanSayi;
                System.out.println(numberSayi);
                break;
            }
            break;
        }
    }

}
