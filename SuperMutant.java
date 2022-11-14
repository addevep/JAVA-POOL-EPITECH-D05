import java.util.concurrent.atomic.AtomicInteger;

public class SuperMutant extends Monster {
    private int id;
    private static AtomicInteger ID_FACTORY = new AtomicInteger(1);

    protected SuperMutant() {
        super("SuperMutant", 170, 20);
        id = ID_FACTORY.getAndIncrement();
        this.name += (" #" + id);
        System.out.println(name + ": Roaarrr!");
    }

    public int getId() {
        return id;
    }

    @Override
    public void recoverAP() {
        if (this.hp < 170) {
            if ((this.hp += 10) > 170) {
                this.hp = 170;
            } else {
                this.hp += 10;
            }
        }
        super.recoverAP();
    }
}