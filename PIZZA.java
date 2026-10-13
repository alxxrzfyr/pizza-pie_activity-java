public class PIZZA extends PizzaBase implements Discountable {
    
    private String toppings, discount;
    private int diameter, howMany;
    private double price;

    public void setToppings(String x) {
        if (!x.equalsIgnoreCase("Pepperoni") &&
            !x.equalsIgnoreCase("Ham and Cheese") &&
            !x.equalsIgnoreCase("Hawaiian"))
            throw new IllegalArgumentException();

        toppings = x;
    }

    public void setDiameter(int x) {
        if (x <= 0) throw new IllegalArgumentException();
        diameter = x;
    }

    public void setHowMany(int x) {
        if (x <= 0) throw new IllegalArgumentException();
        howMany = x;
    }

    public void setDiscount(String x) {
        if (!x.equalsIgnoreCase("Senior Citizen") &&
            !x.equalsIgnoreCase("VIPCard") &&
            !x.equalsIgnoreCase("No Discount"))
            throw new IllegalArgumentException();

        discount = x;
    }

    public String getToppings() { return toppings; }
    public String getDiscount() { return discount; }
    public int getDiameter() { return diameter; }
    public int getHowMany() { return howMany; }
    public double getPrice() { return price; }

    public double getDiscountRate() {
        if (discount.equalsIgnoreCase("Senior Citizen")) return .20;
        if (discount.equalsIgnoreCase("VIPCard")) return .12;
        return 0;
    }

    public double calculatePrice() {
        double topping;

        if (toppings.equalsIgnoreCase("Pepperoni")) topping = 100;
        else if (toppings.equalsIgnoreCase("Ham and Cheese")) topping = 150;
        else topping = 200;

        price = (topping + diameter * 2.54 * 5) * howMany;
        price -= price * getDiscountRate();

        return price;
    }
}
