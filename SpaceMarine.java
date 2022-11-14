public abstract class SpaceMarine extends Unit {
    protected Weapon weapon = null;

    public Weapon getWeapon() {
        return weapon;
    }

    protected SpaceMarine(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    @Override
    public boolean equip(Weapon weapon) {
        if (this.weapon == null) {
            this.weapon = weapon;
            System.out.println(this. getName() + " has been equipped with a " + weapon.getName()+ ".");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (this.weapon == null) {
            System.out.println(this.getName() + ": Hey, this is crazy. I'm not going to fight this empty-handed.");
            return false;
        } else if (this.weapon.isMelee() && this.closeTo != fighter) {
            System.out.println(this.getName() + ": I'm too far away from " + fighter.getName() + ".");
            return false;
        } else if(!this.weapon.isMelee() || this.weapon.isMelee() && this.closeTo == fighter) {
            if (this.ap >= this.weapon.getApcost()) {
                this.ap -= this.weapon.getApcost();
                System.out.println(this.getName() + " attacks " + fighter.getName() + " with a " + this.weapon.getName() + ".");
                this.weapon.attack();
                fighter.receiveDamage(this.weapon.getDamage());
            }
        }
        return false;
    }

    @Override
    public boolean moveCloseTo(Fighter fighter) {
        if(this.weapon.isMelee()) {
            return super.moveCloseTo(fighter);
        } else {
            return false;
        }
    }

    @Override
    public void recoverAP() {
        this.ap += 2;
        super.recoverAP();
    }
}
