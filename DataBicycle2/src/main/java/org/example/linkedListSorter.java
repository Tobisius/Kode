package org.example;

import java.util.LinkedList;


public class linkedListSorter {
    LinkedList<String> linkedlist;

public linkedListSorter() {

    this.linkedlist = new LinkedList<>();
}

public void add(String data){
    linkedlist.add(data);
}

    public void display(){
    for (String data : linkedlist){
        System.out.println(data);
    }

    }
}
