package LuyenTap.MvcStudent.repository;


import LuyenTap.MvcStudent.model.Student;

public interface IStudentRepository {
    Student[] findALl(); // lấy all dữ liệu

    void addStudent(Student student);
    void deleteStudentById(int id);
    void updateStudent(Student student, int id);

}