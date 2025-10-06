/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assigment12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class Assigment12 {

    static ArrayList<String> ds = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("========== MENU QUAN LY NHAN VIEN ==========");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.println("3. Tim va hien thi nhan vien theo ma");
            System.out.println("4. Xoa nhan vien theo ma");
            System.out.println("5. Cap nhat thong tin nhan vien theo ma");
            System.out.println("6. Tim nhan vien theo khoang luong");
            System.out.println("7. Sap xep nhan vien theo ho va ten");
            System.out.println("8. Sap xep nhan vien theo thu nhap");
            System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
            System.out.println("0. Thoat");
            System.out.println("===========================================");
            System.out.print("Moi ban chon chuc nang: ");

            chon = sc.nextInt();
            sc.nextLine(); // bỏ qua ký tự Enter

            switch (chon) {
                case 1:
                    nhapDanhSach(sc);
                    break;
                case 2:
                    xuatDanhSach();
                    break;
                case 3:
                    System.out.println("==> Chuc nang 3: Tim va hien thi nhan vien theo ma (chua lam)");
                    break;
                case 4:
                    System.out.println("==> Chuc nang 4: Xoa nhan vien theo ma (chua lam)");
                    break;
                case 5:
                    System.out.println("==> Chuc nang 5: Cap nhat thong tin nhan vien theo ma (chua lam)");
                    break;
                case 6:
                    System.out.println("==> Chuc nang 6: Tim nhan vien theo khoang luong (chua lam)");
                    break;
                case 7:
                    System.out.println("==> Chuc nang 7: Sap xep nhan vien theo ho va ten (chua lam)");
                    break;
                case 8:
                    System.out.println("==> Chuc nang 8: Sap xep nhan vien theo thu nhap (chua lam)");
                    break;
                case 9:
                    System.out.println("==> Chuc nang 9: Xuat 5 nhan vien co thu nhap cao nhat (chua lam)");
                    break;
                case 0:
                    System.out.println("==> Thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }

            System.out.println(); 
        } while (chon != 0);
    }
    public static void nhapDanhSach(Scanner sc) {
        System.out.print("Nhap so nhan vien: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten nhan vien thu " + (i + 1) + ": ");
            String ten = sc.nextLine();
            ds.add(ten);
        }
        System.out.println("==> Da nhap xong danh sach nhan vien!");
    }

    public static void xuatDanhSach() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("===== DANH SACH NHAN VIEN =====");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println("Ten nhan vien "+(i + 1) + ": " + ds.get(i));
        }
    }
}
