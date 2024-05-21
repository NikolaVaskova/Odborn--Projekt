package org.example;

public class Computer {
    private String computerName;
    private Operations status;
    private NewChecklist checklist;

    public Computer(String computerName, Operations status, NewChecklist checklist) {
        this.computerName = computerName;
        this.status = status;
        this.checklist = checklist;
    }

}
