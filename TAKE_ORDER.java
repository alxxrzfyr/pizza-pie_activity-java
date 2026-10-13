import java.util.Scanner;

public class TAKE_ORDER {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choice;
        do {
            System.out.print("1. Regular Pizza\n2. Special Pizza\nChoice: ");
            choice = Integer.parseInt(in.nextLine());
        } while (choice != 1 && choice != 2);

        PizzaBase pizza = choice == 1 ? new PIZZA() : new SPECIAL_PIZZA();
        PIZZA p = (PIZZA) pizza;

        while (true) {
            try {
                System.out.print("Enter Toppings: ");
                p.setToppings(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid topping.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Diameter in inches: ");
                p.setDiameter(Integer.parseInt(in.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Invalid diameter.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter How Many?: ");
                p.setHowMany(Integer.parseInt(in.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Invalid quantity.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Type of Discount: ");
                p.setDiscount(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid discount.");
            }
        }

        pizza.calculatePrice();

        BILL_ORDER bill = new BILL_ORDER();
        double due = bill.OUT(pizza);

        double paid;
        do {
            System.out.print("Enter Amount Received: ");
            paid = Double.parseDouble(in.nextLine());

            if (paid <= due)
                System.out.println("Amount must be greater than Amount Due.");

        } while (paid <= due);

        System.out.printf("Change: PHP %.2f%n", paid - due);
        in.close();
    }
}
