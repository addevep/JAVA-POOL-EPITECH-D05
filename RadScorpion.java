import java.util.concurrent.atomic.AtomicInteger;

public class RadScorpion extends Monster {
    private int id;
    private static AtomicInteger ID_FACTORY = new AtomicInteger(1);
    protected RadScorpion() {
        super("RadScorpion", 80, 50);
        id = ID_FACTORY.getAndIncrement();
        this.name += (" #" + id);
        System.out.println(name + ": Crrr!");
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (fighter instanceof TacticalMarine) {
            this.damage = 50;
        } else {
            this.damage = 25;
        }
        this.apcost = 8;
        return super.attack(fighter);
    }
}
