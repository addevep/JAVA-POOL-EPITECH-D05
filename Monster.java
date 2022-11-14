public abstract class Monster extends Unit{
    protected int damage = 0;
    protected int apcost = 0;

    public int getDamage() {
        return damage;
    }

    protected Monster(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public int getApcost() {
        return apcost;
    }

    @Override
    public boolean equip(Weapon weapon) {
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (this.ap < this.apcost) {
            return false;
        } else if (this.closeTo == fighter && this.ap >= this.apcost) {
            this.ap -= this.apcost;
            fighter.receiveDamage(damage);
            System.out.println(this.getName() + " attacks " + fighter.getName() + ".");
            return true;
        } else {
            System.out.println(this.getName() + ": I'm too far away from " + fighter.getName() + ".");
            return false;
        }
    }
}
