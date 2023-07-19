package ss7.bai_tap.trien_khai_interface_Colorable_cho_cac_lop_hinh_hoc;

public class CircleTest {

        public static void main(String[] args) {
            Circle circle = new Circle();
            System.out.println(circle);

            circle = new Circle(3.5);
            System.out.println(circle);

            circle = new Circle(3.5, "indigo", false);
            System.out.println(circle);
        }
    }

