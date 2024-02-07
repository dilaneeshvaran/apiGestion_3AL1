package org.example;

public class Projet {
    private int id;
    private String nom;
    private String descriptif;
    private String dateFin;
    private String dateDebut;
    private Equipe equipe;
    private String priority;

    public Projet(int id, String nom, String descriptif, String dateFin, String dateDebut, Equipe equipe, String priority) {
        this.id = id;
        this.nom = nom;
        this.descriptif = descriptif;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
        this.equipe = equipe;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
