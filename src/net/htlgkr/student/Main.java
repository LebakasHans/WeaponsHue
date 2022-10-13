package net.htlgkr.student;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] randInt = new int[10000];
        Random r = new Random();
        for (int i = 0; i < randInt.length; i++) {
            randInt[i] = r.nextInt(101);
        }
        Streams streams = new Streams();
        System.out.println(streams.average(randInt));

        String[] randString = new String[10];

        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        for (int i = 0; i < randString.length; i++) {
            randString[i] = "";
            for (int j = 0; j < 10; j++) {
                randString[i] += alphabet.charAt(r.nextInt(51));
            }
        }

        randString = Arrays.stream(randString).map(String::toUpperCase).toArray(String[]::new);
        System.out.println();
    }
}
