//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Tyres {
    float Diameter;
    boolean Flat;
    float Pressure;

    public Tyres(float Diameter, boolean Flat, float Pressure) {
        this.Diameter = Diameter;
        this.Flat = Flat;
        this.Pressure = Pressure;
    }

    public void isFlat() {
        if ((double)this.Pressure < 1.5) {
            System.out.println("Dækket skal pumpes");
        } else {
            System.out.println("Dækket er ikke helt fladt");
        }

    }

    public void diameterOfTyre() {
        System.out.println("Diameteren på dækket er: " + this.Diameter);
    }
}
