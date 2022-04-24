package com.example.demo;

/**
 * Lop luu doi tuong sinh vien.
 */
public class SinhVien extends ThongTinCaNhan {

  private final HocPhanSinhVienDetail detail;

  public SinhVien(String id, String hoTen, String sdt, String diaChi, char gioiTinh, String email, HocPhanTable table) {
    super(id, hoTen, sdt, diaChi, gioiTinh, email);
    detail = new HocPhanSinhVienDetail(table);
  }

  public boolean themHocPhan(HocPhan hp) {
    return detail.themHocPhan(hp);
  }

  public HocPhanSinhVienDetail gethocPhanDaDangKi() {
    return detail;
  }

  public boolean xoaHocPhan(HocPhan hp) {
    return detail.xoaHocPhan(hp);
  }

  @Override
  public String toString() {
    return "SinhVien {mssv=" + super.getId() + ", hoTen=" + super.getHoTen()
        + ", sdt=" + super.getSdt() + ", diaChi=" + super.getDiaChi() + ", gioiTinh="
        + super.getGioiTinh() + ", email=" + super.getEmail() + "}";
  }
}
