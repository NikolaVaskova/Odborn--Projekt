package org.example.logic;

import org.example.logic.ChecklistItem;

import java.util.ArrayList;
import java.util.List;

public class NewChecklist {
    //private HashMap<ChecklistItem, Boolean> checklistItems;
    /*public NewChecklist() {
        checklistItems = new HashMap<>();
    }*/

    private List<ChecklistItem> items;

    public NewChecklist() {
        this.items = new ArrayList<>();
    }

    public void addItem(ChecklistItem item) {
        this.items.add(item);
    }

    public List<ChecklistItem> getItems() {
        return items;
    }
}
