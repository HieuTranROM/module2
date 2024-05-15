package ThiModule2.controller;

import ThiModule2.models.Student;
import ThiModule2.service.NotFoundStudentException;
import ThiModule2.service.StudentValidation;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {
    private static final String STUDENT_FILE_PATH = "src/ThiModule2/data/students.csv";
    private static List<Student> students = new ArrayList<>();
    private static int nextStudentId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadStudentsFromFile();

        while (true) {
            int choice = showAndGetChoice();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    saveStudentsToFile();
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                LocalDate birthDate = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String gender = parts[3];
                String phoneNumber = parts[4];
                String classCode = parts[5];

                students.add(new Student(id, name, birthDate, gender, phoneNumber, classCode));
                nextStudentId = Math.max(nextStudentId, id + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE_PATH))) {
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getBirthDate() + ","
                        + student.getGender() + "," + student.getPhoneNumber() + "," + student.getClassCode());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int showAndGetChoice() {
        System.out.println("Chuong trinh quan ly sinh vien");
        System.out.println("Chon chuc nang theo so(de tiep tuc)");
        System.out.println("1. Them moi sinh vien");
        System.out.println("2. Xoa sinh vien");
        System.out.println("3. Xem danh sach sinh vien");
        System.out.println("4. Xem thong tin giao vien");
        System.out.println("5. Tim kiem sinh vien");
        System.out.println("6. Thoat");
        System.out.print("Chon chuc nang: ");

        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.print("Chon khong hop le. Vui long chon lai: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Chon khong hop le. Vui long chon lai: ");
            }
        }

        return choice;
    }


    private static void addStudent() {
        System.out.println("Nhap thong tin sinh vien moi:");
        System.out.print("Ten sinh vien: ");
        String name = scanner.nextLine();

        System.out.print("Ngay sinh (dd/MM/yyyy): ");
        String birthDateStr = scanner.nextLine();

        System.out.print("Gioi tinh (Nam/Nữ): ");
        String gender = scanner.nextLine();

        System.out.print("So dien thooi: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Ma lop hoc: ");
        String classCode = scanner.nextLine();

        if (StudentValidation.validateStudentData(name, birthDateStr, gender, phoneNumber, classCode, students)) {
            LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Student newStudent = new Student(nextStudentId, name, birthDate, gender, phoneNumber, classCode);
            students.add(newStudent);
            nextStudentId++;

            System.out.println("Them sinh vien thanh cong.");
        } else {
            System.out.println("Khong the them sinh vien do loi du lieu.");
        }
    }


    private static void displayStudents() {
        System.out.println("Danh sach sinh vien:");
        if (students.isEmpty()) {
            System.out.println("Khong co sinh vien nao trong danh sach.");
            return;
        }

        System.out.println("Ma SV\tTen SV\tNgay sinh\tGioi tinh\tLop hoc");
        for (Student student : students) {
            System.out.println(student.getId() + "\t" + student.getName() + "\t"
                    + student.getBirthDate() + "\t" + student.getGender() + "\t" + student.getClassCode());
        }
    }

    private static void deleteStudent() {
        System.out.print("Nhap ma sinh vien can xoa: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            Student studentToDelete = findStudentById(studentId);
            if (studentToDelete != null) {
                System.out.println("Thong tin sinh vien can xoa:");
                System.out.println(studentToDelete);

                System.out.print("Xac nhan xoa sinh vien? (Yes/No): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    students.remove(studentToDelete);
                    saveStudentsToFile();
                    System.out.println("Xoa sinh vien thanh cong.");
                } else if (confirmation.equalsIgnoreCase("no")) {
                    System.out.println("Huy xoa sinh vien.");
                } else {
                    System.out.println("Lua chon khong hop le.");
                }
            } else {
                throw new NotFoundStudentException("Sinh vien khong ton tai.");
            }
        } catch (NotFoundStudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}










