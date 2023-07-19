package ss7.bai_tap.trien_khai_interface_Resizeable_cho_cac_lop_hinh_hoc;


public class ShapeTest {

    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}