package org.example;

public class DecreaseSpeed {

    public DecreaseSpeed() {
    }

    public String modifySpeed(String bike){
        String[] parts = bike.split(" ");
        if (parts.length > 1){
            try {
                double speed = Double.parseDouble(parts[1]);
                speed *= 0.75;
                parts[1] = String.valueOf(speed);
                return String.join(" ", parts);
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return bike;
    }
}
