package testsinglethread;

import java.util.Scanner;

public class TestSingleThread{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner input_string = new Scanner(System.in);
        Tampilan tampilan = new Tampilan();
        Sistem sistem = new Sistem();
        int pilihan;
        
        do{
            tampilan.CheongSunRestaurantMenu();
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            
            System.out.print("\n");
            switch(pilihan){
                case 1: // Pesan
                    sistem.pesanPaketHidangan();
                    break;
                case 2: // Keranjang
                    sistem.keranjang();
                    break;
                case 3: // Keluar Program
                    System.out.println("Thank You :)");
                    System.out.println("=============================\n");
                    break;
                default:
                    System.out.println("Pilihan menu tidak tersedia :(\n");
            }
        }while(pilihan != 3);
    }
}