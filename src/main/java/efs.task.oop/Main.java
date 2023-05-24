package efs.task.oop;

import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int index;
        int j = 0;
        int villagersAlive = 5;
        ArrayList<Villager> arrayVillagers = new ArrayList<>(5);
        arrayVillagers.add(new Villager("Kashya",30));
        arrayVillagers.add(new Villager("Akara",40));
        arrayVillagers.add(new Villager("Gheed",50));
        arrayVillagers.add(new Villager("Warriv",35));
        arrayVillagers.add(new Villager("Flawia",25));
        ArrayList<Villager> arrayVillagersDead = new ArrayList<>(5);
        for(int i = 0; i < arrayVillagers.size(); i++){
            arrayVillagers.get(i).sayHello();
        }

        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);



        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        deckardCain.sayHello();
        akara.sayHello();

        int monsterIndex;
        while(Monsters.monstersHealth > 0 && villagersAlive > 0) {
            int maxAttackers = (j % 4 == 0) ? 1 : 2;

            for(int i = 0; i < maxAttackers; i++) {
                Villager villager = getLivingVillager(arrayVillagers);
                Monster targetMonster = getLivingMonster();
                if(targetMonster != null && villager != null){
                    villager.attack(targetMonster);
                    System.out.println("Aktualnie walczacy osadnik to " + villager.getName());

                }
            }

            for(int i = 0; i < 2; i++) {
                Monster monster = getLivingMonster();
                Villager targetVillager = getLivingVillager(arrayVillagers);
                if(monster != null && targetVillager != null){
                    monster.attack(targetVillager);

                    if(targetVillager.getHealth() <= 0){
                        System.out.println(targetVillager.getName() + " nie zyje");
                        arrayVillagers.remove(targetVillager);
                        villagersAlive--;
                    }
                }
            }

            if(villagersAlive == 0){
                System.out.println("Osadnicy nie żyją.");
                break;
            }

            System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");
            j++;
        }

        System.out.println("Obozowisko ocalone!");
        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        deckardCain.sayHello();
        akara.sayHello();
    }

    private static Villager getLivingVillager(ArrayList<Villager> villagersAlive) {
        Random random = new Random();
        Villager vil;
        int index;
        do{
            index = random.nextInt(villagersAlive.size());
            vil = villagersAlive.get(index);
        }while(vil.getHealth() <= 0);

        return vil;
    }

    private static Monster getLivingMonster() {
        Random random = new Random();
        int index;
        index = random.nextInt(2);
        if(index == 0 && Monsters.andariel.getHealth() > 0)
        return Monsters.andariel;
        else
            return Monsters.blacksmith;
    }
}