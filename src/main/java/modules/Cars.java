package modules;

public class Cars {
    private String model;
    private String brand;
    private int number;
    private String category;
    private String carClass;
    public Cars(){

    } public Cars(String model, String brand, int number, String category, String carClass) {
        this.model = model;
        this.brand = brand;
        this.number = number;
        this.category = category;
        this.carClass = carClass;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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

    public void setCarClassClass(String carClass) {
        this.carClass = carClass;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", number=" + number +
                ", category='" + category + '\'' +
                ", carClass='" + carClass + '\'' +
                '}';
    }
}
