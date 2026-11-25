import java.util.Scanner;

public class BankSampah03 {

    static Scanner sc = new Scanner(System.in);

    static double[] inputSetoran(int n) {                                               // Membaca setoran, yang hasilnya berupa array
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Setoran nasabah " + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {                                       // Menampilkan semua setoram
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah " + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {                                      // Menjumlahkan semua setoran
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total = total + setoran[i];
        }
        return total;
    }

    static double hitungSaldo(double berat, double harga) {                             // Menghitung saldo (berat x harga per kg)
        return berat * harga;
    }

    static int nasabahTerbanyak(double[] setoran) {                                    // Cari nomor urut (indeks) terbesar
        int terbesar = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[terbesar]) {
                terbesar = i;
            }
        }
        return terbesar;
    }

    public static void main(String[] args) {
        System.out.print("Jumlah nasabah: ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(n);

        System.out.println("--- Data Setoran ---");
        tampilSetoran(setoran);

        System.out.println("Total setoran: " + totalSetoran(setoran) + " kg");

        System.out.println("--- Saldo (Rp3.000 per kg) ---");
        for (int i = 0; i < n; i++) {
            double saldo = hitungSaldo(setoran[i], 3000);
            System.out.println("Nasabah " + (i + 1) + ": Rp" + saldo);
        }

        int terbesar = nasabahTerbanyak(setoran);
        System.out.println("\nSetoran terbanyak: Nasabah " + (terbesar + 1)
                + " (" + setoran[terbesar] + " kg)");
    }
}