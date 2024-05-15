package LuyenTap.MvcStudent.service;


import LuyenTap.MvcStudent.model.Student;
import LuyenTap.MvcStudent.repository.IStudentRepository;
import LuyenTap.MvcStudent.repository.StudentRepository;

import java.util.Scanner;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void display() {
        Student[] students = iStudentRepository.findALl(); // mảng lấy từ finall
        if (students.length == 0) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (Student student : students) {
                System.out.println("ID: " + student.getId() + ", Tên: " + student.getName() + ", Điểm: " + student.getScore());
            }
        }
    }

    @Override
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập vào điểm: ");
        double score = Double.parseDouble(scanner.nextLine());
        Student student = new Student(id, name, score);

        // Add the student tới repository
        iStudentRepository.addStudent(student);
    }

    @Override
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        display();
        System.out.print("Nhập vào ID sinh viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        iStudentRepository.deleteStudentById(id);

    }

    @Override
    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        display();
        System.out.print("Nhập vào ID sinh viên cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào tên mới cho sinh viên: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập vào điểm mới cho sinh viên: ");
        double newScore = Double.parseDouble(scanner.nextLine());
        Student studentToUpdate = new Student(id, newName, newScore);
        iStudentRepository.updateStudent(studentToUpdate, id);
    }
}





