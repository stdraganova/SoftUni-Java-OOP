package Encapsulation.exercise.pizzacalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }


    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Encapsulation.exercise.pizzacalories.Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;

        if (this.flourType.equals("White")) {
            calories *= DoughModifiers.WHITE.getModifier();
        } else if (this.flourType.equals("Wholegrain")) {
            calories *= DoughModifiers.WHOLEGRAIN.getModifier();
        }

        if (this.bakingTechnique.equals("Crispy")) {
            calories *= DoughModifiers.CRISPY.getModifier();
        } else if (this.bakingTechnique.equals("Chewy")) {
            calories *= DoughModifiers.CHEWY.getModifier();
        } else if (this.bakingTechnique.equals("Homemade")) {
            calories *= DoughModifiers.HOMEMADE.getModifier();
        }

        return calories;
    }

}
