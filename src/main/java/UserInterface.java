
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Dealership dealership;


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Dealership dealership = new Dealership("dawn Dealership", "999 Main apple St", 123456789);


        try {
            //Create fileWriter
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv");

            // Crate Buffered writer
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            // write File writer
            String text;
            for (int i = 1; i <= 10; i++) {
                text = String.format("counting %d\n", i);
                bufferedWriter.write(text);
            }

            // close the writer
            bufferedWriter.close();




        } catch (IOException e) {
            System.out.println("error: an unexpected error occurred");
            e.getStackTrace();
        }


        System.out.println("=== Welcome to the Car Dealership Application===");
        while (true) {
            System.out.println("1. Get cars by price range");
            System.out.println("2. Get cars by make and model");
            System.out.println("3. Get cars by year range");
            System.out.println("4. Get cars by color");
            System.out.println("5. Get cars by mileage range");
            System.out.println("6. Get cars by car type");
            System.out.println("7. Get all cars");
            System.out.println("8. Add a car");
            System.out.println("9. Remove a car");
            System.out.println("10. Exit");
            // Existing menu options
            System.out.println("11. Sell/Lease a vehicle");
            // Existing menu options
            System.out.println("Please select an option by number ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByCarTypeRequest();
                case 7 -> processGetByAllCarRequest();
                case 8 -> processAddCarRequest();
                case 9 -> processRemoveCarRequest();
                case 10 -> {
                }
                case 11 -> {
                    processSellOrLeaseRequest(dealership, scanner);
                    {
                        System.out.println("Exiting program...");
                        System.exit(0);
                    }
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }

    private static void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        List<Car> cars = dealership.getCarByPrice(minPrice, maxPrice);
        displayCars(cars);
    }

    private static void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Car> cars = dealership.getCarByMakeModel(make, model);
        displayCars(cars);
    }

    private static void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        List<Car> cars = dealership.getCarByYear(minYear, maxYear);
        displayCars(cars);
    }

    private static void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Car> cars = dealership.getCarByColor(color);
        displayCars(cars);
    }

    private static void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        List<Car> cars = dealership.getCarByMileage(minMileage, maxMileage);
        displayCars(cars);
    }

    private static void processGetByCarTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car type: ");
        String carType = scanner.nextLine();
        List<Car> cars = dealership.getCarByType(carType);
        displayCars(cars);
    }

    private static void processGetByAllCarRequest() {
        List<Car> cars = dealership.getAllCars();
        displayCars(cars);
    }

    private static void processAddCarRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter car details:");
        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Car Type: ");
        String carType = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        dealership.addCar(new Car(vin, year, make, model, carType, color, odometer, price));
        System.out.println("Car added successfully.");
    }

    private static void processRemoveCarRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN of the car to remove: ");
        int vin = scanner.nextInt();
        List<Car> cars = dealership.getAllCars();
        for (Car car : cars) {
            if (car.getVin() == vin) {
                dealership.removeCar(car);
                System.out.println("Car with VIN " + vin + " removed successfully.");
                return;
            }
        }

        System.out.println("No car found with VIN " + vin);

    }

    private static void displayCars(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars found.");
        } else {
            System.out.println("Matching Cars:");
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public static void setDealership(Dealership dealership) {
        UserInterface.dealership = dealership;
    }
    private static void processSellOrLeaseRequest(Dealership dealership, Scanner scanner) {
        System.out.println("Enter VIN of the vehicle to sell/lease: ");
        int vin = scanner.nextInt();
        Car car = findCarByVIN(dealership, vin);
        if (car != null) {
            System.out.print("Enter customer name: ");
            String customerName = scanner.next();
            System.out.print("Do you want to lease this vehicle? (true/false): ");
            boolean isLease = scanner.nextBoolean();
            dealership.sellOrLeaseVehicle(car, customerName, isLease);
        } else {
            System.out.println("No car found with VIN " + vin);
        }
    }
    private static Car findCarByVIN(Dealership dealership, int vin) {
        List<Car> cars = dealership.getAllCars();
        for (Car car : cars) {
            if (car.getVin() == vin) {
                return car;
            }
        }
        return null;
    }



}






