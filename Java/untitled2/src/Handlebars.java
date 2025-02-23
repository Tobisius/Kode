//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Handlebars {
    String Colour;
    boolean Grips;
    boolean Bell;
    String Shape;

    public Handlebars(String Colour, boolean Grips, boolean Bell, String Shape) {
        this.Colour = Colour;
        this.Grips = Grips;
        this.Bell = Bell;
        this.Shape = Shape;
    }

    public void ringBell() {
        if (this.Bell) {
            System.out.println("Ringer med ringeklokken");
        } else {
            System.out.println("Der er ingen ringeklokke:(");
        }

    }
}
