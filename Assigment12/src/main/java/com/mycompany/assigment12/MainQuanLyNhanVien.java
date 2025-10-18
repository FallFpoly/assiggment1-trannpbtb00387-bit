package com.mycompany.assigment12;

import java.util.*;

public class MainQuanLyNhanVien {

    public static void nhapDanhSach(ArrayList<NhanVien> list, Scanner sc) {
        int n;
        while (true) {
            try {
                System.out.print("Nhap so luong nhan vien: ");
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("So luong phai lon hon 0!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Vui long nhap so hop le!");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap nhan vien thu " + (i + 1) + " ---");
            int loai;
            while (true) {
                try {
                    System.out.print("Chon loai nhan vien (1. Hanh chinh | 2. Tiep thi | 3. Truong phong): ");
                    loai = Integer.parseInt(sc.nextLine());
                    if (loai < 1 || loai > 3) {
                        System.out.println("Chi duoc nhap tu 1 den 3!");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Nhap sai dinh dang! Vui long nhap so tu 1 den 3.");
                }
            }

            NhanVien nv;
            if (loai == 1) nv = new NhanVienHanhChinh();
            else if (loai == 2) nv = new TiepThi();
            else nv = new TruongPhong();

            // --- kiem tra trung ma va hop le ---
            while (true) {
                System.out.print("Nhap ma nhan vien: ");
                String ma = sc.nextLine().trim();

                if (ma.isEmpty()) {
                    System.out.println("Ma nhan vien khong duoc de trong!");
                } else if (!ma.matches(".*\\d.*") || !ma.matches(".*[a-zA-Z].*")) {
                    System.out.println("Ma nhan vien phai chua ca chu va so!");
                } else if (kiemTraMaTrung(list, ma)) {
                    System.out.println("Ma nhan vien da ton tai, vui long nhap lai!");
                } else {
                    nv.setMaNV(ma);
                    break;
                }
            }

            try {
                nv.nhap(sc); // nhập thông tin chi tiết
                list.add(nv);
            } catch (Exception e) {
                System.out.println("Loi khi nhap thong tin nhan vien! Bo qua nhan vien nay.");
            }
        }
    }

    public static boolean kiemTraMaTrung(ArrayList<NhanVien> list, String ma) {
        for (NhanVien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    public static void xuatDanhSach(ArrayList<NhanVien> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        list.forEach(NhanVien::xuatThongTin);
    }

    public static void timTheoMa(ArrayList<NhanVien> list, Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        boolean found = false;
        for (NhanVien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                nv.xuatThongTin();
                found = true;
            }
        }
        if (!found) System.out.println("Khong tim thay nhan vien co ma: " + ma);
    }

    public static void xoaTheoMa(ArrayList<NhanVien> list, Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap ma can xoa: ");
        String ma = sc.nextLine();
        boolean removed = list.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));
        if (removed)
            System.out.println("Da xoa nhan vien co ma: " + ma);
        else
            System.out.println("Khong tim thay nhan vien can xoa!");
    }

    public static void capNhatTheoMa(ArrayList<NhanVien> list, Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap ma can cap nhat: ");
        String ma = sc.nextLine();
        for (NhanVien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                System.out.println("Nhap thong tin moi cho nhan vien nay (tru ma nhan vien):");
                try {
                    nv.nhap(sc);
                    System.out.println("Da cap nhat!");
                } catch (Exception e) {
                    System.out.println("Nhap sai dinh dang! Cap nhat that bai.");
                }
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien!");
    }

    public static void timTheoKhoangLuong(ArrayList<NhanVien> list, Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        try {
            System.out.print("Nhap luong toi thieu: ");
            double min = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap luong toi da: ");
            double max = Double.parseDouble(sc.nextLine());

            list.stream()
                .filter(nv -> nv.getLuong() >= min && nv.getLuong() <= max)
                .forEach(NhanVien::xuatThongTin);
        } catch (Exception e) {
            System.out.println("Nhap sai dinh dang luong!");
        }
    }

    public static void sapXepTheoTen(ArrayList<NhanVien> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        list.sort(Comparator.comparing(nv -> nv.getHoTen().toLowerCase()));
        System.out.println("Da sap xep theo ten!");
    }

    public static void sapXepTheoThuNhap(ArrayList<NhanVien> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        list.sort((a, b) -> Double.compare(b.getThuNhap(), a.getThuNhap()));
        System.out.println("Da sap xep theo thu nhap!");
    }

    public static void top5ThuNhap(ArrayList<NhanVien> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        list.stream()
            .sorted((a, b) -> Double.compare(b.getThuNhap(), a.getThuNhap()))
            .limit(5)
            .forEach(NhanVien::xuatThongTin);
    }
}
