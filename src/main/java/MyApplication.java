import controllers.UserController;
import controllers.CarController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import repositories.CarsRepository;
import repositories.interfaces.ICarsRepository;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MyApplication {
    private final UserController userController; // Controller for user-related operations
    private final Scanner scanner; // Scanner for reading input from console

    // Constructor initializes the application with a UserController
    public MyApplication(UserController controller) {
        this.userController = controller;
        scanner = new Scanner(System.in); // Initialize scanner for input
    }

    // Main loop of the application, displays menu and processes user input
    public void start() {
        while (true) { // Loop until the user chooses to exit
            System.out.println("\nWelcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt(); // Read user's choice
                switch (option) {
                    case 1:
                        getAllUsersMenu(); // Handle all users listing
                        break;
                    case 2:
                        getUserByIdMenu(); // Handle fetching a user by ID
                        break;
                    case 3:
                        createUserMenu(); // Handle creating a new user
                        break;
                    case 0:
                        return; // Exit the application
                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer. Please try again.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
            System.out.println("*************************");
        }
    }

    // Displays all users
    private void getAllUsersMenu() {
        String response = userController.getAllUsers();
        System.out.println(response);
    }

    // Fetches and displays information for a user by their ID
    private void getUserByIdMenu() {
        System.out.println("Please enter an ID:");
        int id = scanner.nextInt(); // Read the user's ID
        String response = userController.getUser(id);
        System.out.println(response);
        if (!Objects.equals(response, "User was not found!")){
            Main cr = new Main();
            cr.selectCars(id);
        }

        // Proceed to car selection logic (not shown in provided code snippet)
    }

    // Handles the creation of a new user
    private void createUserMenu() {
        System.out.println("Please enter the following details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Surname: ");
        String surname = scanner.next();
        System.out.print("Gender (male/female): ");
        String gender = scanner.next();
        System.out.print("Category of rights: ");
        String rights_category = scanner.next();

        String response = userController.createUser(name, surname, gender, rights_category);
        System.out.println(response);
    }
}
