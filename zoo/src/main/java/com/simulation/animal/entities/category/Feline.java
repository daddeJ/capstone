package com.simulation.animal.entities.category;

import com.simulation.animal.entities.Animal;

public class Feline extends Animal {
    // TODO: extends Animal
    private double clawlength;
    private double taillength;
    // TODO: add attribute for Feline
    // TODO: apply setter and getter


    public double getClawlength() {
        return clawlength;
    }

    public void setClawlength(double clawlength) {
        this.clawlength = clawlength;
    }

    public double getTaillength() {
        return taillength;
    }

    public void setTaillength(double taillength) {
        this.taillength = taillength;
    }
}
