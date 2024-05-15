package LuyenTap.MvcStudent.controller;

import LuyenTap.MvcStudent.service.IStudentService;
import LuyenTap.MvcStudent.service.StudentService;

import java.util.Scanner;

public class StudentController {
    Scanner scanner = new Scanner(System.in);
    private IStudentService iStudentService = new StudentService();

    public void displayMenu() {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Tạo Học Sinh");
            System.out.println("2. Xem Danh Sách Học Sinh");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Nhấn số bất kỳ khác trên để thoát");

            System.out.print("Mời cưng chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    iStudentService.addStudent();
                    break;
                case 2:
                    iStudentService.display();
                    break;
                case 3:
                    iStudentService.updateStudent();
                    break;
                case 4:
                    iStudentService.deleteStudent();
                    break;
            }
        } while (choose >= 1 && choose <= 4);
    }
}

