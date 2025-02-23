//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Bolts {
    String Colour;
    boolean Fixed;

    public Bolts(String Colour, boolean Fixed) {
        this.Colour = Colour;
        this.Fixed = Fixed;
    }

    public void areBoltsFixed() {
        if (this.Fixed) {
            System.out.println("Cyklen er samlet korrekt - go' tur :D");
        } else {
            System.out.println("Cyklen er ikke samlet korrekt");
        }

    }
}
