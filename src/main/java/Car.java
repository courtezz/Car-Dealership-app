

public final class Car {
    int vin;
 int year;
   String make;
String model;
   String carType;
     String color;
   int odometer;
    double price;

    public Car(int vin, int year, String make, String model, String carType, String color, int odometer,
               double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.carType = carType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }


    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getCarType() {
        return carType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }



    public int odometer() {
        return 0;
    }

    public String color() {
        return null;
    }

    public int year() {
        return 0;
    }

    public String make() {
        return null;
    }

    public String model() {
        return null;
    }

    public double price() {
        return 0;
    }

    public String carType() {
        return null;
    }

    public int vin() {
        return 0;
    }

    public int getVin() {
        return 0;
    }


}
