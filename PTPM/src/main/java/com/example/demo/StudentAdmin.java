package com.example.demo;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Thuc thi chuc nang quan tri sinh vien.
 */
public class StudentAdmin {
  
  private static final Logger LOG = Logger.getLogger(StudentAdmin.class);

  private final SinhVienTable sinhVienTable;
  
  private final HocPhanTable hocPhanTable;

  private final Scanner scanner;

  public StudentAdmin(HocPhanTable hocPhanTable, SinhVienTable sinhVienTable, Scanner scanner) {
    this.scanner = scanner;
    this.sinhVienTable = sinhVienTable;
    this.hocPhanTable = hocPhanTable;
  }

  /**
   * Thuc thi chuc nang them sinh vien.
   */
  public boolean themSinhVien() {
    LOG.info("Nhap mssv: ");
    String mssv = scanner.nextLine();
    LOG.info("Nhap ho ten: ");
    String hoTen = scanner.nextLine();
    LOG.info("Nhap so dien thoai: ");
    String sdt = scanner.nextLine();
    LOG.info("Nhap dia chi: ");
    String diaChi = scanner.nextLine();
    LOG.info("Nhap gioi tinh(M/F): ");
    char c = scanner.nextLine().charAt(0);
    LOG.info("Nhap email: ");
    String email = scanner.nextLine();
    SinhVien sv = new SinhVien(mssv, hoTen, sdt, diaChi, c, email, hocPhanTable);
    if (sinhVienTable.themSinhVien(sv)) {
      String t = sv + " da them thanh cong\n";
      LOG.info(t);
      return true;
    } else {
      LOG.info("Mssv da ton tai\n");
      return false;
    }
  }

  /**
   * Thuc thi chuc nang xoa sinh vien.
   */
  public boolean xoaSinhVien() {
    LOG.info("Nhap mssv muon xoa: ");
    String mssv = scanner.nextLine();
    SinhVien sv = sinhVienTable.timSinhVien(mssv);
    String ttsv = "Thong tin sinh vien muon xoa: " + sv + "\n";
    LOG.info(ttsv);
    if (sv != null) {
      LOG.info(ttsv);
      LOG.info("Ban co muon xoa sinh vien nay(y/n): ");
      char t = scanner.nextLine().charAt(0);
      if (Character.compare(t, 'y') == 0) {
        sinhVienTable.xoaSinhVien(sv);
      }
      return true;
    }
    LOG.info("Sinh vien muon xoa khong ton tai!\n");
    return false;
  }

  /**
   * Thuc thi chuc nang sua sinh vien.
   */
  public boolean suaSinhVien() {
    LOG.info("Nhap mssv muon sua: ");
    String mssv = scanner.nextLine();
    SinhVien sv = sinhVienTable.timSinhVien(mssv);
    if (sv != null) {
      String ttsv = sv + "\n";
      LOG.info(ttsv);
      LOG.info("Nhap ten cot muon sua: ");
      String tenCot = scanner.nextLine();
      if (tenCot.equals("mssv")) {
        LOG.info("Nhap gia tri moi: ");
        String newValue = scanner.nextLine();
        if (sinhVienTable.timSinhVien(newValue) == null) {
          sv.setId(newValue);
        } else {
          LOG.info("Mssv da ton tai!\n");
        }
      } else if (tenCot.equals("hoTen")) {
        String newValue = scanner.nextLine();
        sv.setHoTen(newValue);
      } else if (tenCot.equals("sdt")) {
        String newValue = scanner.nextLine();
        sv.setSdt(newValue);
      } else if (tenCot.equals("diaChi")) {
        String newValue = scanner.nextLine();
        sv.setDiaChi(newValue);
      } else if (tenCot.equals("gioiTinh")) {
        char newValue = scanner.nextLine().charAt(0);
        sv.setGioiTinh(newValue);
      } else if (tenCot.equals("email")) {
        String newValue = scanner.nextLine();
        sv.setEmail(newValue);
      }
      String ttsvSau = "Thong tin sinh vien sau khi duoc sua: " + sv +  "\n";
      LOG.info(ttsvSau);
      return true;
    }
    LOG.info("Sinh vien muon sua khong ton tai\n");
    return false;
  }
}
