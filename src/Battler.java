import java.util.Random;

public class Battler {
    String name;
    int hp;
    private Random random = new Random();

    public Battler(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void attack(Battler opponent) {
        // Générer des dégâts aléatoires entre 0 et 10
        int damage = random.nextInt(11); // Entre 0 et 10 inclus
        System.out.println(name + " attaque " + opponent.name + " pour " + damage + " points de dégâts !");
        opponent.looseHP(damage);
    }

    public void looseHP(int amount) {
        hp -= amount;
        if (hp < 0) hp = 0;
        System.out.println(name + " a maintenant " + hp + " HP.");
    }

    public boolean isDead() {
        return hp <= 0;
    }
}
