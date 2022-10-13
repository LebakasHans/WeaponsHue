package net.htlgkr.student;

import net.htlgkr.weaponshue.DamageType;
import net.htlgkr.weaponshue.Weapon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(Double.NaN);
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(s -> s.toUpperCase()).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).orElse(null);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(weapon -> weapon.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing(weapon -> weapon.getName().length())).orElse(null);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(Weapon::getName).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::getSpeed).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::getValue).reduce(0,(x, y) -> x +y );
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::hashCode).reduce(0,(x, y) -> x +y );
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.forEach(w -> w.setValue((int) (w.getValue() * 1.1D)));;
    }

}
