package com.example.demo;

import java.util.ArrayList;

/**
 * Lop lien ket luu hoc phan cua sinh vien da dang ki.
 */
public class HocPhanSinhVienDetail {

  private ArrayList<HocPhan> hocPhanDaDangKi;
  
  private final HocPhanTable TABLE;

  public HocPhanSinhVienDetail(HocPhanTable TABLE) {
    hocPhanDaDangKi = new ArrayList<>();
    this.TABLE = TABLE;
  }

  /**
   * Thuc thi chuc nang tim hoc phan da dang ki.
   */
  public HocPhan timHocPhan(String maHp) {
    for (HocPhan hp : hocPhanDaDangKi) {
      if (hp.getMaHocPhan().equals(maHp)) {
        return hp;
      }
    }
    return null;
  }

  /**
   * THuc thi chuc nang them hoc phan.
   */
  public boolean themHocPhan(HocPhan hp) {
    if (TABLE.timHocPhan(hp.getMaHocPhan()) != hp) {
      return false;
    }
    hocPhanDaDangKi.add(hp);
    return true;
  }

  public boolean xoaHocPhan(HocPhan hp) {
    return hocPhanDaDangKi.remove(hp);
  }

  public ArrayList<HocPhan> get() {
    return hocPhanDaDangKi;
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    for (HocPhan hp : hocPhanDaDangKi) {
      buffer.append(hp + "\n");
    }
    return buffer.toString();
  }
}
