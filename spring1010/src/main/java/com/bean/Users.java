package com.bean;

public class Users {

    private String username;

    private Grade grade;


    public void abc(int a){
        System.out.println("abc--"+a);
    }
    public  static String bcd(String b){
        System.out.println("bcd---"+b);
        return "bcd静态方法";
    }








    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
