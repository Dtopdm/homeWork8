package kg.geekteck.lesson8.players;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage,SuperAbility.DEAF);
    }

    public static boolean skipRound = false;

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
       Random r = new Random();
       int deaf = r.nextInt(1) + 1;
       if (deaf == 1) {
           skipRound = true;
       } else {
           skipRound = false;
       }
           }
        }
