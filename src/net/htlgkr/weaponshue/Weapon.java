package net.htlgkr.weaponshue;

import java.util.Objects;

public class Weapon {
    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private  int minStrength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int minStrength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.minStrength = minStrength;
        this.value = value;
    }

    public static Weapon makeCsvToWeapon(String csvLine){
        String[] line = csvLine.split(";");
        Weapon weapon = new Weapon(
                line[0],
                CombatType.valueOf(line[1]),
                DamageType.valueOf(line[2]),
                Integer.valueOf(line[3]),
                Integer.valueOf(line[4]),
                Integer.valueOf(line[5]),
                Integer.valueOf(line[6])
        );
        return weapon;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weapon weapon = (Weapon) o;

        if (damage != weapon.damage) return false;
        if (speed != weapon.speed) return false;
        if (minStrength != weapon.minStrength) return false;
        if (value != weapon.value) return false;
        if (!Objects.equals(name, weapon.name)) return false;
        if (combatType != weapon.combatType) return false;
        return damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (combatType != null ? combatType.hashCode() : 0);
        result = 31 * result + (damageType != null ? damageType.hashCode() : 0);
        result = 31 * result + damage;
        result = 31 * result + speed;
        result = 31 * result + minStrength;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", combatType=" + combatType +
                ", damageType=" + damageType +
                ", damage=" + damage +
                ", speed=" + speed +
                ", strength=" + minStrength +
                ", value=" + value +
                '}';
    }
}
