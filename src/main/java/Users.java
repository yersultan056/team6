public class Users {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private String rightsCategory;
// 1.1
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
        return rightsCategory;
    }

    public void setRightsCategory(String rightsCategory) {
        this.rightsCategory = rightsCategory;
    }
}


