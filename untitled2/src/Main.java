class Bicycle {
    Bicycle(){
    }
}

class Handlebars extends Bicycle {
    String Colour;
    boolean Grips;
    boolean Bell;
    String Shape;

     Handlebars(String Colour, boolean Grips, boolean Bell, String Shape) {
        this.Colour = Colour;
        this.Grips = Grips;
        this.Bell = Bell;
        this.Shape = Shape;
    }

     void ringBell() {
        if (this.Bell) {
            System.out.println("Ringer med ringeklokken");
        } else {
            System.out.println("Der er ingen ringeklokke:(");
        }
    }
    void describeHandlebars() {
        System.out.println("Handlebars: Color=" + Colour + ", Adjustable=" + Grips + ", Bell=" + Bell + ", Shape=" + Shape);
    }
}

class Bolts extends Bicycle{
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
    void describeBolts(){
        System.out.println("Bolts colour: " + ", Fixed: " + Fixed);
    }
}

class Tyres extends Bicycle {

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

    public void desribeTyres() {
        System.out.println("Diameter of the tyre is: " + Diameter + "\n Tyres is or is not flat?: " + Flat + "\n Tyre pressure is: " + Pressure);
    }
}
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Handlebars handlebars = new Handlebars("Red", false, true, "Curved");
        handlebars.ringBell();
        handlebars.describeHandlebars();

        Bolts bolts = new Bolts("Grey", false);
        bolts.areBoltsFixed();
        bolts.describeBolts();

        Tyres tyres = new Tyres(700.0F, true, 2.2F);
        tyres.isFlat();
        tyres.desribeTyres();

        Gears gear = new Gears();
        gear.incrementGear();
        gear.decrementGear();
    }
}
