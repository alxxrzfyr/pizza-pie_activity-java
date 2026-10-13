public class BILL_ORDER {

    public double OUT(PizzaBase pizza) {
        PIZZA p = (PIZZA) pizza;
        double due = p.getPrice();

        System.out.println("\nORDER DETAILS");
        System.out.println("Pizza Type: " + pizza.getType());
        System.out.println("Toppings: " + p.getToppings());
        System.out.printf("Diameter: %.2f cm%n", p.getDiameter() * 2.54);
        System.out.println("Quantity: " + p.getHowMany());
        System.out.println("Discount: " + p.getDiscount());
        System.out.printf("Discount Rate: %.0f%%%n", p.getDiscountRate() * 100);
        System.out.printf("Amount Due: PHP %.2f%n", due);

        return due;
    }
}
