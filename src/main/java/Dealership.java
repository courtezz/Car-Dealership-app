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


}
