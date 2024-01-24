package org.example;

public class Competance {
    private int technoid;
    private String technoName;
    private String technoYearExperience;

    public Competance(String technoName, String technoYearExperience) {
        this.technoName = technoName;
        this.technoYearExperience = technoYearExperience;
    }
    public int getTechnoid() {
        return technoid;
    }

    public String getTechnoName() {
        return technoName;
    }

    public String getTechnoYearExperience() {
        return technoYearExperience;
    }
}
