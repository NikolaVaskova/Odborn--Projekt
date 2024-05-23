package org.example.logic;

import org.example.DeviceOperations;

public class Computer {
    private String computerName;
    private DeviceOperations status;
    private NewChecklist checklist;

    public Computer(String computerName, DeviceOperations status, NewChecklist checklist) {
        this.computerName = computerName;
        this.status = status;
        this.checklist = checklist;
    }

}
