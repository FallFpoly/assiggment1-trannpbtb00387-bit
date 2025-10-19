/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public abstract class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected double luong;

    public NhanVien() {}

    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = chuanHoaTen(hoTen);
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = chuanHoaTen(hoTen);
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    // Phương thức trừu tượng
    public abstract double getThuNhap();

    // Tính thuế thu nhập
    public double getThueTN() {
        double thuNhap = getThuNhap();
        if (thuNhap < 9000000) {
            return 0;
        } else if (thuNhap <= 15000000) {
            return (thuNhap - 9000000) * 0.1;
        } else {
            return (thuNhap - 15000000) * 0.12 + 600000;
        }
    }

    // Nhập thông tin nhân viên
    public void nhap(Scanner sc) {
        // Nhập họ tên và kiểm tra hợp lệ
        while (true) {
            System.out.print("Nhap ho ten: ");
            String ten = sc.nextLine().trim();
            if (ten.isEmpty()) {
                System.out.println("Ho ten khong duoc de trong!");
            } else if (ten.matches(".*\\d.*")) {
                System.out.println("Ho ten khong duoc chua chu so!");
            } else {
                this.hoTen = chuanHoaTen(ten);
                break;
            }
        }

        // Nhập lương hợp lệ
        while (true) {
            try {
                System.out.print("Nhap luong: ");
                double l = Double.parseDouble(sc.nextLine());
                if (l < 0) throw new Exception();
                this.luong = l;
                break;
            } catch (Exception e) {
                System.out.println("Luong phai la so duong!");
            }
        }
    }

    // Kiểm tra mã nhân viên hợp lệ (phải có ít nhất 1 chữ và 1 số)
    private boolean isValidMaNV(String ma) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char c : ma.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasLetter && hasDigit;
    }

    // Chuẩn hóa họ tên: viết hoa chữ cái đầu mỗi từ
    private String chuanHoaTen(String name) {
        name = name.trim().toLowerCase();
        String[] words = name.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1))
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Xuất thông tin nhân viên
    public void xuatThongTin() {
        System.out.printf("Ma: %s | Ho ten: %s | Luong: %.0f | Thu nhap: %.0f | Thue TN: %.0f\n",
                maNV, hoTen, luong, getThuNhap(), getThueTN());
    }
}
