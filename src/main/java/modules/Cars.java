package modules;

public class Cars {
    // Unique identifier for the car
    private int car_id;
    // Model of the car
    private String model;
    // Brand of the car
    private String brand;
    // License plate number
    private String number;
    // Category of the car, e.g., SUV, sedan
    private String category;
    // Class of the car, e.g., economy, luxury
    private String carClass;

    // Constructor without car_id, used for creating new cars before they are persisted to the database
    public Cars(String model, String brand, String number, String category, String carClass) {
        setModel(model);
        setBrand(brand);
        setNumber(number);
        setCategory(category);
        setCarClass(carClass);
    }

    // Constructor with car_id, used when retrieving car details from the database
    public Cars(int car_id, String model, String brand, String number, String category, String carClass) {
        this(model, brand, number, category, carClass); // Calls the first constructor to set name, surname, gender, and rights_category
        setCar_id(car_id); // Additionally sets the user's id
    }

    // Getters and setters for all fields
    public int getCar_id(){
        return car_id;
    }

    public void setCar_id(int car_id){
        this.car_id = car_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    // Method to return a string representation of the car's details
    @Override
    public String toString() {
        return "Cars{" +
                "id=" + car_id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                ", category='" + category + '\'' +
                ", carClass='" + carClass + '\'' +
                '}';
    }
}
