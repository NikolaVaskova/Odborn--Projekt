package org.example;

import java.util.HashMap;

public class NewChecklist {
    private HashMap<ChecklistItem, Boolean> checklistItems;

    public NewChecklist() {
        checklistItems = new HashMap<>();
    }

    public void addItem (ChecklistItem item){
        checklistItems.put(item, false);
    }
    public void passItem (ChecklistItem item){
        checklistItems.put(item, true);
    }
}
