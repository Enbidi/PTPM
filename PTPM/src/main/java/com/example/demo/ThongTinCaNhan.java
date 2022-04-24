package com.example.demo;

/**
 * Lop luu giu thong tin ca nhan.
 */
public class ThongTinCaNhan {

  private String id;

  private String hoTen;

  private String sdt;

  private String diaChi;

  private char gioiTinh;

  private String email;

  public ThongTinCaNhan() {}
  
  /**
   * Ham khoi tao.
   */
  public ThongTinCaNhan(String id, String hoTen, String sdt,
      String diaChi, char gioiTinh, String email) {
    this.id = id;
    this.hoTen = hoTen;
    this.sdt = sdt;
    this.diaChi = diaChi;
    this.gioiTinh = gioiTinh;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHoTen() {
    return hoTen;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
  }

  public String getSdt() {
    return sdt;
  }

  public void setSdt(String sdt) {
    this.sdt = sdt;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public char getGioiTinh() {
    return gioiTinh;
  }

  public void setGioiTinh(char gioiTinh) {
    this.gioiTinh = gioiTinh;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
