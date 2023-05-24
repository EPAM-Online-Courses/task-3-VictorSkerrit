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
        while(Monsters.monstersHealth > 0 || villagersAlive == 0) {
            Villager villager;

            if(j % 4 == 0){
                do {
                    villager = arrayVillagers.get(random.nextInt(villagersAlive));
                } while (villager.isDead());
                System.out.println("Aktualnie walczacy osadnik to " + villager.getName());
                monsterIndex = random.nextInt(2);
                if(monsterIndex == 1 && Monsters.andariel.getHealth() > 0){
                    villager.attack(Monsters.andariel);
                }
                else if(monsterIndex == 0 && Monsters.blacksmith.getHealth() > 0){
                    villager.attack(Monsters.blacksmith);
                }
            }
            else{
                for(int i = 0; i < 2; i++) {
                    do {
                        villager = arrayVillagers.get(random.nextInt(villagersAlive));
                    } while (villager.isDead());
                    System.out.println("Aktualnie walczacy osadnik to " + villager.getName());
                    monsterIndex = random.nextInt(2);
                    if(monsterIndex == 1 && Monsters.andariel.getHealth() > 0){
                        villager.attack(Monsters.andariel);
                        if(Monsters.andariel.getHealth() <= 0){
                            System.out.println("Andariel nie zyje");

                        }
                    }
                    else if(monsterIndex == 0 && Monsters.blacksmith.getHealth() > 0){
                        villager.attack(Monsters.blacksmith);
                        if(Monsters.blacksmith.getHealth() <= 0){
                            System.out.println("Blacksmith nie zyje");

                        }
                    }
                }
            }
            for(int k = 0; k < 2; k++) {
                do {
                    monsterIndex = random.nextInt(2);
                } while ((monsterIndex == 0 && Monsters.blacksmith.getHealth() > 0) && (monsterIndex == 1 && Monsters.andariel.getHealth() > 0));
                if(monsterIndex == 1 && Monsters.andariel.getHealth() > 0){
                    villager = arrayVillagers.get(random.nextInt(villagersAlive));
                    Monsters.andariel.attack(villager);
                    if(villager.getHealth() <= 0){
                        System.out.println( villager.getName() + " nie zyje");
                        arrayVillagers.remove(villager);
                        arrayVillagers.add(villager);
                        villagersAlive--;
                    }
                }
                else if(monsterIndex == 0 && Monsters.blacksmith.getHealth() > 0){
                    villager = arrayVillagers.get(random.nextInt(arrayVillagers.size()));
                    Monsters.blacksmith.attack(villager);
                    if(villager.getHealth() <= 0){
                        System.out.println( villager.getName() + " nie zyje");
                        arrayVillagers.remove(villager);
                        arrayVillagers.remove(villager);
                        arrayVillagers.add(villager);
                        villagersAlive--;
                    }
                }
                if(villagersAlive == 0){
                    System.out.println("Osadnicy nie żyją.");
                    return;
                }
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
}