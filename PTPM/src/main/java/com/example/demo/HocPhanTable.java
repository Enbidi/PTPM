package com.example.demo;

import java.util.ArrayList;

/**
 * Lop mo phong table trong database.
 */
public class HocPhanTable {

  static final String[] TABLE_NAMES = {
      "ma_hp",
      "ten_hp"
  };

  private ArrayList<HocPhan> hocPhan;

  public HocPhanTable() {
    hocPhan = new ArrayList<>();
  }

  /**
   * Thuc thi chuc nang them hoc phan.
   */
  public boolean themHocPhan(HocPhan hp) {
    if (timHocPhan(hp.getMaHocPhan()) != null) {
      return false;
    }
    hocPhan.add(hp);
    return true;
  }

  /**
   * Thuc thi chuc nang xoa hoc phan.
   */
  public HocPhan xoaHocPhan(String maHp) {
    HocPhan hpCanXoa = timHocPhan(maHp);
    if (hpCanXoa != null) {
      hocPhan.remove(hpCanXoa);
    }
    return hpCanXoa;
  }

  /**
   * Thuc thi chuc nang tim hoc phan.
   */
  public HocPhan timHocPhan(String maHp) {
    for (HocPhan hp : hocPhan) {
      if (hp.getMaHocPhan().equals(maHp)) {
        return hp;
      }
    }
    return null;
  }

  public ArrayList<HocPhan> getHocPhan() {
    return hocPhan;
  }

  @Override
  public String toString() {
    String format = "%-10s %-50s\n";
    StringBuffer buffer = new StringBuffer();
    buffer.append(String.format(format, TABLE_NAMES[0], TABLE_NAMES[1]));
    for (HocPhan hp : hocPhan) {
      buffer.append(String.format(format, hp.getMaHocPhan(), hp.getTenHocPhan()));
    }
    return buffer.toString();
  }
}
