package com.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java!");

        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("Kafka");
        skills.add("Git");
        skills.add("Postgre SQL");
        Profile myProfile = new Profile("Никита", "Аверьянов", "Разработчик Java", skills);

        System.out.println("Tests:");
        System.out.println(myProfile);
        skills.add("C#");
        System.out.println(myProfile);
        List<String> profileSkills = myProfile.getSkills();
        try {
            profileSkills.add("JavaScript");
        } catch (Exception e) {
            System.out.println("profileSkills.add(\"JavaScript\") => " + e);
        } finally {
            System.out.println(myProfile);
        }
    }
}