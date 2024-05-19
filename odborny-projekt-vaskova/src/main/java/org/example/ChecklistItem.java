package org.example;

public class ChecklistItem {
    private Integer id;
    private String label;

    public ChecklistItem(Integer id, String label) {
        this.id = id;
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
