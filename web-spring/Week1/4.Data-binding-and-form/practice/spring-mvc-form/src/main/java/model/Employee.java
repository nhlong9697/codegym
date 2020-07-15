package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

    private String id;
    @NotNull
    @Size(min=2, max=30)
    private String name;

    private String contactNumber;

    public Employee() {
    }

    public Employee(String id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}