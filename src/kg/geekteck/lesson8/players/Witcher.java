package kg.geekteck.lesson8.players;

import java.util.Random;

public class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage,SuperAbility.REVIVE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
           if (heroes[i].getHealth() > 0 && heroes[i] != this) {
               heroes[i].setHealth(this.getHealth());
               this.setHealth(0);
           }
        }
    }
}
