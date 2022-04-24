package com.example.demo;

import java.util.ArrayList;

/**
 * Mo phong bang sinh vien trong database.
 */
public class SinhVienTable {

  static final String[] TABLE_NAMES = {
      "mssv",
      "ho_ten",
      "sdt",
      "dia_chi",
      "gioi_tinh",
      "email"
  };

  private ArrayList<SinhVien> sinhVien;

  public SinhVienTable() {
    sinhVien = new ArrayList<>();
  }
  
  /**
   * Thuc thi chuc nang them sinh vien.
   */
  public boolean themSinhVien(SinhVien sv) {
    if (timSinhVien(sv.getId()) != null) {
      return false;
    }
    sinhVien.add(sv);
    return true;
  }

  /**
   * Thuc thi chuc nang xoa sinh vien.
   */
  public boolean xoaSinhVien(SinhVien sv) {
    return sinhVien.remove(sv);
  }
  
  /**
   * Thuc thi chuc nang xoa sinh vien.
   */
  public boolean xoaSinhVien(String mssv) {
    return sinhVien.remove(timSinhVien(mssv));
  }

  /**
   * Thuc thi chuc nang tim sinh vien.
   */
  public SinhVien timSinhVien(String id) {
    for (SinhVien sv : sinhVien) {
      if (sv.getId().equals(id)) {
        return sv;
      }
    }
    return null;
  }

  public ArrayList<SinhVien> getSinhVien() {
    return sinhVien;
  }


  @Override
  public String toString() {
    String format = "%-10s %-50s %-10s %-50s %-10s %-30s\n";
    StringBuffer buffer = new StringBuffer();
    buffer.append(
        String.format(format,
            TABLE_NAMES[0],
            TABLE_NAMES[1],
            TABLE_NAMES[2],
            TABLE_NAMES[3],
            TABLE_NAMES[4],
            TABLE_NAMES[5]));
    for (SinhVien sv : sinhVien) {
      buffer.append(String.format(format,
          sv.getId(),
          sv.getHoTen(),
          sv.getSdt(),
          sv.getDiaChi(),
          sv.getGioiTinh(),
          sv.getEmail()));
    }
    return buffer.toString();
  }
}
