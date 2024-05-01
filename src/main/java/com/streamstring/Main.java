package com.streamstring;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        String str1 = "Hello World";
        System.out.println("My first string : "+str1);
        String str2 = "This is my happy world";
        System.out.println("str2::--"+str2.hashCode());
        String result = str1 + str2;
        System.out.println(result);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hey").append(" ").append("My Name is Pratyasha.");

        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1).append(" : ").append(str2);
        System.out.println("stringbuilder-:: "+stringBuilder1.hashCode());

        System.out.println("Concatenation of string using stringBuilder by String creation using StringBuilder:: "+stringBuilder);

        System.out.println("Concatenation of string using stringBuilder by using String Class:: "+stringBuilder1);

        System.out.println("reversed string"+stringBuilder.reverse());

        stringBuilder1.append("hey User");
        System.out.println("stringbuilder-:: "+stringBuilder1.hashCode());

        String reversedStr = "";
        for(int i = str1.length()-1;i>=0;i--){
            reversedStr += str1.charAt(i);
        }
        System.out.println(reversedStr);
        str2 = "Hello World";
        System.out.println("str2 after change of string::--"+str2.hashCode());
        System.out.println(str1.equals(str2));

        System.out.println(str1.compareTo(str2));

        System.out.println(stringBuilder.compareTo(stringBuilder1));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder);

        System.out.println(stringBuilder.compareTo(stringBuilder2));
        System.out.println(stringBuilder.equals(stringBuilder2));

        System.out.println(str1+""+str1.indexOf("o"));

        System.out.println(stringBuilder+" "+stringBuilder.indexOf("ratyasha"));

        String value = "rotator";
        String reverseValue = checkIfPallindrome(value);
        if (value.equals(reverseValue)) {
            System.out.println("The string " + value + " is a pallindrome.");
        } else {
            System.out.println("The string " + value + " is not a pallindrome.");
        }

        String checkStr = "madam";
        String checkStr2 = "hello";

        System.out.println(checkStr + " is a palindrome: " + checkIfPallindromUsingStringBuilder(checkStr));
        System.out.println(checkStr2 + " is a palindrome: " + checkIfPallindromUsingStringBuilder(checkStr2));

        String strVal1=new String("Scaler");
        String strVal2=new String("Scaler");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        String[] strArr = {"hello","pratyasha","sachin"};
        String convertedString = convertArrayToString(strArr);
        System.out.println("COnverted array to string::"+ convertedString);

        String strTocheck= "InterviewBit";
        char ch = 'i';
        int count = 0;
        int result1 = countTheNumberOfCharacters(strTocheck,ch,count);
        System.out.println("No of characters of "+ ch+" is : "+result1);

        List<Student> studentList = Arrays.asList(new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        System.out.println("students::"+studentList);

        List<Student> fnStartsWith = studentList.stream().filter(eachStud -> eachStud.getFirstName().startsWith("A")).collect(Collectors.toList());
        System.out.println("students whose name starts with capital A::"+fnStartsWith.size());

        long totalStudents = studentList.stream().count();
        System.out.println("total no of students::"+totalStudents);

        Map<String,List<Student>> groupedByDept = studentList.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println("dept by grouping:: "+groupedByDept);

        Optional<Student> maxAge = studentList.stream().max(Comparator.comparingInt(Student::getAge));
        System.out.println(maxAge);

        List<String> deptNames = studentList.stream().map(eachStud-> eachStud.getDepartmantName()).distinct().collect(Collectors.toList());
        System.out.println(deptNames);
        deptNames.stream().forEach(dept -> System.out.println("Dept Name: "+dept));

        Map<String,Long> countInEachDept = studentList.stream().collect(Collectors.groupingBy(student -> student.getDepartmantName(),Collectors.counting()));
        System.out.println(countInEachDept);

        for (String key: countInEachDept.keySet()
             ) {
            System.out.println("Count in Dept "+key+ " is  "+ countInEachDept.get(key));
        }

        List<Student> countAgeLess = studentList.stream().filter(stud-> stud.getAge() < 30).collect(Collectors.toList());
        System.out.println("Students less than age 30");
        countAgeLess.stream().forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()+" : "+student.getAge()));

        List<Student> rankBt = studentList.stream().filter(stud-> stud.getRank() >= 50 && stud.getRank() <=100).collect(Collectors.toList());
        System.out.println("Students rank is in between 50 and 100");
        rankBt.stream().forEach(student -> System.out.println(student.getFirstName()+" "+student.getLastName()+" : "+student.getRank()));
    }

    private static int countTheNumberOfCharacters(String strTocheck, char ch,int count) {
        for (int i =0;i<strTocheck.length();i++){
            if(Character.toLowerCase(strTocheck.charAt(i)) == Character.toLowerCase(ch)){
                count++;
            }
        }
        return count;
    }

    private static String convertArrayToString(String[] strArrParam){
        return Arrays.toString(strArrParam);
    }

    private static String checkIfPallindrome(String str){
        String reverseStr = "";
        for(int i = str.length()-1;i>=0;i--){
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }

    private static Boolean checkIfPallindromUsingStringBuilder(String str){
        StringBuilder sb = new StringBuilder(str);
        StringBuilder reverseSb = sb.reverse();

        return str.equals(reverseSb.toString());
    }
}