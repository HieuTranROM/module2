package LuyenTap.MvcStudent.repository;


import LuyenTap.MvcStudent.model.Student;

import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {
    static ArrayList<Student> students = new ArrayList<>();

    static {
        students = new ArrayList<>();
        // Khởi tạo danh sách sinh viên
        students.add(new Student(1, "John", 9.6));
        students.add(new Student(2, "Alice", 8.5));
        students.add(new Student(3, "Bob", 5.8));
        students.add(new Student(4, "Emily", 7.3));
    }

    @Override
    public Student[] findALl() {
        return students.toArray(new Student[0]);
        //phương thức toArray(new Student[0]) sẽ chuyển đổi danh sách students
        // (kiểu List<Student>) thành một mảng các đối tượng Student (kiểu Student[])
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Sinh viên đã được thêm vào danh sách.");
    }

    @Override
    public void deleteStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
            }
        }

    }

    @Override
    public void updateStudent(Student student, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                System.out.println("Đã cập nhật thông tin sinh viên có ID " + student.getId());
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID " + student.getId() + " trong danh sách.");
    }

}