public class LeaseContract extends Contract {
    private int leaseDuration; // Lease duration in months
    private double monthlyLeasePrice;
    public LeaseContract(Car car, String customerName) {
        super(car, customerName);
    }

    public LeaseContract(Car car, String customerName, int leaseDuration, double monthlyLeasePrice) {
        super(car, customerName);
        this.leaseDuration = leaseDuration;
        this.monthlyLeasePrice = monthlyLeasePrice;
    }
    public int getLeaseDuration() {
        return leaseDuration;
    }

    public double getMonthlyLeasePrice() {
        return monthlyLeasePrice;
    }


}
