package kg.geekteck.lesson8.players;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
           if (heroes[i].getHealth() > 0) {
               Random r = new Random();
               int boost = r.nextInt(19) +1;
               heroes[i].setDamage(heroes[i].getDamage() + boost);
           }
        }
    }
}
