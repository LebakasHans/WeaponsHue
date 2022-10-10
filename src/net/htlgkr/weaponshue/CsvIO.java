package net.htlgkr.weaponshue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvIO {
    private final String FILE = "weapons.csv";

    public List<Weapon> readCsv(){
        List<Weapon> weaponList= new ArrayList<>();
        String line;
        try {
            Scanner sc = new Scanner((new File(FILE)));
            line = sc.nextLine();
            while (sc.hasNext()){
                line = sc.nextLine();
                weaponList.add(Weapon.makeCsvToWeapon(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return weaponList;
    }
}
