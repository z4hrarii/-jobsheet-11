import java.util.Scanner;

public class RekapLaundry03 {

    static Scanner sc = new Scanner(System.in);

    static int jmlLayanan;      
    static int jmlHari;         
    static String[] layanan;    
    static int[] harga;        

    static int[][] inputData() {                                                        // 1. Input data berat cucian
        int[][] data = new int[jmlLayanan][jmlHari];
        for (int i = 0; i < jmlLayanan; i++) {
            for (int j = 0; j < jmlHari; j++) {
                System.out.print(layanan[i] + " hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
        return data;
    }

    static void tampilTabel(int[][] data) {                                      // 2. Tampilkan tabel
        System.out.print("Layanan\t\t");
        for (int j = 0; j < jmlHari; j++) {
            System.out.print("Hari ke-" + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.print(layanan[i] + "\t");
            for (int j = 0; j < jmlHari; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {                      // 3. Total berat satu layanan
        int total = 0;
        for (int j = 0; j < jmlHari; j++) {
            total = total + data[idxLayanan][j];
        }
        return total;
    }

    static void layananTertinggi(int[][] data) {                                     // 4. Layanan dengan total berat tertinggi
        int terbesar = 0;
        for (int i = 1; i < jmlLayanan; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, terbesar)) {
                terbesar = i;
            }
        }
        System.out.println("Layanan tertinggi: " + layanan[terbesar]
                + " (" + totalPerLayanan(data, terbesar) + " kg)");
    }

    static int hariTersibuk(int[][] data) {                              // 5. Hari dengan total berat terbesar (mengembalikan indeks hari)
        int hariTerbesar = 0;
        int totalTerbesar = 0;
        for (int j = 0; j < jmlHari; j++) {
            int totalHari = 0;
            for (int i = 0; i < jmlLayanan; i++) {
                totalHari = totalHari + data[i][j];
            }
            if (totalHari > totalTerbesar) {
                totalTerbesar = totalHari;
                hariTerbesar = j;
            }
        }
        return hariTerbesar;
    }

    static void tampilPendapatan(int[][] data) {                            // 6. Pendapatan tiap layanan dan total pendapatan
        int totalSemua = 0;
        for (int i = 0; i < jmlLayanan; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            System.out.println(layanan[i] + ": Rp" + pendapatan);
            totalSemua = totalSemua + pendapatan;
        }
        System.out.println("Total pendapatan: Rp" + totalSemua);
    }

    public static void main(String[] args) {
        System.out.print("Jumlah layanan: ");                                  // BARU: baca jumlah layanan dan jumlah hari
        jmlLayanan = sc.nextInt();
        System.out.print("Jumlah hari: ");
        jmlHari = sc.nextInt();
        sc.nextLine();                                                        // membuang sisa Enter

        layanan = new String[jmlLayanan];                                     // BARU: ukuran array mengikuti input, lalu baca nama dan harga
        harga = new int[jmlLayanan];
        for (int i = 0; i < jmlLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg: ");
            harga[i] = sc.nextInt();
            sc.nextLine();                                                       // membuang sisa Enter
        }

        int[][] data = inputData();

        System.out.println("=== Tabel Data ===");
        tampilTabel(data);

        System.out.println();
        for (int i = 0; i < jmlLayanan; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        layananTertinggi(data);

        int hari = hariTersibuk(data);
        System.out.println("Hari tersibuk: Hari ke-" + (hari + 1));

        System.out.println("=== Pendapatan ===");
        tampilPendapatan(data);
    }
}   