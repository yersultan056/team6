package modules;

public class User {
    // Fields representing user attributes
    private int id; // Unique identifier for the user
    private String name; // User's first name
    private String surname; // User's last name
    private boolean gender; // User's gender, true if male, false if female
    private String rights_category; // Category of driving rights the user possesses

    // Constructor without id (used for creating new users before saving to a database)
    public User(String name, String surname, boolean gender, String rights_category) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setRightsCategory(rights_category);
    }

    // Constructor with id (used when retrieving users from a database)
    public User(int id, String name, String surname, boolean gender, String rights_category) {
        this(name, surname, gender, rights_category); // Calls the first constructor to set name, surname, gender, and rights_category
        setId(id); // Additionally sets the user's id
    }

    // Getter and setter methods for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getRightsCategory() {
        return rights_category;
    }

    public void setRightsCategory(String rightsCategory) {
        this.rights_category = rightsCategory;
    }

    // Overridden toString() method for pretty printing of user information
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + (gender ? "Male" : "Female") + '\'' +
                ", rights_category='" + rights_category + '\'' +
                '}';
    }
}

