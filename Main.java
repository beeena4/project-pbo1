import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // membuat ArrayList untuk menyimpan objek bunga
        ArrayList<Flower> listFlowers = new ArrayList<>();

        // menambahkan objek bunga ke dalam ArrayList
        listFlowers.add(new Flower("CallaLily", 10000, "freshflower"));
        listFlowers.add(new Flower("RedRose", 5000, "freshflower"));
        listFlowers.add(new Flower("SunFlower", 15000, "freshflower"));
       

         // menampilkan daftar bunga 
         System.out.println("\n---------------------------------------");
         System.out.println("        INFORMASII DAFTAR BUNGA        ");
         System.out.println("---------------------------------------");
         System.out.printf("%-20s | %10s%n", "Nama Bunga", "Harga");
         System.out.println("---------------------------------------");
         for (Flower m : listFlowers) {
            System.out.printf("%-20s | Rp %,10.2f%n", m.getNama(), m.getHarga());
         }
 
         // sorting berdasarkan harga menggunakan Comparator
         listFlowers.sort(Comparator.comparingDouble(Flower::getHarga));
 
         // menampilkan daftar bunga setelah sorting
         System.out.println("\nDaftar Bunga Menurut Harga Terendah:");
         System.out.println("---------------------------------------");
         System.out.printf("%-20s | %10s%n", "Nama Bunga", "Harga");
         System.out.println("---------------------------------------");
         for (Flower m : listFlowers) {
            System.out.printf("%-20s | Rp %,10.2f%n", m.getNama(), m.getHarga());
         }

         // Pencarian bunga berdasarkan nama
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

        // menampilkan informasi 
        for (Flower list : listFlowers) {
            list.tampilkanInfoDanHargaDiskon(10);
         
        }

        }
    
    }


