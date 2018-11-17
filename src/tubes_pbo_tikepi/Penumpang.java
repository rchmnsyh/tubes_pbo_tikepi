package tubes_pbo_tikepi;

/**
 *
 * @author wira
 */

public class Penumpang extends Manusia {
    private String idPenumpang;
    private String email;
    private Tiket[] detailTiket;
    private int jumTiket;

    public Penumpang(String idPenumpang, String nama, String jenisKelamin, String tglLahir,
            String noHp, String alamat, String email){
        this.idPenumpang = idPenumpang;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tglLahir;
        this.noHp = noHp;
        this.alamat = alamat;
        this.email = email;
    }
    
    Penumpang(String idPenumpang, String nama, String tglLahir, String email){
        this.idPenumpang = idPenumpang;
        this.nama = nama;
        this.tanggalLahir = tglLahir;
        this.email = email;
    }

    public String getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(String idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void pesanKereta(String kodeTiket, String idPenumpang, String kodeJadwal, String tglPesanan, String idKursi, String idKereta, String harga){
        if (jumTiket > 0){
            System.out.println("Sorry, 1 ticket for one person only");
        } else {
            detailTiket[jumTiket++] = new Tiket(kodeTiket, idPenumpang, kodeJadwal, tglPesanan, idKursi, idKereta, harga);
        }
    }
    
    public void infoTiket(Tiket tik){
        System.out.println("Kode tiket   : " + tik.getKodeTiket());
        System.out.println("ID Penumpang : " + tik.getIdPenumpang());
        System.out.println("Kode jadwal  : " + tik.getKodeJadwal());
        System.out.println("Kode kereta         : " + tik.getIdKereta());
        System.out.println("");
        System.out.println("Tanggal pesan tiket : " + tik.getTglPesanan());
        System.out.println("Nomor kursi         : " + tik.getIdKursi());
        System.out.println("Harga tiket         : " + tik.getHarga());
    }

    public int getJumTiket() {
        return jumTiket;
    }

    public void setJumTiket(int jumTiket) {
        this.jumTiket = jumTiket;
    }
    
}