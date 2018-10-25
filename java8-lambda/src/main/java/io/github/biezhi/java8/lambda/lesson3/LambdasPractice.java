package io.github.biezhi.java8.lambda.lesson3;

import java.util.function.Function;

public class LambdasPractice {
    public static  String toLower(String s)
    {
        return s.toLowerCase();
    }
    public  static  String addAuthor(String s)
    {
        return s+"\n"+"author:chen";
    }
    public static  String addCountry(String s)
    {
        return  s+"\n"+"China";
    }

    public static void main(String[] args) {
        Function<String,String> function=Function.identity();
        String result=function.andThen(LambdasPractice::addAuthor).andThen(LambdasPractice::addCountry)
                .apply("test");
        System.out.print(result);


    }
}
