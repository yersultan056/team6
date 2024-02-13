package modules;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private String rights_category;
    public User(String name, String surname, boolean gender) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setRightsCategory(rights_category);
    }
    public User(int id, String name, String surname, boolean gender,String rights_category) {
        this(name, surname, gender, rights_category);
        setId(id);
    }

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

    public boolean isGender() {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + (gender ? "Male" : "Female") + '\'' +
                ", rights_category='" + rights_category +
                '}';
    }
}

