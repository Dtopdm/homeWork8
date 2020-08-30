package kg.geekteck.lesson8.players;

import java.util.Random;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage,SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i] !=this) {
                Random r = new Random();
                int revert = r.nextInt(19) + 1;
                boss.setHealth(boss.getHealth() - (this.getDamage() + revert));
            }
        }
    }
}
