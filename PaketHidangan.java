package testsinglethread;

public class PaketHidangan{
    private String nama_paket;
    private String hidangan;
    private int harga;
    
    PaketHidangan(String nama_paket, String hidangan, int harga){
        this.nama_paket = nama_paket;
        this.hidangan = hidangan;
        this.harga = harga;
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
    
    @Override
    public String toString(){
        return nama_paket + " " + hidangan + " " + harga;
    }
}