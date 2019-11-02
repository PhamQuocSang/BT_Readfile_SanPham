package BTVN_DocFileTXTSanPham;

import Model.SanPham;
import Model.SanPhamController2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

//        ReadTxt t = new ReadTxt();
//        t.Read();
        ArrayList listSP = new ArrayList<SanPham>();

        ArrayList sanPhams = new ArrayList<String>();
        SanPhamController2 sanPhamController2 = new SanPhamController2();
        sanPhamController2.ThucHien();
//        s.tinhGiaTriTheoTenDanhMuc();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("_________________________________________");
            System.out.println("Chọn một trong các phương thức hành động sau: \n1. Tính tổng giá trị theo mã danh mục \n2. Tìm kiếm sản phẩm theo mã \n3. Sắp xếp tăng dần theo giá ");
            System.out.println("_________________________________________");
            System.out.print("Chọn: ");
            String temp = scanner.nextLine();
            switch (temp) {
                case "1":
                    sanPhamController2.tinhGiaTriTheoTenDanhMuc();
                    break;
                case "2":
                    sanPhamController2.timKiem();
                    break;
                case "3":
                    sanPhamController2.Quicksort();
                    break;
                default:
                    break;
            }
        }
    }
}
