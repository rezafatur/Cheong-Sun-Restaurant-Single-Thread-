package testsinglethread;

public class Keranjang{
    private String nama_paket;
    private String hidangan;
    private int banyak;
    private int harga;
    
    Keranjang(String nama_paket, String hidangan, int harga, int banyak){
        this.nama_paket = nama_paket;
        this.hidangan = hidangan;
        this.harga = harga;
        this.banyak = banyak;
    }
    
    public String getNamaPaket(){
        return nama_paket;
    }
    public String getHidangan(){
        return hidangan;
    }
    public int getHarga(){
        return harga;
    }
    public int getBanyak(){
        return banyak;
    }
    
    @Override
    public String toString(){
        return nama_paket + " " + hidangan + " " + harga + " " + banyak;
    }
}