import java.util.ArrayList;
import java.util.List;
public class Dealership {
    String name;
 String address;
 int phone;
 ArrayList<Car> inventory;

    public Dealership (String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Car> getCarByPrice(double min, double max) {
        List<Car> result = new ArrayList<>();
        for (Car car : inventory) {
            if (car.price() >= min && car.price() <= max) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getCarByMakeModel(String make, String model) {
        List<Car> result = new ArrayList<>();
        for (Car car : inventory) {
            if (car.make().equalsIgnoreCase(make) && car.model().equalsIgnoreCase(model)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> getCarByYear(int min, int max) {
        List<Car> result = new ArrayList<>();
        for (Car car : inventory) {
            if (car.year() >= min && car.year() <= max) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getCarByColor(String color) {
        List<Car> result = new ArrayList<>();
        for (Car car : inventory) {
            assert car.color() != null;
            if (car.color().equalsIgnoreCase(color)) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getCarByMileage(int min, int max) {
        List<Car> result = new ArrayList<>();
        for (Car car : inventory) {
            if (car.odometer() >= min && car.odometer() <= max) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getCarByType(String carType) {
        List<Car> result = new ArrayList<>();
        for (Car car : inventory) {
            assert car.carType() != null;
            if (car.carType().equalsIgnoreCase(carType)) {
                result.add(car);
            }
        }
        return result;
    }
    public List<Car> getAllCars() {
        return new ArrayList<>(inventory);
    }

    public void addCar(Car car) {
        inventory.add(car);
    }

    public void removeCar(Car car) {
        inventory.remove(car);
    }
    public void sellOrLeaseVehicle(Car car, String customerName, boolean isLease) {
        if (isLease) {
            leaseVehicle(car, customerName);
        } else {
            sellVehicle(car, customerName);
        }
    }

    private void sellVehicle(Car car, String customerName) {
        // Sale calculation logic
        // Display sale contract details
        System.out.println("Sale contract details:");
        // Add sale contract to records or file
    }
    private LeaseContract leaseVehicle(Car car, String customerName) {
        int currentYear = 0;
        if (car.getYear() > (currentYear - 3)) {
            System.out.println("Cannot lease a vehicle over 3 years old.");
            return null;
        } // Existing code
        // Lease calculation logic
        // For simplicity, assume monthly lease price is 1/36th of the car's price (3-year lease)
        double monthlyLeasePrice = car.getPrice() / 36;
        return new LeaseContract(car, customerName, 36, monthlyLeasePrice);
    }
}



