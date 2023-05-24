package efs.task.oop;

public class Villager implements Fighter{
    protected int age;
    private String name;

    protected int health = 100;

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }


    public Villager(String name, int age){
        this.name = name;
        this.age = age;
    }
    public boolean isDead(){

        return this.health <= 0;
    }

    public void sayHello(){
        System.out.print("\nGreetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }

    @Override
    public void attack(Fighter victim) {
        int damage = (int) ((100 - age * 0.5) / 10);
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        this.health -= damage;
    }


}
