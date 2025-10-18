/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

/**
 *
 * @author nguye
 */
import java.util.Scanner;

public class TiepThi extends NhanVien {
    private double doanhSo;
    private double hueHong;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        while (true) {
            try {
                System.out.print("Nhap doanh so: ");
                doanhSo = Double.parseDouble(sc.nextLine());
                if (doanhSo < 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Doanh so phai la so duong!");
            }
        }

        while (true) {
            try {
                System.out.print("Nhap hoa hong: ");
                hueHong = Double.parseDouble(sc.nextLine());
                if (hueHong < 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Hoa hong phai la so duong!");
            }
        }
    }

    @Override
    public double getThuNhap() {
        return luong + doanhSo * hueHong;
    }
}
