package WorkingWithAbstraction.HotelReservation;

enum Season{
    Autumn(1),
    Spring(2),
    Summer(4),
    Winter(3);

    private int a;

    Season(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}
enum DiscountType{
    VIP(0.20),
    SecondVisit(0.10),
    None(0.0);

    private double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
public class PriceCalculator {
    public static double priceCalculator(double pricePerDay, int days, Season season, DiscountType discountType){
        double price = pricePerDay * days * season.getA();
        double discount = discountType.getDiscount() * price;
        return price - discount;
    }
}
