package polymorphism.lab.wildfarm;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}
