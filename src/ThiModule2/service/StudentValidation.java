package ThiModule2.service;

import ThiModule2.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentValidation {

    public static boolean validateStudentData(String name, String birthDateStr, String gender, String phoneNumber, String classCode, List<Student> students) {
        if (name.isEmpty() || birthDateStr.isEmpty() || gender.isEmpty() || phoneNumber.isEmpty()) {
            System.out.println("Vui long nhap day du thong tin.");
            return false;
        }

        if (name.length() < 4 || name.length() > 50) {
            System.out.println("Ten sinh vien phai tu 4 den 50 ky tu.");
            return false;
        }

        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            System.out.println("Ngay sinh khong hop le. Dinh dang: dd/MM/yyyy");
            return false;
        }

        if (!gender.equalsIgnoreCase("nam") && !gender.equalsIgnoreCase("nu")) {
            System.out.println("Gioi tinh chi duoc la 'Nam' hoặc 'Nu'.");
            return false;
        }

        if (!phoneNumber.matches("(090|091)\\d{7}")) {
            System.out.println("So dien thoai khong hop le. Vui long nhap so dien thoai bat dau bang '090' hoac '091' va co 10 so.");
            return false;
        }

        for (Student student : students) {
            if (student.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("So dien thoai da ton tai cho sinh vien khac.");
                return false;
            }
        }

        return true;
    }

//    List<Class> classes = Class.loadClassesFromFile("data/class.csv");
//    boolean validClassCode = false;
//        for (Class classObj : classes) {
//        if (classObj.getClassCode().equals(classCode)) {
//            validClassCode = true;
//            break;
//        }
//    }
//
//        if (!validClassCode) {
//        System.out.println("Mã lớp học không tồn tại.");
//        return false;
//    }
//
//        return true;
//}

}
