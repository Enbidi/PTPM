package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PtpmApplicationTests {

  PtpmApplication app = new PtpmApplication();
  
  @BeforeEach
  public void init() {
    HocPhanTable hocPhanTable = app.hocPhanTable;
    HocPhan hp = new HocPhan("ct101", "N1");
    hocPhanTable.themHocPhan(hp);
    
    SinhVienTable sinhVienTable = app.sinhVienTable;
    SinhVien sv = new SinhVien(
        "b9999999", "Nguyen Van A", "1234567890", "Trai Dat", 'M', "abcd@gmail.com", hocPhanTable);
    sv.themHocPhan(hp);
    sinhVienTable.themSinhVien(sv);
  }

  @Test
  public void testThemTrungMaHp() {
    HocPhanTable table = app.hocPhanTable;
    HocPhan hp = new HocPhan("ct101", "N2");
    table.themHocPhan(hp);
    assertEquals(1, table.getHocPhan().size());
  }

  @Test
  public void testThemTrungMssv() {
    SinhVienTable table = app.sinhVienTable;
    SinhVien sv = new SinhVien(
        "b9999999", "Nguyen Van B", "0987654321", "Trai Dat", 'F', "dcba@gmail.com", app.hocPhanTable);
    table.themSinhVien(sv);
    assertEquals(1, table.getSinhVien().size());
  }

  @Test
  public void testTimSinhVienKhongTonTai() {
    SinhVienTable table = app.sinhVienTable;
    assertEquals(null, table.timSinhVien("B1111111"));
  }
  
  @Test
  public void testTimSinhVienTonTai() {
    SinhVienTable table = app.sinhVienTable;
    assertEquals(table.getSinhVien().get(0), table.timSinhVien("b9999999"));
  }
  
  @Test
  public void testXoaSinhVienKhongTonTai() {
    SinhVienTable table = app.sinhVienTable;
    table.xoaSinhVien("b1234567");
    assertEquals(1, table.getSinhVien().size());
  }
  
  @Test
  public void testXoaSinhVienTonTai() {
    SinhVienTable table = app.sinhVienTable;
    table.xoaSinhVien("b9999999");
    assertEquals(0, table.getSinhVien().size());
  }
  
  @Test
  public void testTimHocPhanKhongTonTai() {
    HocPhanTable table = app.hocPhanTable;
    assertEquals(null, table.timHocPhan("ct102"));
  }
  
  @Test
  public void testTimHocPhanTonTai() {
    HocPhanTable table = app.hocPhanTable;
    assertEquals(table.getHocPhan().get(0), table.timHocPhan("ct101"));
  }
  
  @Test
  public void testXoaHocPhanKhongTonTai() {
    HocPhanTable table = app.hocPhanTable;
    table.xoaHocPhan("ct102");
    assertEquals(1, table.getHocPhan().size());
  }
  
  @Test
  public void testXoaHocPhanTonTai() {
    HocPhanTable table = app.hocPhanTable;
    table.xoaHocPhan("ct101");
    assertEquals(0, table.getHocPhan().size());
  }
  
  @Test
  public void testSinhVienDangKiHocPhanKhongTonTai() {
    SinhVienTable svTable = app.sinhVienTable;
    assertEquals(false, svTable.getSinhVien().get(0).themHocPhan(new HocPhan("", "")));
  }
  
  @Test
  public void testSinhVienDangKiHocPhanTonTai() {
    SinhVienTable svTable = app.sinhVienTable;
    assertEquals(true, svTable.getSinhVien().get(0).themHocPhan(app.hocPhanTable.timHocPhan("ct101")));
  }
  
  @Test
  public void testSinhVienXoaHocPhanKhongTonTai() {
    SinhVienTable svTable = app.sinhVienTable;
    assertEquals(false, svTable.getSinhVien().get(0).xoaHocPhan(new HocPhan("", "")));
  }
  
  @Test
  public void testSinhVienXoaHocPhanTonTai() {
    SinhVienTable svTable = app.sinhVienTable;
    assertEquals(true, svTable.getSinhVien().get(0).xoaHocPhan(app.hocPhanTable.timHocPhan("ct101")));
  }
}
