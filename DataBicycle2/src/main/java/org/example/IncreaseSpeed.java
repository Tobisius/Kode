package org.example;

public class IncreaseSpeed {

    public String modifySpeed(String bike){

        String[] parts = bike.split(" ");
        if (parts.length > 1){
            try {
                double speed = Double.parseDouble(parts[1]);
                speed *= 1.25;
                parts[1] = String.valueOf(speed);
                return String.join(" ", parts);
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return bike;
    }
}
