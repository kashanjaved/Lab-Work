/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fa20-bse-040
 */
class Tea extends ColdDrink {
    private String sweetnessType;
    private boolean cream;
    private int sweetnessLevel;

    public void setSweetnessType(String sweetnessType) {
        this.sweetnessType = sweetnessType;
    }

    public void setCream(boolean cream) {
        this.cream = cream;
    }

    public void setSweetnessLevel(int sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    @Override
    public float price() {
        float basePrice = 15.0f;
        float additionalPrice = 0.0f;

        if (sweetnessType != null && sweetnessType.equalsIgnoreCase("Diet")) {
            additionalPrice += 5.0f; // Additional cost for diet sweetness
        }

        if (cream) {
            additionalPrice += 3.0f; // Additional cost for cream
        }

        additionalPrice += sweetnessLevel; // Additional cost based on sweetness level

        return basePrice + additionalPrice;
    }

    @Override
    public String name() {
        return "Tea";
    }
}
