public class SPECIAL_PIZZA extends PIZZA {

    public SPECIAL_PIZZA() {
        type = "Special Pizza";
    }

    @Override
    public double calculatePrice() {
        setPrice(super.calculatePrice() + 50.0 * getHowMany());
        return getPrice();
    }
}
