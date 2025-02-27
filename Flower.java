import java.util.ArrayList;

class Flower {
    private String nama;
    private double harga;
    private String kategori;
    private double jumlahBunga;
    private double totalHarga;
    protected double diskon;
    protected double hargaDiskon;


    public Flower(String nama, double harga, String kategori){
            this.nama = nama;
            this.harga = harga;
            this.kategori = kategori;
            this.jumlahBunga = jumlahBunga;
            this.totalHarga = totalHarga;
            this.diskon = diskon;
            this.hargaDiskon = hargaDiskon;

    }

    // getter dan setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            System.out.println("[ERROR] Harga yang dimasukkan tidak valid");
        }
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getjumlahBunga() {
        return jumlahBunga;
    }

    public void setjumlahBunga(double jumlahBunga) {
        this.jumlahBunga = jumlahBunga;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    protected double getDiskon() {
        return diskon;
    }

    protected void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    protected double getHargaDiskon() {
        return hargaDiskon;
    }
    
    protected void setHargaDiskon(double hargaDiskon) {
        if (hargaDiskon >= 0 && hargaDiskon <= 1) {
            this.hargaDiskon = hargaDiskon;
        } else {
            System.out.println("[ERROR] Diskon yang dimasukkan tidak valid");
        }
    }

    // metode pertama : menampilkan informasi dan menghitung diskon berdasarkan jumlah order
    void tampilkanInfoDanHargaDiskon(int jumlah) {
        double diskon = hitungDiskon(jumlah); // mendapatkan diskon berdasarkan jumlah
        double hargaDiskon = (this.harga * jumlah) - (this.harga * jumlah * diskon / 100);
    
        System.out.println("\n---------------------------------------");
        System.out.println(">>       INFORMASI DAFTAR BUNGA      <<"); 
        System.out.println("---------------------------------------");
        System.out.println("Nama Bunga           : " + this.nama);
        System.out.println("Harga per tangkai    : Rp " + this.harga);
        System.out.println("Kategori             : " + this.kategori);
        System.out.println("Jumlah yang dipesan  : " + jumlah);
        System.out.println("Total Harga          : Rp " + this.harga * jumlah);
        System.out.println("Diskon               : " + diskon + "%");
        System.out.println("Total Pembayaran     : " + hargaDiskon);
    }
        // metode kedua : menghitung diskon berdasarkan jumlah order
        double hitungDiskon(int jumlah) {
            if (jumlah >= 10) {
                return 20; // diskon 20% jika order 10 atau lebih
            } else if (jumlah >= 5) {
                return 10; // diskon 10% jika order 5 atau lebih
            } else {
                return 0; // tidak ada diskon jika kurang dari 5
            }
        }
    }