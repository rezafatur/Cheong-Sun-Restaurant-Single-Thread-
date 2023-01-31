package testsinglethread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistem{
    Scanner input = new Scanner(System.in);
    Scanner input_string = new Scanner(System.in);
    Tampilan tampilan = new Tampilan();
    List<PaketHidangan> paket_hidangan = new ArrayList<>();
    List<Keranjang> keranjang = new ArrayList<>();
    int size_paket_hidangan = paket_hidangan.size();
    int size_keranjang = keranjang.size();
    
    
    
    void pesanPaketHidangan(){
        paket_hidangan.add(new PaketHidangan("Paket A", "Hotdog, Kentang Goreng, Minuman", 30000));
        paket_hidangan.add(new PaketHidangan("Paket B", "Hamburger, Kentang Goreng, Minuman", 40000));
        paket_hidangan.add(new PaketHidangan("Paket C", "Fried Chicken, Kentang Goreng, Minuman", 50000));
        
        System.out.println("=============================================================================================");
        System.out.println("| " + String.format("%-4s", "NO") + " | " + String.format("%-11s", "JENIS PAKET") 
            + " | " + String.format("%-50s", "HIDANGAN") + " | " + String.format("%-15s", "Harga") + " |");
        System.out.println("=============================================================================================");
        
        size_paket_hidangan = paket_hidangan.size();
        for(int i = 0; i < size_paket_hidangan; i++){
            System.out.println("| " + String.format("%-4s", (i+1) + ". ") + " | " + String.format("%-11s", paket_hidangan.get(i).getNamaPaket()) 
                + " | " + String.format("%-50s", paket_hidangan.get(i).getHidangan()) + " | Rp." + String.format("%-12d", paket_hidangan.get(i).getHarga()) + " |");
        }
        System.out.println("=============================================================================================\n");
        tambahKeranjang();
        paket_hidangan.removeAll(paket_hidangan);
    }
    
    void tambahKeranjang(){
        int pilihanMenu, banyakPaket;
        
        do{
            tampilan.MenuPesan();
            System.out.print("Masukkan Pilihan Anda : ");
            pilihanMenu = input.nextInt();
            
            switch(pilihanMenu){
                case 1: // Paket A
                    System.out.print("Banyak Pesanan Anda   : ");
                    banyakPaket = input.nextInt();
                    keranjang.add(new Keranjang("Paket A", "Hotdog, Kentang Goreng, Minuman", 30000, banyakPaket));
                    break;
                case 2: // Paket B
                    System.out.print("Banyak Pesanan Anda   : ");
                    banyakPaket = input.nextInt();
                    keranjang.add(new Keranjang("Paket B", "Hamburger, Kentang Goreng, Minuman", 40000, banyakPaket));
                    break;
                case 3: // Paket C
                    System.out.print("Banyak Pesanan Anda   : ");
                    banyakPaket = input.nextInt();
                    keranjang.add(new Keranjang("Paket C", "Fried Chicken, Kentang Goreng, Minuman", 50000, banyakPaket));
                    break;
                case 4: // Kembali
                    System.out.println("\nKembali ke Menu Awal");
                    System.out.println("=============================");
                    break;
                default:
                    System.out.println("\nPilihan menu tidak tersedia :(");
            }
            System.out.print("\n");
        }while(pilihanMenu != 4);
    }
    
    void keranjang(){
        abstract class pembayaran{
            final float pajak = 0.1f;
            abstract float getTotal();
        }
        
        class perhitungan extends pembayaran{
            float total;
            
            public perhitungan(float total){
                this.total = total;
            }
            
            @Override
            float getTotal(){
                float total_keseluruhan = total + (total * pajak);
                return total_keseluruhan;
            }
        }
        
        size_keranjang = keranjang.size();
        if(size_keranjang == 0){
            System.out.println("=============================================================================================");
            System.out.println("| " + String.format("%-89s", "EMPTY") + " |");
            System.out.println("=============================================================================================\n");
        }
        else{
            float total = 0;
            System.out.println("========================================================================================================");
            System.out.println("| " + String.format("%-4s", "NO") + " | " + String.format("%-11s", "JENIS PAKET") + " | " + String.format("%-50s", "HIDANGAN") 
                + " | " + String.format("%-8s", "BANYAK") + " | " + String.format("%-15s", "Harga") + " |");
            System.out.println("========================================================================================================");
            for(int i = 0; i < size_keranjang; i++){
                System.out.println("| " + String.format("%-4s", (i+1) + ". ") + " | " + String.format("%-11s", keranjang.get(i).getNamaPaket()) + " | " 
                    + String.format("%-50s", keranjang.get(i).getHidangan()) + " | " + String.format("%-8d", keranjang.get(i).getBanyak()) 
                    + " | Rp." + String.format("%-12d", (keranjang.get(i).getHarga() * keranjang.get(i).getBanyak())) + " |");
                
                total += (keranjang.get(i).getHarga() * keranjang.get(i).getBanyak());
            }
            System.out.println("========================================================================================================");
            perhitungan hitung = new perhitungan(total);
            System.out.println("TOTAL + Pajak 10% = Rp. " + String.format("%.0f", hitung.getTotal()));

            System.out.print("Apakah Anda ingin melakukan pembayaran? [Y/N] ");
            String bayar = input_string.nextLine();
            if("Y".equals(bayar) || "y".equals(bayar)){
                System.out.println("\nPembayaran Berhasil");
                System.out.println("========================================================================================================\n");
                
                // Robot Mulai Menyiapkan Pesanan (Single Thread)
                Robot robot = new Robot();
                
                int totalPaketPesanan = 0;
                long waktu_mulai = System.currentTimeMillis();
                for(int i = 0; i < size_keranjang; i++){
                    if("Paket A".equals(keranjang.get(i).getNamaPaket())){
                        robot.robotHotdogs();
                        robot.robotFrenchFries();
                        robot.robotMinuman();
                        System.out.println("Menyiapkan Hidangan " + keranjang.get(i).getHidangan());
                        System.out.println("Membuat Hidangan " + keranjang.get(i).getHidangan());
                        System.out.println("Hidangan " + keranjang.get(i).getHidangan() + " Selesai Dibuat\n");
                    }
                    else if("Paket B".equals(keranjang.get(i).getNamaPaket())){
                        robot.robotHamburgers();
                        robot.robotFrenchFries();
                        robot.robotMinuman();
                        System.out.println("Menyiapkan Hidangan " + keranjang.get(i).getHidangan());
                        System.out.println("Membuat Hidangan " + keranjang.get(i).getHidangan());
                        System.out.println("Hidangan " + keranjang.get(i).getHidangan() + " Selesai Dibuat\n");
                    }
                    else if("Paket C".equals(keranjang.get(i).getNamaPaket())){
                        robot.robotFriedChicken();
                        robot.robotFrenchFries();
                        robot.robotMinuman();
                        System.out.println("Menyiapkan Hidangan " + keranjang.get(i).getHidangan());
                        System.out.println("Membuat Hidangan " + keranjang.get(i).getHidangan());
                        System.out.println("Hidangan " + keranjang.get(i).getHidangan() + " Selesai Dibuat\n");
                    }
                    totalPaketPesanan += keranjang.get(i).getBanyak();
                }
                long waktu_akhir = System.currentTimeMillis();
                System.out.println("Waktu Memasak: " + ((waktu_akhir - waktu_mulai) * totalPaketPesanan) + " menit"); // Misal estimasi dalam menit
                System.out.println("========================================================================================================\n");
                keranjang.removeAll(keranjang);
            }
            else{
                System.out.println("\nPembayaran Dibatalkan");
                System.out.println("========================================================================================================\n");
            }
        }
    }
}