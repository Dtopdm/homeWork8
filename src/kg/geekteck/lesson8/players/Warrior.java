package kg.geekteck.lesson8.players;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage,SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
           if (heroes[i].getHealth() > 0 && heroes[i] != this) {
               Random r = new Random();
               int criticalDamage = r.nextInt(2) + 2;
                this.setDamage(this.getDamage() + criticalDamage);
           }
        }
    }
}
