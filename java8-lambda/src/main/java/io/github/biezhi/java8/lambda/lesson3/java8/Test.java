package io.github.biezhi.java8.lambda.lesson3.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //找出发生在2011年的所有交易，并由低到高排序
        transactions.stream()
                    .filter(t->t.getYear()==2011)
                    .sorted((x,y)->y.getValue()-x.getValue())
                    .forEach(t-> System.out.println("year:"+t.getYear()+" "
                    +"trader:"+t.getTrader().getName()+" "+"value:"
                    +t.getValue()));
        //查找来自剑桥的交易员，并按姓名排序
        transactions.stream()
                    .filter(t->t.getTrader().getCity().equals("Cambridge"))
                    .distinct().sorted(
                                        Comparator.comparing(x -> x.getTrader().getName())
                                      )
                                .forEach(t->System.out.println(t.getTrader().getName()));
        String names=transactions.stream()
                                 .map(Transaction::getTrader)
                                 .sorted(Comparator.comparing(Trader::getName))
                    .map(Trader::getName)
                    .distinct()
                    .reduce("",(n1,n2)->n1+n2);
        System.out.println(names);

        boolean milan=transactions.stream()
                                  .map(t->t.getTrader().getCity())
                                  .distinct()
                                  .anyMatch(s->s.equals("Milan"));
        System.out.print(milan);

        transactions.stream()
                    .filter(t->t.getTrader().getName().equals("Cambridge"))
                    .forEach(s->System.out.print(s.getValue()));
        Optional<Integer> i=transactions.stream()
                    .map(Transaction::getValue)
                    .max(Integer::compareTo);
        System.out.print(i.get());

        transactions.stream()
                    .map(Transaction::getValue)
                    .reduce((x,y)->x>y?y:x);



    }
}
