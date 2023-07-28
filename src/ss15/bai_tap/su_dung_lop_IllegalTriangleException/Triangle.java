package ss15.bai_tap.su_dung_lop_IllegalTriangleException;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws IllegalRightTriangleException{
        Scanner scanner = new Scanner(System.in);
        double side1, side2, side3;
        try {
            System.out.println("Nhap 3 canh cua tam giac:");
            System.out.print("Canh 1 = ");
            side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Canh 2 = ");
            side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Canh 3 = ");
            side3 = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Khong the chuyen canh 1 hoac canh 2 hoac canh 3 thanh so.");
        }

        if (side1 <= 0) {
            throw new IllegalRightTriangleException("Canh 1 be hon hoac bang 0.");
        } else if (side2 <= 0) {
            throw new IllegalRightTriangleException("Canh 2 be hon hoac bang 0.");
        } else if (side3 <= 0) {
            throw new IllegalRightTriangleException("Canh 3 be hon hoac bang 0.");
        }

        if (side1 > side2 + side3) {
            throw new IllegalRightTriangleException("Canh 1 lon hon tong 2 canh con lai.");
        } else if (side2 > side1 + side3) {
            throw new IllegalRightTriangleException("Canh 2 lon hon tong 2 canh con lai.");
        } else if (side3 > side1 + side2) {
            throw new IllegalRightTriangleException("Canh 3 lon hon tong 2 canh con lai.");
        }
    }
}