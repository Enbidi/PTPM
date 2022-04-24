package com.example.demo;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Lop thuc thi chuc nang cua sinh vien.
 */
public class SinhVienFunction {
  
  private static final Logger LOG = Logger.getLogger(SinhVienFunction.class);
  
  private final Scanner scanner;

  private final SinhVien sinhVien;

  private final HocPhanTable hocPhan;
  
  /**
   * Ham khoi tao.
   */
  public SinhVienFunction(SinhVien sinhVien, HocPhanTable hocPhan, Scanner scanner) {
    this.sinhVien = sinhVien;
    this.hocPhan = hocPhan;
    this.scanner = scanner;
  }

  /**
   * Thuc thi them hoc phan da dang ki cua sinh vien.
   */
  public boolean themHocPhan() {
    LOG.info("Cac hoc phan hien co:\n");
    String info = hocPhan + "\n";
    LOG.info(info);
    LOG.info("Nhap ma hoc phan muon them: ");
    String maHp = scanner.nextLine();
    HocPhan hp = hocPhan.timHocPhan(maHp);
    if (hp != null) {
      sinhVien.themHocPhan(hp);
      info = hp + " da them thanh cong!\n"; 
      LOG.info(info);
      return true;
    } else {
      LOG.info("Hoc phan khong ton tai\n");
      return false;
    }
  }

  /**
   * Hien thi tat cac hoc phan da dang ki.
   */
  public void hienThiHocPhanDaDangKi() {
    String info = sinhVien.gethocPhanDaDangKi() + "\n";
    LOG.info(info);
  }
  
  /**
   * Thuc thi xoa hoc phan da dang ki cua sinh vien.
   */
  public boolean xoaHocPhan() {
    String info = sinhVien.gethocPhanDaDangKi() + "\n";
    LOG.info("Cac hoc phan da dang ki:\n");
    LOG.info(info);
    LOG.info("Nhap hoc phan muon xoa: ");
    String maHp = scanner.nextLine();
    HocPhan hp = hocPhan.timHocPhan(maHp);
    if (hp != null) {
      info = hp + " da duoc dang ki, ban xac nhan muon xoa(y/n)?: ";
      LOG.info(info);
      char t = scanner.nextLine().charAt(0);
      if (Character.compare(t, 'y') == 0) {
        sinhVien.xoaHocPhan(hp);
        info = hp + " da duoc xoa!\n";
        LOG.info(info);
        return true;
      }
    } else {
      LOG.info("Hoc phan khong ton tai");
    }
    return false;
  }
}
