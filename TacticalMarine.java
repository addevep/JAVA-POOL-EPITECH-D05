public class TacticalMarine extends SpaceMarine {

    protected TacticalMarine(String name) {
        super(name, 100, 20);
        System.out.println(name + " on duty.");
        this.equip(new PlasmaRifle());
    }
    @Override
    public void recoverAP() {
        this.ap += 5;
        super.recoverAP();
    }
}
