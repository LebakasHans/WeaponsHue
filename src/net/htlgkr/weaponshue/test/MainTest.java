package net.htlgkr.weaponshue.test;

import net.htlgkr.weaponshue.Main;
import net.htlgkr.weaponshue.Weapon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void getAlphabeticComparator() {
        Comparator<Weapon> alphabeticComparator = Main.getAlphabeticComparator();

        Weapon weapon1 = Weapon.makeCsvToWeapon("Crom Faeyr;MELEE;BLUNT;16;1;25;15500");
        Weapon weapon2 = Weapon.makeCsvToWeapon("Broken Weapon;NONE;NONE;0;0;0;0");
        Weapon weapon3 = Weapon.makeCsvToWeapon("Boomerang Dagger;RANGED;PIERCING;10;1;3;3500");
        Weapon weapon4 = Weapon.makeCsvToWeapon("Long Sword +1;MELEE;SLASHING;9;4;6;1250");
        Weapon weapon5 = Weapon.makeCsvToWeapon("Kundane;MELEE;SLASHING;8;0;5;4000");

        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(weapon1);
        weapons.add(weapon2);
        weapons.add(weapon3);
        weapons.add(weapon4);
        weapons.add(weapon5);

        Collections.sort(weapons, alphabeticComparator);
        boolean result = false;

        if (
              weapons.get(0).equals(weapon1) &&
              weapons.get(1).equals(weapon5) &&
              weapons.get(2).equals(weapon4) &&
              weapons.get(3).equals(weapon2) &&
              weapons.get(4).equals(weapon3)
        ){
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void getDamageComparator() {
        Comparator<Weapon> damageComparator = Main.getDamageComparator();

        Weapon weapon1 = Weapon.makeCsvToWeapon("Crom Faeyr;MELEE;BLUNT;16;1;25;15500");
        Weapon weapon2 = Weapon.makeCsvToWeapon("Broken Weapon;NONE;NONE;0;0;0;0");
        Weapon weapon3 = Weapon.makeCsvToWeapon("Boomerang Dagger;RANGED;PIERCING;10;1;3;3500");
        Weapon weapon4 = Weapon.makeCsvToWeapon("Long Sword +1;MELEE;SLASHING;9;4;6;1250");
        Weapon weapon5 = Weapon.makeCsvToWeapon("Kundane;MELEE;SLASHING;8;0;5;4000");

        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(weapon1);
        weapons.add(weapon2);
        weapons.add(weapon3);
        weapons.add(weapon4);
        weapons.add(weapon5);

        Collections.sort(weapons, damageComparator);
        boolean result = false;

        if (
                weapons.get(0).equals(weapon1) &&
                        weapons.get(1).equals(weapon3) &&
                        weapons.get(2).equals(weapon4) &&
                        weapons.get(3).equals(weapon5) &&
                        weapons.get(4).equals(weapon2)
        ){
            result = true;
        }
        assertTrue(result);
    }
}