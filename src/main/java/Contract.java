public class Contract {
    private Car car;
    private String customerName;

    public Contract(Car car, String customerName) {
        this.car = car;
        this.customerName = customerName;
    }

    public Car getCar() {
        return car;
    }
    public String getCustomerName() {
        return customerName;
    }

}
