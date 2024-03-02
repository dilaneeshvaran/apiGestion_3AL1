package org.example;

import java.util.List;

public class Projet {
    private int id;
    private String nom;
    private String descriptif;
    private String dateFin;
    private String dateDebut;
    private String priority;
    private String status;
    private List <List<Object>> requiredDevsPerStack;


    public Projet(int id, String nom, String descriptif, String dateFin, String dateDebut, String priority,String status,List <List<Object>> requiredDevsPerStack) {
        this.id = id;
        this.nom = nom;
        this.descriptif = descriptif;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
        this.priority = priority;
        this.status = status;
        this.requiredDevsPerStack = requiredDevsPerStack;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequiredDevsPerStack(List<List<Object>> requiredDevsPerStack) {
        this.requiredDevsPerStack = requiredDevsPerStack;
    }

    public List<List<Object>> getRequiredDevsPerStack() {
        return requiredDevsPerStack;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
