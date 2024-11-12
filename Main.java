import java.util.InputMismatchException;
import java.util.Scanner;


enum PizzaParlor {
    Plain(1),
    Chicken(2),
    Pepperoni(3),
    Veggie(4);


    private final int pizzaMenuNum;
    PizzaParlor(int pizzaMenuNum) {
        this.pizzaMenuNum = pizzaMenuNum;
    }
    public int getPizzaMenuNum() {
        return pizzaMenuNum;
    }

    public static PizzaParlor getByNumber(int number) {
        for (PizzaParlor pizza : PizzaParlor.values()) {
            if (pizza.getPizzaMenuNum() == number) {
                return pizza;
            }
        }
        return null;
    }

}


public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.println("What flavor pizza would you like? Enter a number corresponding to the pizza flavor:\n");

        for (PizzaParlor p : PizzaParlor.values()) {
            System.out.println(p.getPizzaMenuNum() + " - " + p.toString());
        }


        try {
            System.out.print("\nPlease enter your choice (1-" + PizzaParlor.values().length + "): ");
            int n = s.nextInt();


            if (n < 1 || n > PizzaParlor.values().length) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + PizzaParlor.values().length);
            } else {
                PizzaParlor selectedPizza = PizzaParlor.getByNumber(n);
                System.out.println("You picked: " + selectedPizza);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        s.close();


    }
}