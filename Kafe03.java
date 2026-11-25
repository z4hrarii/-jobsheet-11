import java.util.Scanner;

public class Kafe03 {
    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga03(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon03(int total, String kodePromo, boolean isMember) {
        int persen = 0;

        if (kodePromo.equals("DISKON50")) {                                               // pertanyaan 4a percobaan 3
            persen = 50;
        } else if (kodePromo.equals("DISKON30")) {
            persen = 30;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {                                                                   // pertanyaan 4b percobaan 3
            persen += 10;
        }
        return total * persen / 100;
    }                                                                                    // fungsi berakhir di sini, hanya berisi return

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu("Andi", true, 15);

        int totalBayar = 0;
        String lain;

        do {
            System.out.print("Masukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
            } else {
                System.out.print("Masukkan jumlah item yang ingin dipesan: ");
                int banyakItem = sc.nextInt();

                totalBayar += hitungTotalHarga03(pilihanMenu, banyakItem);
            }

            System.out.print("Pesan menu lain? (y/n): ");
            lain = sc.next();

        } while (lain.equalsIgnoreCase("y"));

        System.out.println("Total keseluruhan pesanan: Rp" + totalBayar);

                                                                                      // ===== Blok promo, dipindahkan ke main =====
        System.out.print("Masukkan kode promo: ");
        String kodePromo = sc.next();

        int diskon = hitungDiskon03(totalBayar, kodePromo, true);

        System.out.println("Total harga : Rp" + totalBayar);
        System.out.println("Diskon      : Rp" + diskon);
        System.out.println("Total bayar : Rp" + (totalBayar - diskon));
    }
}