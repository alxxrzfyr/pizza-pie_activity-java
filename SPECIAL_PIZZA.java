public class SPECIAL_PIZZA extends PIZZA {

    public SPECIAL_PIZZA() {
        type = "Special Pizza";
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() + 50 * getHowMany();
    }
}
