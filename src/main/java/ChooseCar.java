import controllers.CarController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseCar {
    private final CarController controller;
    private final Scanner scanner;

    public ChooseCar(CarController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Here you can see the cars.");
            System.out.println("Select option:");
            System.out.println("1. Get all cars");
            System.out.println("2. Get car by id");
            System.out.println("3. Book car");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCarsMenu();
                } else if (option == 2) {
                    getCarByIdMenu();
                } else if (option == 3) {
                    System.out.println("---");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }


    public void getAllCarsMenu() {
        String response = controller.getAllCars();
        System.out.println(response);
        start();
    }

    public void getCarByIdMenu() {
        System.out.println("Please enter id");

        int car_id = scanner.nextInt();
        String response = controller.getCar(car_id);
        System.out.println(response);
    }
}
