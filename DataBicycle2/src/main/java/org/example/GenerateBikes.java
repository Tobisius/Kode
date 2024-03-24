package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateBikes {
    public static String bikeName;
    private Random rand = new Random();

    public GenerateBikes(int amountBicycles) {
    }

    public List<String> generateAndSortArrayList(int amountBicycles){

        List<String> bikeName = new ArrayList<>();

        for (int i = 0; i < amountBicycles; i++){

            int randomNumber = rand.nextInt(100);
            bikeName.add("MyBike" + randomNumber);
        }
        Collections.sort(bikeName);
        //System.out.println("Final result is: " + bikeName);

        return bikeName;
    }
}
