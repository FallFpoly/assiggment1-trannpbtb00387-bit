package com.mycompany.assignment12;

import java.util.Scanner;

public class TiepThi extends NhanVien {
    private double doanhSo;
    private double hueHong;

    public TiepThi() {}

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhap doanh so: ");
                this.doanhSo = Double.parseDouble(sc.nextLine());
                System.out.print("Nhap hoa hong: ");
                this.hueHong = Double.parseDouble(sc.nextLine());
                if (doanhSo < 0 || hueHong < 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Nhap sai, vui long nhap so duong!");
            }
        }
    }

    @Override
    public double getThuNhap() {
        return luong + doanhSo * hueHong / 100;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("Doanh so: %.2f | Hoa hong: %.2f%%%n", doanhSo, hueHong);
    }
}
