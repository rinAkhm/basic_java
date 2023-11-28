package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Organization {
    @JsonProperty("Organization")
    private String organization;
    @JsonProperty("Description")

    private String description;
    @JsonProperty("Students")

    private ArrayList<Student> students;


    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
