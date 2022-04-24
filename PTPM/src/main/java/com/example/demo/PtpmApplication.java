package com.example.demo;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Lop chinh noi thuc thi ung dung.
 */
public class PtpmApplication {
  
  private static final Logger LOG = Logger.getLogger(PtpmApplication.class);

  private static final String FUNCTION = 
      "1. Quan tri hoc phan.\n"
          + "2. Quan tri sinh vien.\n"
          + "3. Sinh vien.\n"
          + "4. Thoat.\n";


  private static final String HOC_PHAN_ADMIN_FUNC =
      "1. Them hoc phan.\n"
          + "2. Sua hoc phan.\n"
          + "3. Xoa hoc phan.\n"
          + "4. Hien thi cac hoc phan hien co.\n"
          + "5. Thoat.\n";

  private static final String SINH_VIEN_ADMIN_FUNC = 
      "1. Them sinh vien.\n"
          + "2. Sua sinh vien.\n"
          + "3. Xoa sinh vien.\n"
          + "4. Hien thi cac sinh vien hien co.\n"
          + "5. Thoat.\n";

  private static final String SINH_VIEN_FUNC = 
      "1. Dang ki hoc phan.\n"
          + "2. Hien thi hoc phan da dang ki.\n"
          + "3. Xoa hoc phan da dang ki.\n"
          + "4. Thoat.\n";

  public final HocPhanTable hocPhanTable;

  public final SinhVienTable sinhVienTable;

  public PtpmApplication() {
    hocPhanTable = new HocPhanTable();
    sinhVienTable = new SinhVienTable();
  }

  /**
   * Bat dau chuong trinh.
   */
  public void run() {
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin(hocPhanTable, sinhVienTable, scanner);
    SinhVienFunction sinhVienFunc;
    String t;
    while (true) {
      //LOG.info(function);
      LOG.info(FUNCTION);
      LOG.info("Lua chon cua ban: ");
      t = scanner.nextLine();
      if (t.equals("1")) {
        while (true) {
          LOG.info(HOC_PHAN_ADMIN_FUNC);
          LOG.info("Nhap lua chon cua ban: ");
          String t1 = scanner.nextLine();
          if (t1.equals("1")) {
            admin.getHocPhanAdmin().themHocPhan();
          } else if (t1.equals("2")) {
            admin.getHocPhanAdmin().suaHocPhan();
          } else if (t1.equals("3")) {
            admin.getHocPhanAdmin().xoaHocPhan();
          } else if (t1.equals("4")) {
            LOG.info(hocPhanTable);
          } else if (t1.equals("5")) {
            break;
          }
          LOG.info("Ban co muon tiep tuc(y/n)?: ");
          if (scanner.nextLine().charAt(0) == 'n') {
            break;
          }
        }
      } else if (t.equals("2")) {
        while (true) {
          LOG.info(SINH_VIEN_ADMIN_FUNC);
          LOG.info("Nhap lua chon cua ban: ");
          String t1 = scanner.nextLine();
          if (t1.equals("1")) {
            admin.getSinhVienAdmin().themSinhVien();
          } else if (t1.equals("2")) {
            admin.getSinhVienAdmin().suaSinhVien();
          } else if (t1.equals("3")) {
            admin.getSinhVienAdmin().xoaSinhVien();
          } else if (t1.equals("4")) {
            LOG.info(sinhVienTable);
          } else if (t1.equals("5")) {
            break;
          }
          LOG.info("Ban co muon tiep tuc(y/n)?: ");
          if (Character.compare(scanner.nextLine().charAt(0), 'n') == 0) {
            break;
          }
        }
      } else if (t.equals("3")) {
        LOG.info("Cac sinh vien hien co:");
        LOG.info(sinhVienTable);
        LOG.info("Nhap mssv muon thao tac: ");
        String mssv = scanner.nextLine();
        SinhVien sv = sinhVienTable.timSinhVien(mssv);
        if (sv == null) {
          LOG.info("Sinh vien khong ton tai!");
          continue;
        }
        sinhVienFunc = new SinhVienFunction(sv, hocPhanTable, scanner);
        while (true) {
          LOG.info(SINH_VIEN_FUNC);
          LOG.info("Nhap lua chon cua ban: ");
          String t1 = scanner.nextLine();
          if (t1.equals("1")) {
            sinhVienFunc.themHocPhan();
          } else if (t1.equals("2")) {
            sinhVienFunc.hienThiHocPhanDaDangKi();
          } else if (t1.equals("3")) {
            sinhVienFunc.xoaHocPhan();
          } else if (t1.equals("4")) {
            break;
          }
          LOG.info("Ban co muon tiep tuc(y/n)?: ");
          if (Character.compare(scanner.nextLine().charAt(0), 'n') == 0) {
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    PtpmApplication app = new PtpmApplication();
    app.run();
  }

}
