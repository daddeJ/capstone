package com.simulation.animal.entities.category;

import com.simulation.animal.entities.Animal;
    // TODO: extends Animal
public class Bird extends Animal {
    // TODO: add attribute for Bird
    private double wingspan;
    private double beaklength;
    // TODO: apply setter and getter
    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double getBeaklength() {
        return beaklength;
    }

    public void setBeaklength(double beaklength) {
        this.beaklength = beaklength;
    }
}
