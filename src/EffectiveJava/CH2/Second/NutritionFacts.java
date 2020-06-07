package EffectiveJava.CH2.Second;

/**
 * Author:cafe3165
 * Date:2020-06-06
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calortes;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int servingSize;
        private final int servings;


        private int calortes;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servings = servings;
            this.servingSize = servingSize;
        }

        public Builder Calortes(int calortes) {
            this.calortes = calortes;
            return this;
        }

        public Builder Fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder Sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder Carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calortes = builder.calortes;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;

    }

    public static void main(String[] args) {
        NutritionFacts cocaCola=new NutritionFacts.Builder(240,8).Calortes(100).build();
        System.out.println(cocaCola.calortes);
    }
}
