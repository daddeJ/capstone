package com.simulation.animal.entities;

public class Animal {
    private long id;
    private String animalId;
    private String name;
    private boolean healthy;
    private String category;
    private String species;
    
    public void setId(long id) { this.id = id; }
    public void setAnimalId(String animalId) { this.animalId = animalId; }
    public void setName(String name) { this.name = name; }
    public void setHealthy(boolean healthy) { this.healthy = healthy; }
    public void setCategory(String category) { this.category = category; }
    public void setSpecies(String species) { this.species = species; }

    public long getId() { return id; }
    public String getAnimalId() { return animalId; }
    public String getName() { return name; }
    public boolean isHealthy() { return healthy; }
    public String getCategory() { return category; }
    public String getSpecies() { return species; }
}
