package Model;

import java.util.Date;

public class SanPham {
    private String iDSP;
    private String tenSP;
    private Double giaSP;
    private int soLuongSP;
    private String idDanhMuc;
    private String tenDanhMuc;
    private Date ngayNhap;

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public SanPham(String iDSP, String tenSP, Double giaSP, int soLuongSP, String idDanhMuc, String tenDanhMuc, Date ngayNhap) {
        this.iDSP = iDSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.soLuongSP = soLuongSP;
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.ngayNhap = ngayNhap;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "iDSP='" + iDSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaSP=" + giaSP +
                ", soLuongSP=" + soLuongSP +
                ", idDanhMuc='" + idDanhMuc + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", ngayNhap=" + ngayNhap +
                '}';
    }

    public SanPham() {
        iDSP = tenSP = tenDanhMuc = idDanhMuc = "";
        giaSP = 0.0;
        soLuongSP = 0;
        ngayNhap = new Date();
    }

    public String getiDSP() {
        return iDSP;
    }

    public void setiDSP(String iDSP) {
        this.iDSP = iDSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(Double giaSP) {
        this.giaSP = giaSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }


}
