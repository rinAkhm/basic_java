package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("Number")
    private Integer number;
    @JsonProperty("Lastname")
    private String lastname;
    @JsonProperty("Group")
    private String group;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
