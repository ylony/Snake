package com.ylofanclub.apptest.metier;

/**
 * Created by hylow on 08/02/2018.
 */

public class Player {

    private Integer nbPts;
    private String nom;

    public Player(String nom){
        this.nom = nom;
        this.nbPts = 0;
    }

    public Integer getNbPts() {
        return nbPts;
    }

    public void addPts(){
        this.nbPts += 10;
    }
}
