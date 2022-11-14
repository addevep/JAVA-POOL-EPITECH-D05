public class AssaultTerminator extends SpaceMarine {

    protected AssaultTerminator(String name) {
        super(name, 150, 30);
        System.out.println(name + " has teleported from space.");
        this.equip(new PowerFist());
    }

    @Override
    public void receiveDamage(int receiveDamage) {
        if ((receiveDamage - 3) < 1) {
            super.receiveDamage(1);
        } else {
            super.receiveDamage(receiveDamage - 3);
        }
    }
}
