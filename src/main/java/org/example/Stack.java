package org.example;

import java.util.List;

public class Stack {
    public String techno;
    public int nbrDev;
    private List<Integer> developers;

    public Stack(String techno, int nbrDev, List<Integer> developers) {
        this.techno = techno;
        this.nbrDev = nbrDev;
        this.developers = developers;
    }

    public String getTechno() {
        return this.techno;
    }

    public int getNbrDev() {
        return this.nbrDev;
    }

    public List<Integer> getDevelopers() {
        return this.developers;
    }

    public void addDeveloper(int developer) {
        this.developers.add(developer);
        this.nbrDev++;
    }
}
