package org.example;
import java.util.PriorityQueue;

public class CustomPriorityQueue  {
private PriorityQueue<String> priorityQueue;

    public CustomPriorityQueue () {

        priorityQueue = new PriorityQueue<>();
    }
    public void add(String data) {
        priorityQueue.add(data);
    }
        public void printQueue() {
            System.out.println("Content of the pqueue: ");
            while (!priorityQueue.isEmpty()) {
                System.out.println(priorityQueue.poll());
            }

        }

}
