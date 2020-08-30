package kg.geekteck.lesson8.players;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter(int health, int damage) {
        super(health, damage,SuperAbility.TAKE_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
           if (heroes[i] != this) {
                heroes[i].setHealth(heroes[i].getHealth() + (boss.getDamage() / 5));
                this.setHealth(this.getHealth() - (boss.getDamage() / 5));
           }
        }
    }
}
