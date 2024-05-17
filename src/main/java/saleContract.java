public class saleContract extends Contract {

    private double totalPrice;

    public saleContract(Car car, String customerName) {
        super(car, customerName);
        this.totalPrice = totalPrice;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

}
