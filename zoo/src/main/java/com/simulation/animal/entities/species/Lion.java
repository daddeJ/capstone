package com.simulation.animal.entities.species;

import com.simulation.animal.entities.category.Feline;

public class Lion extends Feline {
    // TODO: extends Feline
    // TODO: add attribute for Lion
    // TODO: apply setter and getter
    private double manesize;
    private String gender;

    public double getManesize() {
        return manesize;
    }

    public void setManesize(double manesize) {
        this.manesize = manesize;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}