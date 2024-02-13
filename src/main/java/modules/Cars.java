package modules;

public class Cars {
    private int car_id;
    private String model;
    private String brand;
    private String number;
    private String category;
    private String carClass;
    public Cars(String model, String brand, String number, String category, String carClass) {
        setModel(model);
        setBrand(brand);
        setNumber(number);
        setCategory(category);
        setCarClass(carClass);
    }
    public Cars(int car_id, String model, String brand, String number, String category, String carClass) {
        this.model = model;
        this.brand = brand;
        this.number = number;
        this.category = category;
        this.carClass = carClass;
        setCar_id(car_id);
    }


    public int getCar_id(){
        return car_id;
    }
    public void setCar_id(int car_id){
        this.car_id=car_id;
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

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + car_id +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", number=" + number +
                ", category='" + category + '\'' +
                ", carClass='" + carClass + '\'' +
                '}';
    }
}
