package com.simulation.animal.entities.species;

import com.simulation.animal.entities.category.Pachyderm;

public class Rhino extends Pachyderm {
    private double hornLength;

    public double getHornlength() { return hornLength; }

    public void setHornlength(double hornLength) { this.hornLength = hornLength; }
}