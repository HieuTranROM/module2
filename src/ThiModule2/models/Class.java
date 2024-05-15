package ThiModule2.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Class {
    private String classCode;
    private String className;

    public Class(String classCode, String className) {
        this.classCode = classCode;
        this.className = className;
    }

    public Class() {
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public String getClassName() {
        return className;
    }

    public static List<Class> loadClassesFromFile(String filePath) {
        List<Class> classes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String classCode = parts[0];
                String className = parts[1];
                classes.add(new Class(classCode, className));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }
}



