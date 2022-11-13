package com.automation.framework.reusables;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class JavaUtils {

    public static void getCurrentDate(){
        Date date = new Date();
        System.out.println(date);
    }

    public static void getCurrentDate(String format){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String newFormattedDate =sdf.format(date);
        System.out.println(newFormattedDate);
    }

    public static String getDate(){
        LocalDateTime now= LocalDateTime.now();
        System.out.println(now);
        String formattedDate= now.getMonthValue() + "/" + now.getDayOfMonth() + "/" + now.getYear();
        System.out.println(formattedDate);
        return formattedDate;
    }

//    public static String getFutureDate(int day, int month, int year){
//        LocalDateTime now= LocalDateTime.now();
//        now = now.plusDays(day).plusMonths(month).plusYears(year);
//        String formattedDate = now.getMonthValue() + "/" + now.getDayOfMonth() + "/" + now.getYear();
//        return formattedDate;
//    }

    public static LocalDateTime getFutureDate(int day, int month, int year){
        LocalDateTime now = LocalDateTime.now();
        now = now.plusDays(day).plusMonths(month).plusYears(year);
        return now;
    }

    public static String getPastDate(int day, int month, int year){
        LocalDateTime now= LocalDateTime.now();
        now = now.minusDays(day).minusMonths(month).minusYears(year);
        String formattedDate = now.getMonthValue() + "/" + now.getDayOfMonth() + "/" + now.getYear();
        return formattedDate;
    }

    public static int getDayFromDate(LocalDateTime dateTime){
        return dateTime.getDayOfMonth();
    }

    public static String getMonthFromDate(LocalDateTime dateTime){
        String date = dateTime.getMonth().toString(); //UpperCase
        String firstDateChar = date.substring(0,1);
        String secondDateChar = date.substring(1);
        secondDateChar = secondDateChar.toLowerCase();
        date = firstDateChar+secondDateChar;
        return date;
    }

    public static int getYearFromDate(LocalDateTime dateTime){
        return dateTime.getYear();
    }



    @Test
    public static void main(String[] args) {
        JavaUtils.getCurrentDate("MM/dd/yyyy hh:mm:ss");
        LocalDateTime dateTime = JavaUtils.getFutureDate(5,5,5);
        System.out.println(getMonthFromDate(dateTime));
    }
}
