import org.example.*;

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.HashMap;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Vælg:\n" +
                "1 An Array with bicycles\n" +
                "2 A LinkedList with bicycles\n" +
                "3 A Stack with bicycles\n" +
                "4 A priority Queue with bicycles\n");
        int choice = input.nextInt();

        int amountBicycles = 0;

        if (choice != 3) {
            System.out.println("Vælg antallet af cykler: ");
            amountBicycles = input.nextInt();
        }

        HashMap<String, String> bicyclesMap = new HashMap<>();

        switch (choice) {
            case 1:
                GenerateBikes generateBikes = new GenerateBikes(amountBicycles);
                List<String> bicycles = generateBikes.generateAndSortArrayList(amountBicycles);

                for (String bike : bicycles){
                    bicyclesMap.put(bike, bike);
                }
                break;
            case 2:
                LinkedList<String> list = new LinkedList<>();
                GenerateBikes generateBikesForLinkedList = new GenerateBikes(amountBicycles);
                List<String> bikesLinkedList = generateBikesForLinkedList.generateAndSortArrayList(amountBicycles);
                for (String bike : bikesLinkedList){
                    bicyclesMap.put(bike, bike);
                }
                System.out.println("LinkedList content: ");
                System.out.println(bikesLinkedList);
                break;
            case 3:
                CustomStack<String> stack = new CustomStack<>();
                GenerateBikes generateBikesForStack = new GenerateBikes(amountBicycles);
                for (int i = 0; i < amountBicycles; i++){
                    stack.push("My bike" + amountBicycles);
                }
                System.out.println("Stack content: ");
                DecreaseSpeed decreaseSpeed = new DecreaseSpeed();
                while (!stack.isEmpty()) {
                    String bike = stack.pop();
                    System.out.println(bike);
                    System.out.println("Reduced speed: " + decreaseSpeed.modifySpeed(bike));
                }
                break;
            case 4:
                PriorityQueue<String> priorityQueue = new PriorityQueue<>();
                GenerateBikes generateBikesForPriorityqueue = new GenerateBikes(amountBicycles);
                List<String> bikesPriorityQueue = generateBikesForPriorityqueue.generateAndSortArrayList(amountBicycles);
                IncreaseSpeed increaseSpeed = new IncreaseSpeed();
                for (String bike : bikesPriorityQueue) {
                    priorityQueue.add(bike);
                }
                while (!priorityQueue.isEmpty()) {
                    String bike = bikesPriorityQueue.remove(0);
                    System.out.println(bikesPriorityQueue);
                    System.out.println("Increased speed: " + increaseSpeed.modifySpeed(bike));
                }
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Enter a bicycle name to get its info (type 'exit' to quit): ");
        String userInput = input.next();
        while (!userInput.equalsIgnoreCase("exit")){
            if (bicyclesMap.containsKey(userInput)){
                System.out.println("Bicycle info: " + bicyclesMap.get(userInput));
            } else {
                System.out.println("Bicycle with name: '" + userInput + "' not found.");
            }
            System.out.println("Enter a bicycle name to get its info (type 'exit' to quit): ");
            userInput = input.next();
        }
    }
}
