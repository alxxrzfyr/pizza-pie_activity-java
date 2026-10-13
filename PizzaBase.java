public abstract class PizzaBase {
    protected String type = "Regular Pizza";

    public String getType() {
        return type;
    }

    public abstract double calculatePrice();
}
