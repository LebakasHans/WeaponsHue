package net.htlgkr.IntStream;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args){
        final IntPredicate isEven = i -> i % 2 == 0;


        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(isEven.negate())
                .map(operand -> operand*operand)
                .reduce(0,(x, y) -> x+y);

        System.out.println(result);
    }
}
