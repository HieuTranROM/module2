package ThiModule2.models;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String phoneNumber;
    private String classCode;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Student(int id, String name, LocalDate birthDate, String gender, String phoneNumber, String classCode) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.classCode = classCode;
    }

    // Getters and setters for all fields

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Birth Date: " + birthDate + ", Gender: " + gender
                + ", Phone: " + phoneNumber + ", Class Code: " + classCode;
    }
}

