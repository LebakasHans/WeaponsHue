package net.htlgkr.weaponshue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    static Comparator<Weapon> alphabeticComparator;

    public static void main(String[] args){
        CsvIO csvIO = new CsvIO();
        ArrayList<Weapon> weaponList = new ArrayList<>(csvIO.readCsv());
        Comparator<Weapon> damageComparator = getDamageComparator();
        Comparator<Weapon> alphabeticComparator = getAlphabeticComparator();

        Printable printable = weapons -> {
            weapons.forEach(weapon -> System.out.println(weapon));
        };
        Printable printAsTable = weapons -> {
            int[] maxLenghts = new int[7];
            ArrayList<String> weaponAsStrings = new ArrayList<>();
            ArrayList<ArrayList<String>> weaponAsStringList = new ArrayList<>(1);
            int counter = 0;
            for (Weapon weapon : weapons) {
                if (weapon.getName().length() > maxLenghts[0]) {
                    maxLenghts[0] = weapon.getName().length();
                }
                if (weapon.getCombatType().toString().length() > maxLenghts[1]) {
                    maxLenghts[1] = weapon.getCombatType().toString().length();
                }
                if (weapon.getDamageType().toString().length() > maxLenghts[2]) {
                    maxLenghts[2] = weapon.getDamageType().toString().length();
                }
                if (Integer.toString(weapon.getDamage()).length() > maxLenghts[3]) {
                    maxLenghts[3] = Integer.toString(weapon.getDamage()).length();
                }
                if (Integer.toString(weapon.getSpeed()).length() > maxLenghts[4]) {
                    maxLenghts[4] = Integer.toString(weapon.getSpeed()).length();
                }
                if (Integer.toString(weapon.getStrength()).length() > maxLenghts[5]) {
                    maxLenghts[5] = Integer.toString(weapon.getStrength()).length();
                }
                if (Integer.toString(weapon.getValue()).length() > maxLenghts[6]) {
                    maxLenghts[6] = Integer.toString(weapon.getValue()).length();
                }

                weaponAsStrings.add(weapon.getName());
                weaponAsStrings.add(weapon.getCombatType().toString());
                weaponAsStrings.add(weapon.getDamageType().toString());
                weaponAsStrings.add(Integer.toString(weapon.getDamage()));
                weaponAsStrings.add(Integer.toString(weapon.getSpeed()));
                weaponAsStrings.add(Integer.toString(weapon.getStrength()));
                weaponAsStrings.add(Integer.toString(weapon.getValue()));

                ArrayList<String> arrayListToAdd = new ArrayList<>();
                arrayListToAdd.addAll(weaponAsStrings);
                weaponAsStringList.add(arrayListToAdd);
                weaponAsStrings.clear();
                ++counter;
            }

            //makes the Strings the same length
            for (int i = 0; i <= maxLenghts.length-1; i++) {
                for (int j = 0; j < weaponAsStringList.size(); j++) {
                    weaponAsStringList.get(j).set(i, lengthenString(maxLenghts[i] + 1, weaponAsStringList.get(j).get(i)));
                }
            }

            //prints the Strings
            weaponAsStringList.forEach(strings -> {
                strings.forEach(s -> System.out.print(s + "|"));
                System.out.println();
                for (int i: maxLenghts) {
                    IntStream.range(0, i+1).forEach(j -> System.out.print("-"));
                    System.out.print("+");
                }
                System.out.println();
            });
        };
        printAsTable.print(weaponList);

        Collections.sort(weaponList, alphabeticComparator);
        printable.print(weaponList);
    }

    public static Comparator<Weapon> getAlphabeticComparator() {
        Comparator<Weapon> alphabeticComparator = (o1, o2) -> {
            int val = o1.getCombatType().toString().compareTo(o2.getCombatType().toString());
            if (val != 0) return val;
            else{
                val = o1.getDamageType().toString().compareTo(o2.getDamageType().toString());
                if (val != 0) return val;
                else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        };
        return alphabeticComparator;
    }

    public static Comparator<Weapon> getDamageComparator() {
        Comparator<Weapon> damageComparator = (o1, o2) -> o2.getDamage() - o1.getDamage();
        return damageComparator;
    }


    private static String lengthenString(int length, String s){
        for (int i = s.length(); i < length; i++) {
            s += " ";
        }
        return s;
    }
}