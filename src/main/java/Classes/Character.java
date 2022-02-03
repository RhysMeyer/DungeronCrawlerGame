package Classes;


abstract class Character {

    private int maxHealth;
    private int health;
    private int damage;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth(int health) {
        return health;
    }
    public int getMaxHealth(int maxHealth) {
        return maxHealth;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }



}
