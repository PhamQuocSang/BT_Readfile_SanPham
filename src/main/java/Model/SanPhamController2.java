package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SanPhamController2 implements ISanPhamController {
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    static ArrayList<SanPham> listSP = new ArrayList<SanPham>();
    Scanner scanner = new Scanner(System.in);

    public void ThucHien() throws IOException {
//        try (BufferedReader br = Files.newBufferedReader(Paths.get("DATA_FILE.txt"))) {

        FileReader fr = new FileReader("E:\\Java\\BTVN_DocFileTXTSanPham\\DATA_FILE.txt");
        BufferedReader br = new BufferedReader(fr);
        // read line by line
        String line;
        String danh_muc = "";
        String ma_danh_muc = "";
        String ngay_nhap = "";
        Boolean isValidSPId = false;
        SanPham sanPham = new SanPham();
        double giaSP = 0d;
        double giaSPT;

        while ((line = br.readLine()) != null) {
            if (line.contains("NGAY_NHAP_HANG:"))
                ngay_nhap = fixText(line, "NGAY_NHAP_HANG:");
            else if (line.contains("ID_DM:"))
                danh_muc = fixText(line, "ID_DM:");
            else if (line.contains("TEN_DM:"))
                ma_danh_muc = fixText(line, "TEN_DM:");
            else if (line.contains("ID_SP:")) {
                isValidSPId = checkValidIdSP(fixText(line, "ID_SP:"));
                sanPham = new SanPham();
                sanPham.setiDSP(fixText(line, "ID_SP:"));
            } else if (line.contains("TEN_SP:") && isValidSPId)
                sanPham.setTenSP(fixText(line, "TEN_SP:"));
            else if (line.contains("GIA_SP:") && isValidSPId) {
                // co dau phay, convert k dc
                sanPham.setGiaSP(Double.parseDouble(fixText(line, "GIA_SP:").replaceAll(",", "")));
            } else if (line.contains("SL_SP:") && isValidSPId)
                sanPham.setSoLuongSP(Integer.parseInt(fixText(line, "SL_SP:")));
            else if (line.contains("}SAN_PHAM") && isValidSPId) {
                sanPham.setTenDanhMuc(danh_muc);
                sanPham.setIdDanhMuc(ma_danh_muc);
                try {
                    sanPham.setNgayNhap(formatter.parse(ngay_nhap));
                } catch (Exception e) {
                }
                listSP.add(sanPham);
            } else if (line.contains("TEN_SP:") && !isValidSPId) {
                sanPham.setTenSP(fixText(line, "TEN_SP:"));
            } else if (line.contains("TEN_SP:") && isValidSPId)
                sanPham.setTenSP(fixText(line, "TEN_SP:"));
            else if (line.contains("GIA_SP:") && isValidSPId) {
                // co dau phay, convert k dc
                sanPham.setGiaSP(Double.parseDouble(fixText(line, "GIA_SP:").replaceAll(",", "")));
            } else if (line.contains("SL_SP:") && isValidSPId)
                sanPham.setSoLuongSP(Integer.parseInt(fixText(line, "SL_SP:")));
            else if (line.contains("}SAN_PHAM") && isValidSPId) {
                sanPham.setTenDanhMuc(danh_muc);
                sanPham.setIdDanhMuc(ma_danh_muc);
                try {
                    sanPham.setNgayNhap(formatter.parse(ngay_nhap));
                } catch (Exception e) {
                }
            }
        }

//        } catch (IOException e) {
//            System.err.format("IOException: %s%n", e);
//        }

        System.out.println("Danh sách sản phẩm");
        for (SanPham sp : listSP) {
            System.out.println(sp.toString());
        }
        System.out.println();
    }

//    public void HienThiIDSP() {
//        System.out.println("Hiển thị ID sản phẩm: ");
//        for (SanPham sp : listSP) {
//            System.out.print(sp.getiDSP().toString() + "\t");
//        }
//    }

    public void tinhGiaTriTheoTenDanhMuc() {
        System.out.print("Nhập mã danh mục mà bạn muốn tính tổng: ");
        String s = scanner.nextLine().toUpperCase();
        double tong = 0f;
        boolean timThay = false;
        for (SanPham ss : listSP
        ) {
            if (s.equals(ss.getTenDanhMuc())) {
                timThay = true;
                tong = tong + ss.getGiaSP();
            }
        }
        if (timThay == false) {
            System.out.println("Không tìm thấy mã danh mục tương ứng trong danh sách!");
        }
        //Convert sang string để bỏ Exponential (E)
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);

        System.out.print("Tổng giá trị của danh mục có mã " + s + " là: ");
        System.out.println(df.format(tong));
    }

    public void timKiem() {
        System.out.print("Nhập mã sản phẩm mà bạn muốn tìm: ");
        String s = scanner.nextLine().toUpperCase();
        boolean timThay = false;
        for (SanPham ss : listSP
        ) {
            if (s.equals(ss.getiDSP())) {
                timThay = true;
                System.out.println(ss.toString());
            }
        }
        if (timThay == false) {
            System.out.println("Không tìm thấy mã sản phẩm tương ứng trong danh sách!");
        }
    }

    public static boolean checkValidIdSP(String maSP) {
        if (maSP.length() == 5) {
            Pattern p = Pattern.compile("[A-Z]{2}[0-9]{3}");
            Matcher m = p.matcher(maSP);
            boolean b = m.matches();
            if (b == true) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("ID phải có 5 kí tự gồm 2 chữ cái đầu in hoa và 3 chữ số");
        }
        return false;
    }

    public static String fixText(String text, String remove) {
        //text.replaceAll(" ", "") thay thế khoảng trắng giữa các từ -> xóa khoảng trắng
        return text.replaceAll(" ", "").replace(remove, "");
    }

    public void Quicksort() {
        ArrayList list = new ArrayList();
        ArrayList<SanPham> listSp = new ArrayList<SanPham>();
        for (SanPham s : listSP
        ) {
            list.add(s.getGiaSP());
        }
        System.out.println("Gía sản phẩm trước khi sắp xếp");
        System.out.println(list.toString());

        System.out.println("Gía sản phẩm sau khi sắp xếp");
        list.sort(Comparator.naturalOrder());
    }
}