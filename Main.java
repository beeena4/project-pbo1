import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static ArrayList<Flower> listFlowers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            displayJudul(scanner);

            // membuat ArrayList untuk menyimpan objek bunga

            // menambahkan objek bunga ke dalam ArrayList
            listFlowers.add(new Flower("CallaLily", 10000, "freshflower"));
            listFlowers.add(new Flower("RedRose", 5000, "freshflower"));
            listFlowers.add(new Flower("SunFlower", 10000, "freshflower"));
            listFlowers.add(new Flower("Orchid", 15000, "freshflower"));
            listFlowers.add(new Flower("Aster", 5000, "freshflower"));
            listFlowers.add(new Flower("Lily", 20000, "freshflower"));

            while (true) {
                // menampilkan menu utama
                displayMenu();
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        // menampilkan daftar bunga
                        displayDaftarBunga();
                        break;

                    case 2:
                        // sorting berdasarkan harga menggunakan Comparator
                        displayDaftarBerdasarHarga();
                        break;

                    case 3:
                        // menu pencarian bunga berdasarkan nama
                        displayCariBungaBerdasarNama(scanner);
                        break;

                    case 4:
                        // proses pemesanan bunga
                        displayProsesPesanBungan(scanner);
                        break;

                    case 5:
                        // keluar dari program
                        displayFooter(scanner);

                    default:
                        System.out.println("Pilihan tidak valid, silakan coba lagi.");

                }
            }
        }
    }

    public static void displayJudul(Scanner scanner) {
        System.out.println("\n=======================================");
        System.out.println(">>            BEE FLORIST            <<");
        System.out.println("=======================================");

        // Input nama pembeli
        System.out.print("Nama : ");
        String namaPembeli = scanner.nextLine();
        System.out.println("\nSelamat datang di BEE FLORIST," + namaPembeli + "!");
        System.out.println("Kami memiliki berbagai pilihan bunga");
        System.out.println("untuk setiap moment spesial ;)");
    }

    public static void displayMenu() {
        System.out.println("\n=======================================");
        System.out.println(">>              M E N U              <<");
        System.out.println("=======================================");
        System.out.println("1. Tampilkan Daftar Bunga");
        System.out.println("2. Tampilkan Bunga Berdasarkan Harga");
        System.out.println("3. Cari Bunga Berdasarkan Nama");
        System.out.println("4. Pesan Bunga");
        System.out.println("5. Keluar");
        System.out.println("---------------------------------------");
        System.out.print("Pilih menu (1-5): ");
    }

    public static void displayDaftarBunga() {
        System.out.println("\n---------------------------------------");
        System.out.println("        INFORMASII DAFTAR BUNGA        ");
        System.out.println("---------------------------------------");
        System.out.printf("%-20s | %10s%n", "Nama Bunga", "Harga");
        System.out.println("---------------------------------------");
        for (Flower m : listFlowers) {
            System.out.printf("%-20s | Rp %,10.2f%n", m.getNama(), m.getHarga());
        }
    }

    public static void displayDaftarBerdasarHarga() {
        listFlowers.sort(Comparator.comparingDouble(Flower::getHarga));

        // menampilkan daftar bunga setelah sorting
        System.out.println("\nDaftar Bunga Menurut Harga Terendah:");
        System.out.println("---------------------------------------");
        System.out.printf("%-20s | %10s%n", "Nama Bunga", "Harga");
        System.out.println("---------------------------------------");
        for (Flower m : listFlowers) {
            System.out.printf("%-20s | Rp %,10.2f%n", m.getNama(), m.getHarga());
        }
    }

    public static void displayCariBungaBerdasarNama(Scanner scanner) {
        System.out.println("\nMasukkan nama bunga yang ingin dicari: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Flower m : listFlowers) {
            if (m.getNama().equalsIgnoreCase(searchName)) {
                System.out.println("\nBunga ditemukan:");
                System.out.println("---------------------------------------");
                System.out.printf("Nama  : %s%n", m.getNama());
                System.out.printf("Harga : Rp %,10.2f%n", m.getHarga());
                System.out.println("---------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\n---------------------------------------");
            System.out.println("[ERROR] | Bunga tidak ditemukan!!.");
            System.out.println("---------------------------------------");
        }
    }

    public static void displayProsesPesanBungan(Scanner scanner) {
        boolean beliLagi;
        do {
            System.out.print("\nMasukkan nama bunga   : ");
            String orderName = scanner.nextLine();
            System.out.print("Masukkan jumlah bunga : ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            boolean ordered = false;
            for (Flower m : listFlowers) {
                if (m.getNama().equalsIgnoreCase(orderName)) {
                    double totalHarga = m.getHarga() * jumlah;
                    double diskon = 0;

                    // menentukan diskon berdasarkan jumlah pembelian
                    if (jumlah > 10) {
                        diskon = 0.20 * totalHarga; // Diskon 20% apabila membeli lebih dari 10
                    } else if (jumlah > 5) {
                        diskon = 0.10 * totalHarga; // Diskon 10% apabila membeli lebih dari 5
                    }
                    double totalPembayaran = totalHarga - diskon;

                    // menampilkan informasi pesanan
                    System.out.println("\nPesanan berhasil!");
                    System.out.println("=======================================");
                    System.out.println(">>         INFORMASI  PESANAN        <<");
                    System.out.println("=======================================");
                    System.out.printf("Nama                  : %s%n", m.getNama());
                    System.out.printf("Jumlah                : %d%n", jumlah);
                    System.out.printf("Total Harga           : Rp %,10.2f%n", totalHarga);
                    System.out.printf("Diskon                : Rp %,10.2f%n", diskon);
                    System.out.printf("Total Pembayaran      : Rp %,10.2f%n", totalPembayaran);
                    System.out.println("---------------------------------------");

                    // Memasukkan pembayaran dari pelanggan
                    double pembayaran;
                    while (true) {
                        System.out.print("TUNAI                 : Rp ");
                        pembayaran = scanner.nextDouble();
                        scanner.nextLine();

                        if (pembayaran >= totalPembayaran) {
                            break;
                        } else {
                            double kekurangan = pembayaran - totalPembayaran;
                            System.out.println("---------------------------------------");
                            System.out.println("\n[ERROR] | Uang tidak cukup!!. ");
                            System.out.printf("KEKURANGAN            : Rp %,10.2f%n", kekurangan);
                            System.out.println("\n---------------------------------------");

                        }
                    }
                    // Menghitung jumlah kembalian
                    double kembalian = pembayaran - totalPembayaran;
                    System.out.printf("KEMBALIAN             : Rp %,10.2f%n", kembalian);
                    System.out.println("---------------------------------------");

                    ordered = true;
                }
            }

            if (!ordered) {
                System.out.println("\n---------------------------------------");
                System.out.println("[ERROR] | Bunga tidak ditemukan!!.");
                System.out.println("---------------------------------------");
            }

            // konfirmasi apakah pengguna ingin beli lagi
            System.out.print("\nApakah ingin membeli lagi? (Y/N): ");
            String pilihanLagi;
            while (true) {
                pilihanLagi = scanner.nextLine().trim().toUpperCase();
                if (pilihanLagi.equals("Y") || pilihanLagi.equals("N")) {
                    break;
                } else {
                    System.out.print("Input tidak valid! Masukkan Y atau N: ");
                }
            }
            beliLagi = pilihanLagi.equals("Y");
        } while (beliLagi);

        System.out.println("Terima kasih telah berbelanja di");
        System.out.println("BEE FLORIST !!");

        System.out.println("\n---------------------------------------");
        System.out.println(">>         by : FEBRIANA_OO6         <<");
        System.out.println("---------------------------------------");
        System.out.println("Terima kasih telah berkunjung!.");
        System.out.println("\n---------------------------------------");
        System.out.println(">>         by : FEBRIANA_OO6         <<");
        System.out.println("---------------------------------------");
    }

    public static void displayFooter(Scanner scanner) {
        System.out.println("Terima kasih telah berkunjung!.");
        System.out.println("\n---------------------------------------");
        System.out.println(">>         by : FEBRIANA_OO6         <<");
        System.out.println("---------------------------------------");
        scanner.close();
    }

}
