package com.mycompany.assignment12;

import java.util.Scanner;

public abstract class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected double luong;

    public NhanVien() {}

    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        this.hoTen = sc.nextLine();
        while (true) {
            try {
                System.out.print("Nhap luong co ban: ");
                this.luong = Double.parseDouble(sc.nextLine());
                if (luong < 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Luong phai la so duong. Nhap lai!");
            }
        }
    }

    public void xuatThongTin() {
        System.out.printf("Ma: %-10s | Ho ten: %-20s | Luong: %10.2f | Thu nhap: %10.2f%n",
                maNV, hoTen, luong, getThuNhap());
    }

    public double getThueTNCN() {
        double thuNhap = getThuNhap();
        if (thuNhap < 9000000) return 0;
        else if (thuNhap < 15000000) return (thuNhap - 9000000) * 0.1;
        else return (thuNhap - 15000000) * 0.12 + 600000;
    }

    public abstract double getThuNhap();
}
