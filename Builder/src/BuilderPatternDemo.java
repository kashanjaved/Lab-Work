/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author fa20-bse-040
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal customMeal = new Meal();

        System.out.println("Welcome to the Meal Customization System!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your meal type (Veg/Non-Veg): ");
        String mealType = scanner.nextLine();

        if (mealType.equalsIgnoreCase("Veg")) {
            customMeal = mealBuilder.prepareVegMeal();
        } else if (mealType.equalsIgnoreCase("Non-Veg")) {
            customMeal = mealBuilder.prepareNonVegMeal();
        } else {
            System.out.println("Invalid meal type.");
            scanner.close();
            return;
        }

        boolean customize = true;
        while (customize) {
            System.out.println("Customization Options:");
            System.out.println("1. Add Diet Version for Beverages");
            System.out.println("2. Add Tea");
            System.out.println("3. Finish Customization");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customMeal.addItem(new DietCoke());
                    customMeal.addItem(new DietPepsi());
                    break;
                case 2:
                    Tea tea = new Tea();
                    System.out.println("Sweetness Type (Regular/Diet): ");
                    String sweetnessType = scanner.next();
                    tea.setSweetnessType(sweetnessType);

                    System.out.println("Cream (Yes/No): ");
                    String cream = scanner.next();
                    tea.setCream(cream.equalsIgnoreCase("Yes"));

                    System.out.println("Amount of Sweetness (in spoons): ");
                    int sweetnessLevel = scanner.nextInt();
                    tea.setSweetnessLevel(sweetnessLevel);

                    customMeal.addItem(tea);
                    break;
                case 3:
                    customize = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Your Customized Meal");
        customMeal.showItems();
        System.out.println("Total Cost: " + customMeal.getCost());

        scanner.close();
    }
}