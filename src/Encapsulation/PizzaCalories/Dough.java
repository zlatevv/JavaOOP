package Encapsulation.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
        setFlourType(flourType);
    }

    public void setFlourType(String flourType) {
        if (!(flourType.equals("White") || flourType.equals("Wholegrain"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!(bakingTechnique.equals("Crispy") ||
                bakingTechnique.equals("Homemade") ||
                bakingTechnique.equals("Chewy"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1...200].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        double flourTypeCoefficient = 0;
        if (this.flourType.equals("White")) {
            flourTypeCoefficient = 1.5;
        } else if (this.flourType.equals("Wholegrain")) {
            flourTypeCoefficient = 1.0;
        }

        double bakingTechnicsCoefficient = 0;
        if (this.bakingTechnique.equals("Crispy")) {
            bakingTechnicsCoefficient = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            bakingTechnicsCoefficient = 1.1;
        } else if (this.bakingTechnique.equals("Homemade")) {
            bakingTechnicsCoefficient = 1.0;
        }


        return 2 * this.weight * flourTypeCoefficient * bakingTechnicsCoefficient;

    }
}
