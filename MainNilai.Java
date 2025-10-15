import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String nim;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;

    public Mahasiswa(String nama, String nim, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.nama = nama;
        this.nim = nim;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    //Hitung rata-rata (dibulatkan agar tidak ada koma)
    double hitungRataRata() {
        double nilaiRata = (nilaiTugas + nilaiUTS + nilaiUAS) / 3;
        return Math.round(nilaiRata); // hasil dinulatkan ke angka terdekat
    }


    public boolean isLulus() {
        return hitungRataRata() >= 75;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}

class Kelas {
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }

    public void tampilkanDaftarMahasiswa() {
        System.out.println("\n=== DAFTAR NILAI MAHASISWA ===");
        for (Mahasiswa m : daftarMahasiswa) {
            System.out.println("Nama: " + m.getNama() + " | NIM: " + m.getNim() +
                    " | Rata-rata: " + m.hitungRataRata() +
                    " | Status: " + (m.isLulus() ? "LULUS" : "TIDAK LULUS"));
        }
    }
}

public class MainNilai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kelas kelas = new Kelas();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("NIM: ");
            String nim = sc.nextLine();
            System.out.print("Nilai Tugas: ");
            double tugas = sc.nextDouble();
            System.out.print("Nilai UTS: ");
            double uts = sc.nextDouble();
            System.out.print("Nilai UAS: ");
            double uas = sc.nextDouble();
            sc.nextLine();


            Mahasiswa m = new Mahasiswa(nama, nim, tugas, uts, uas);
            kelas.tambahMahasiswa(m);
        }

        kelas.tampilkanDaftarMahasiswa();
    }
}
