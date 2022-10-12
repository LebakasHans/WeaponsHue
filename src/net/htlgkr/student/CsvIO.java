package net.htlgkr.student;

import net.htlgkr.weaponshue.Weapon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvIO {
    private final String FILE = "weapons.csv";

    public List<net.htlgkr.weaponshue.Weapon> readCsv(){
        List<net.htlgkr.weaponshue.Weapon> weaponList= new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(FILE))) {

            //I don´t know how else to remove the first line without changing csv itself
            List<String> temp = stream.collect(Collectors.toList());
            temp.remove(0);

            weaponList = temp.stream().map(s -> Weapon.makeCsvToWeapon(s)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weaponList;
    }
}
