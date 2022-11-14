public abstract class Unit implements Fighter{
    protected String name;
    protected int hp;
    protected int ap;
    protected Fighter closeTo;

    protected Unit(String name,int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAp() {
        return ap;
    }

    public Fighter getCloseTo() {
        return closeTo;
    }

    @Override
    public void receiveDamage(int receiveDamage) {
        if (this.hp < receiveDamage) {
            this.hp = 0;
        } else {
            this.hp -= receiveDamage;
        }
    }

    @Override
    public boolean moveCloseTo(Fighter fighter) {
        if (fighter != this && this.closeTo != fighter) {
            this.closeTo = fighter;
            System.out.println(this.getName() + " is moving closer to " + fighter.getName() + ".");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void recoverAP() {
        this.ap += 7;
        if (this.hp <= 0) {
            return;
        } else if(this.ap > 50) {
            this.ap = 50;
        }
    }
}
