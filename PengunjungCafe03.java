public class PengunjungCafe03 {

    static void daftarPengunjung(String... namaPengunjung) {                            // Langkah 2: fungsi varargs (versi for-each, jawaban pertanyaan 2a)
        System.out.println("Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {             // Pertanyaan 3: fungsi dengan nomor meja,           
        System.out.println("Meja nomor " + nomorMeja);
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static int hitungTotalBelanja(int... harga) {                                      // Pertanyaan 4: menjumlahkan semua harga
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung("Ali", "Budi", "Citra");                   // Langkah 3 dan 5: pemanggilan dengan jumlah argumen yang beda
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");

        daftarPengunjung();                                                           // Pertanyaan 1:  tanpa argumen 

        String[] tamu = {"Ali", "Budi", "Citra"};                                     // Pertanyaan 2b: dikirim melalui array
        daftarPengunjung(tamu);

        daftarPengunjung(5, "Ali", "Budi");             // Pertanyaan 3: dengan nomor meja

        System.out.println("Total 1 argumen : " + hitungTotalBelanja(15000));                               // pertanyaan4: 1.3. dan 5 argumen
        System.out.println("Total 3 argumen : " + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("Total 5 argumen : " + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}