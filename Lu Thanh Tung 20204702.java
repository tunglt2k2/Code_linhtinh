class CongTy {
    private String tenCongTy;
    private int soNhanVien;
    public static final int SO_NV_MAX = 500;
    public static double loiNhuan;
    private NhanVien[] dsnv;
    public boolean themNV(NhanVien nv) {
        if (soNhanVien<SO_NV_MAX) {
            dsnv[soNhanVien] = nv;
            soNhanVien++;
            return true;
        }
        else {
            System.out.println("Khong hop le!");
            return false;
        }
    }
    public void inThongTin(){
        System.out.println(tenCongTy);
        for (NhanVien nv: dsnv) {
            nv.inThongTin();
        }
    }
    public double tinhTongLuong() {
        double sum=0;
        for (NhanVien nv:dsnv) {
            sum+= nv.tinhLuong();
        }
        return sum;
    }
}

abstract class NhanVien {
    private  String tenNhanVien;
    abstract double tinhLuong();
    abstract void inThongTin();

    public String getTenNhanVien() {
        return tenNhanVien;
    }
}

class CanBoCoHuu extends NhanVien {
    private static final int LUONG_MAX = 10000000;
    private static double luongCoban;

    private double heSoLuong;
    public double tinhLuong(){ return luongCoban*heSoLuong;}
    public boolean tangHeSoLuong(double v) {
        if (luongCoban*heSoLuong + v> LUONG_MAX) {
            System.out.println("Khong hop le!");
            return false;
        }
        else {
            heSoLuong += v;
            return true;
        }
    }
    public void inThongTin() {
        System.out.println(this.getTenNhanVien());
        System.out.println(this.tinhLuong());
    }
}

class CanBoHopDong extends NhanVien {
    private double luongHopDong;
    public double tinhLuong() {return luongHopDong;}
    public void inThongTin() {
        System.out.println(this.getTenNhanVien());
        System.out.println(this.tinhLuong());
    }
}

class GiamDoc extends CanBoCoHuu implements QuanLy{
    private double phuCap;
    public double tinhLuong() {return super.tinhLuong()+phuCap+this.tinhHoaHong();}
    public double tinhHoaHong() { return 0.05*CongTy.loiNhuan;}
    public void inThongTin() {
        super.inThongTin();
        System.out.println(this.tinhHoaHong());
        System.out.println(phuCap);
    }

}

class CanBoQuanLy extends CanBoCoHuu implements QuanLy{
    public double tinhLuong() {return super.tinhLuong()+this.tinhHoaHong();}
    public double tinhHoaHong() {return 0.002*CongTy.loiNhuan;}
    public void inThongTin() {
        super.inThongTin();
        System.out.println(this.tinhHoaHong());
    }

}

class TruongPhong extends CanBoCoHuu {
    private double phuCap;
    public double tinhLuong() {return super.tinhLuong()+phuCap;}
    public void inThongTin() {
        super.inThongTin();
        System.out.println(phuCap);
    }
}

interface QuanLy  {
    double tinhHoaHong();
}
