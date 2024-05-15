package LuyenTap.MvcStudent.view;


import LuyenTap.MvcStudent.controller.StudentController;

public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.displayMenu();
    }
}
