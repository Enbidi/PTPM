package com.example.demo;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Thuc thi chuc nang quan tri hoc phan cua admin.
 */
public class HocPhanAdmin {
  
  private static final Logger LOG = Logger.getLogger(HocPhanAdmin.class);

  private final HocPhanTable hocPhanTable;

  private final Scanner scanner;

  public HocPhanAdmin(HocPhanTable hocPhanTable, Scanner scanner) {
    this.hocPhanTable = hocPhanTable;
    this.scanner = scanner;
  }
  
  /**
   * Thuc thi chuc nang them hoc phan.
   */
  public boolean themHocPhan() {
    String info;
    LOG.info("Nhap ma hoc phan: ");
    String maHp = scanner.nextLine();
    LOG.info("Nhap ten hoc phan: ");
    String tenHp = scanner.nextLine();
    HocPhan hp = new HocPhan(maHp, tenHp);
    if (hocPhanTable.themHocPhan(hp)) {
      info = hp + " da them thanh cong!\n";
      LOG.info(info);
      return true;
    } else {
      info = "Ma hoc phan da ton tai\n";
      LOG.info(info);
      return false;
    }
  }
  
  /**
   * Thuc thi chuc nang xoa hoc phan.
   */
  public boolean xoaHocPhan() {
    
    LOG.info("Nhap ma hoc phan muon xoa: ");
    String maHp = scanner.nextLine();
    HocPhan hpCanXoa = hocPhanTable.xoaHocPhan(maHp);
    if (hpCanXoa != null) {
      String info = hpCanXoa + " da duoc xoa!" + "\n";
      LOG.info(info);
      return true;
    } else {
      LOG.info("Hoc phan muon xoa khong ton tai");
      return false;
    }
  }

  /**
   * Thuc thi chuc nang sua hoc phan.
   */
  public boolean suaHocPhan() {
    LOG.info("Nhap ma hoc phan muon sua: ");
    String maHp = scanner.nextLine();
    HocPhan hp = hocPhanTable.timHocPhan(maHp);
    if (hp != null) {
      LOG.info(hp + "\n");
      LOG.info("Nhap ten cot muon sua: ");
      String t = scanner.nextLine();
      switch (t) {
        case "maHocPhan":
          LOG.info("Nhap gia tri moi: ");
          String temp = scanner.nextLine();
          if (hocPhanTable.timHocPhan(temp) != null) {
            LOG.info("Ma hoc phan da ton tai!\n");
          } else {
            hp.setMaHocPhan(temp);
          }
          break;
        case "tenHocPhan":
          LOG.info("Nhap gia tri moi: ");
          hp.setTenHocPhan(scanner.nextLine());
          LOG.info(hp + " da duoc cap nhat thanh cong.\n");
          break;
        default:
          System.out.println("Ten truong khong ton tai!\n");
      }
      return true;
    } else {
      LOG.info("Hoc phan khong ton tai!\n");
      return false;
    }
  }
}
