/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assigment12;

import java.util.*;

/**
 *
 * @author ICT
 */
public class Assigment2 {
    static ArrayList<NhanVien> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n========= MENU =========");
                System.out.println("1. Nhap danh sach nhan vien");
                System.out.println("2. Xuat danh sach nhan vien");
                System.out.println("3. Tim nhan vien theo ma");
                System.out.println("4. Xoa nhan vien theo ma");
                System.out.println("5. Cap nhat thong tin nhan vien");
                System.out.println("6. Tim nhan vien theo khoang luong");
                System.out.println("7. Sap xep theo ho ten");
                System.out.println("8. Sap xep theo thu nhap");
                System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
                System.out.println("0. Thoat");
                System.out.print("Chon chuc nang: ");

                int chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1 -> MainQuanLyNhanVien.nhapDanhSach(list, sc);
                    case 2 -> MainQuanLyNhanVien.xuatDanhSach(list);
                    case 3 -> MainQuanLyNhanVien.timTheoMa(list, sc);
                    case 4 -> MainQuanLyNhanVien.xoaTheoMa(list, sc);
                    case 5 -> MainQuanLyNhanVien.capNhatTheoMa(list, sc);
                    case 6 -> MainQuanLyNhanVien.timTheoKhoangLuong(list, sc);
                    case 7 -> MainQuanLyNhanVien.sapXepTheoTen(list);
                    case 8 -> MainQuanLyNhanVien.sapXepTheoThuNhap(list);
                    case 9 -> MainQuanLyNhanVien.top5ThuNhap(list);
                    case 0 -> {
                        System.out.println("Ket thuc chuong trinh!");
                        return;
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
            } catch (Exception e) {
                System.out.println("Loi nhap lieu! Vui long nhap lai.");
            }
        }
    }
}
