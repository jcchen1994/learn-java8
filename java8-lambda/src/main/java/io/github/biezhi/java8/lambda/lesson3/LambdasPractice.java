package io.github.biezhi.java8.lambda.lesson3;

import io.github.biezhi.java8.lambda.lesson1.Project;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
    public static void m1()
    {
        System.out.println(1);
    }
    public static void main(String[] args) {
        Function<String,String> function=Function.identity();
        String result=function.andThen(LambdasPractice::addAuthor).andThen(LambdasPractice::addCountry)
                .apply("test");
        System.out.print(result);
        //方法为自身方法时，可以为无参数方法
        Consumer<String> consumer=String::toLowerCase;
        //方法为外部方法时，需返回值，参数值相匹配
        Consumer<String> consumer1= System.out::print;


    }
}
