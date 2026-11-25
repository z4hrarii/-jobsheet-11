import java.util.Scanner;

public class TabungKerucut03 {
    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    static double luasPermukaanTabung(double r, double t) {
        return 2 * Math.PI * r * (r + t);
    }

    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Luas lingkaran");
            System.out.println("2. Volume tabung");
            System.out.println("3. Luas permukaan tabung");
            System.out.println("4. Volume kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Jari-jari: ");
                double r = sc.nextDouble();
                double t = 0;
                if (pilihan != 1) {
                    System.out.print("Tinggi: ");
                    t = sc.nextDouble();
                }

                if (pilihan == 1) {
                    System.out.println("Luas lingkaran = " + luasLingkaran(r));
                } else if (pilihan == 2) {
                    System.out.println("Volume tabung = " + volumeTabung(r, t));
                } else if (pilihan == 3) {
                    System.out.println("Luas permukaan tabung = " + luasPermukaanTabung(r, t));
                } else {
                    System.out.println("Volume kerucut = " + volumeKerucut(r, t));
                }
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);

        System.out.println("Program selesai.");
    }
}