package repositories.interfaces;

import modules.User;

import java.util.List;

public interface IUserRepository {
    // Attempts to create a new user in the database.
    // Returns true if successful, false otherwise.
    boolean createUser(User user);

    // Retrieves a user by their unique identifier (id) from the database.
    // Returns a User object if found, null otherwise.
    User getUser(int id);

    // Retrieves a list of all users from the database.
    // Returns a list of User objects, which may be empty if no users are found.
    List<User> getAllUsers();
}

