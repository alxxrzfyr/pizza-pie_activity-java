import java.util.Scanner;

public class TAKE_ORDER {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.print("1. Regular Pizza\n2. Special Pizza\nChoice: ");
            if (!in.hasNextLine()) { in.close(); return; }
            try {
                choice = Integer.parseInt(in.nextLine());
                if (choice == 1 || choice == 2) break;
            } catch (NumberFormatException e) {
                System.out.println("Enter 1 or 2.");
            }
        }

        PizzaBase pizza = choice == 1 ? new PIZZA() : new SPECIAL_PIZZA();
        PIZZA p = (PIZZA) pizza;

        while (true) {
            try {
                System.out.print("Enter Toppings: ");
                if (!in.hasNextLine()) { in.close(); return; }
                p.setToppings(in.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid topping.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Diameter in inches: ");
                if (!in.hasNextLine()) { in.close(); return; }
                p.setDiameter(Integer.parseInt(in.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid diameter.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter How Many?: ");
                if (!in.hasNextLine()) { in.close(); return; }
                p.setHowMany(Integer.parseInt(in.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid quantity.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Type of Discount: ");
                if (!in.hasNextLine()) { in.close(); return; }
                p.setDiscount(in.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid discount.");
            }
        }

        pizza.calculatePrice();

        BILL_ORDER bill = new BILL_ORDER();
        double due = bill.OUT(pizza);

        double paid;
        while (true) {
            System.out.print("Enter Amount Received: ");
            if (!in.hasNextLine()) { in.close(); return; }
            try {
                paid = Double.parseDouble(in.nextLine());
                if (!Double.isNaN(paid) && !Double.isInfinite(paid) && paid > due) break;
                System.out.println("Amount must be finite and greater than Amount Due.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
            }
        }

        System.out.printf("Change: PHP %.2f%n", paid - due);
        in.close();
    }
}
