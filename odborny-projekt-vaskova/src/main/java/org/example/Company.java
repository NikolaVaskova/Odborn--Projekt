package org.example;

import java.util.ArrayList;
//Tohle je hlavni logivka trida, ktera bude pouzivana k spusteni logiky programu
public class Company {
    private ArrayList<User> users;
    private ArrayList <Computer> computers;
    private ArrayList <NewChecklist> newChecklists;
    private ArrayList <ChecklistItem> checklistItems;


    public Company() {
        users = new ArrayList<>();
        computers = new ArrayList<>();
        newChecklists = new ArrayList<>();
        checklistItems = new ArrayList<>();
    }
}
