package efs.task.oop;

public class Monsters {
    static final Monster andariel  = new Monster(10,70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            int monsterHealth = this.getHealth();
            monsterHealth -= damage;
            this.setHealth(monsterHealth);
            Monsters.monstersHealth -= damage;
        }
    };

    static final Monster blacksmith  = new Monster(100,25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            int monsterHealth = this.getHealth();
            monsterHealth -= (5 + damage);
            this.setHealth(monsterHealth);
            Monsters.monstersHealth -= (5 + damage);
        }
    };

    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();
}
