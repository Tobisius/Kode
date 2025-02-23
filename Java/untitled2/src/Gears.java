//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Gears {
    int Gear = 1;

    public Gears() {
    }

    public void incrementGear() {
        if (this.Gear == 7) {
            System.out.println("Gearet kan ikke komme højere op");
        } else if (this.Gear < 7) {
            System.out.println("Går op i gear");
            ++this.Gear;
        }

        System.out.println("Nuværende gear er: " + this.Gear);
    }

    public void decrementGear() {
        if (this.Gear < 2) {
            System.out.println("Gearet kan ikke komme længere ned");
        } else if (this.Gear > 2) {
            System.out.println("Går ned i gear");
            --this.Gear;
        }

    }
}
