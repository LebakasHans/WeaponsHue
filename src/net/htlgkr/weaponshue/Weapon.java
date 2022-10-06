package net.htlgkr.weaponshue;

public class Weapon {
    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private  int strength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
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
}
