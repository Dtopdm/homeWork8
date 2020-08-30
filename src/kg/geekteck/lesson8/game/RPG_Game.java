package kg.geekteck.lesson8.game;

import kg.geekteck.lesson8.players.*;

public class RPG_Game {
    public static void startGame() {
        Boss boss = new Boss(700, 50);
        Warrior warrior = new Warrior(260, 20);
        Medic doctor = new Medic(220, 0, 20);
        Magic magic = new Magic(240, 15);
        Medic assistant = new Medic(200, 20, 10);
        Golem golem = new Golem(250, 10);
        Thor thor = new Thor(200, 20);
        Hunter hunter = new Hunter(260, 5);
        Witcher witcher = new Witcher(200, 0);

        Hero[] heroes = {warrior, doctor, magic, assistant, golem, thor, hunter, witcher};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss,heroes)){
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
        bossHits(boss, heroes);}
        heroesHit(boss, heroes);
        applySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("-------------------");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health:"
                    + heroes[i].getHealth());
        }
        System.out.println("-------------------");
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
           if (heroes[i].getHealth() >0 && boss.getHealth() > 0) {
               boss.setHealth(boss.getHealth() - heroes[i].getDamage());
           }
        }
    }

    private static void applySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() >0  ) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }
}
