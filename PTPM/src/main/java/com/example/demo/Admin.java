package com.example.demo;

import java.util.Scanner;

/**
 * Chuc nang quan tri.
 */
public class Admin extends ThongTinCaNhan {

  private HocPhanAdmin hocPhanAdmin;

  private StudentAdmin sinhVienAdmin;

  public Admin(HocPhanTable hpTable, SinhVienTable svTable, Scanner scanner) {
    this.hocPhanAdmin = new HocPhanAdmin(hpTable, scanner);
    this.sinhVienAdmin = new StudentAdmin(hpTable, svTable, scanner);
  }

  public HocPhanAdmin getHocPhanAdmin() {
    return hocPhanAdmin;
  }

  public void setHocPhanAdmin(HocPhanAdmin hocPhanAdmin) {
    this.hocPhanAdmin = hocPhanAdmin;
  }

  public StudentAdmin getSinhVienAdmin() {
    return sinhVienAdmin;
  }

  public void setSinhVienAdmin(StudentAdmin sinhVienAdmin) {
    this.sinhVienAdmin = sinhVienAdmin;
  }
  
}
