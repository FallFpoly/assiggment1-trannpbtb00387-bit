/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assigment12;

/**
 *
 * @author ICT
 */
import java.util.Scanner;

public class Assigment12 {
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
            sc.nextLine(); // bo qua ky tu Enter
            
            switch (chon) {
                case 1:
                    System.out.println("==> Chuc nang 1: Nhap danh sach nhan vien");
                    break;
                case 2:
                    System.out.println("==> Chuc nang 2: Xuat danh sach nhan vien");
                    break;
                case 3:
                    System.out.println("==> Chuc nang 3: Tim va hien thi nhan vien theo ma");
                    break;
                case 4:
                    System.out.println("==> Chuc nang 4: Xoa nhan vien theo ma");
                    break;
                case 5:
                    System.out.println("==> Chuc nang 5: Cap nhat thong tin nhan vien theo ma");
                    break;
                case 6:
                    System.out.println("==> Chuc nang 6: Tim nhan vien theo khoang luong");
                    break;
                case 7:
                    System.out.println("==> Chuc nang 7: Sap xep nhan vien theo ho va ten");
                    break;
                case 8:
                    System.out.println("==> Chuc nang 8: Sap xep nhan vien theo thu nhap");
                    break;
                case 9:
                    System.out.println("==> Chuc nang 9: Xuat 5 nhan vien co thu nhap cao nhat");
                    break;
                case 0:
                    System.out.println("==> Thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
            System.out.println(); 
            if (chon < 1 || chon > 9) {
                System.out.println("Ban nhap sai, nhap lai!");
                System.out.println();
                continue; // hỏi lại
            }
        } while (chon != 0);
        
    }
}
