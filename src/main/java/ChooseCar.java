import controllers.CarController;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ChooseCar {
    private final CarController controller;
    private final Scanner scanner;

    public ChooseCar(CarController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(int id) {
        while (true) {
            System.out.println();
            System.out.println("Here you can see the cars.");
            System.out.println("Select option:");
            System.out.println("1. Get all cars");
            System.out.println("2. Get car by id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-2): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCarsMenu();
                } else if (option == 2) {
                    getCarByIdMenu(id);
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
    }

    public void getCarByIdMenu(int id) {
        System.out.println("Please enter id");

        int car_id = scanner.nextInt();
        String response = controller.getCar(car_id);
        System.out.println(response + '\n' + "Wanna book this car? (Yes/No)");
        String book = scanner.next();
        if (Objects.equals(book, "Yes")){
            Main bk = new Main();
            bk.bookCar(id, car_id);
        }
    }
}
