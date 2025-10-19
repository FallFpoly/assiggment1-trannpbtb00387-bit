/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment12;

/**
 *
 * @author nguye
 */
import java.util.Scanner;

public class TruongPhong extends com.mycompany.assigment12.NhanVien {
    private double trachNhiem;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        while (true) {
            try {
                System.out.print("Nhap tien trach nhiem: ");
                trachNhiem = Double.parseDouble(sc.nextLine());
                if (trachNhiem < 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Trach nhiem phai la so duong!");
            }
        }
    }

    @Override
    public double getThuNhap() {
        return luong + trachNhiem;
    }
}
