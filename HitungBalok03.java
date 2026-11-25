import java.util.Scanner;

public class HitungBalok03 {

    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {                           // baru, memanfaatkan hitungLuas
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p, l, t;

        for (int i = 1; i <= 3; i++) {
            System.out.println("--- Balok ke-" + i + " ---");
            System.out.print("Masukkan panjang: ");
            p = input.nextInt();
            System.out.print("Masukkan lebar: ");
            l = input.nextInt();
            System.out.print("Masukkan tinggi: ");
            t = input.nextInt();

            System.out.println("Luas permukaan balok adalah " + hitungLuasPermukaanBalok(p, l, t));
            System.out.println("Volume balok adalah " + hitungVolume(t, p, l));
            System.out.println();
        }

        input.close();
    }
}