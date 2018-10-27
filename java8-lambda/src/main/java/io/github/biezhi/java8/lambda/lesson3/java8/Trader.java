package io.github.biezhi.java8.lambda.lesson3.java8;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
