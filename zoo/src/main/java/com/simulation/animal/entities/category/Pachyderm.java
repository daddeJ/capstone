package com.simulation.animal.entities.category;

import com.simulation.animal.entities.Animal;

public class Pachyderm extends Animal {
    private double weight;
    private double height;

    public double getWeight() { return weight; }
    public double getHeight() { return height; }

    public void setWeight(double weight) { this.weight = weight; }
    public void setHeight(double height) { this.height = height; }
}