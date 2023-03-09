package com.Controller;



import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Test {  
public static void main(String[] args) {  
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
    Date date = new Date();  
    System.out.println(formatter.format(date).getClass().getName());  
}  
}  
