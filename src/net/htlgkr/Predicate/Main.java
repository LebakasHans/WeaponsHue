package net.htlgkr.Predicate;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args){
        final Predicate<Integer> isEven = i -> i % 2 == 0;
        final Predicate<Integer> isPositive = i -> i > 0;
        final Predicate<Integer> isZero = i -> i == 0;
        final Predicate<Integer> isNull = i -> i == null;
        final Predicate<String> isShortWord = s -> s.length() < 4;


        System.out.println(isPositive.and(isEven).test(3));
        System.out.println(isPositive.and(isEven).test(-3));
        System.out.println(isPositive.and(isEven).test(4));
        System.out.println(isPositive.and(isEven).test(-4));

        System.out.println("------------------------------");

        System.out.println(isPositive.and(isEven.negate()).test(3));
        System.out.println(isPositive.and(isEven.negate()).test(-3));
        System.out.println(isPositive.and(isEven.negate()).test(4));
        System.out.println(isPositive.and(isEven.negate()).test(-4));
    }
}
