package tubes_pbo_tikepi;

/**
 *
 * @author wira
 */

public class Petugas extends Manusia {
    private String idPetugas;
    
    public Petugas(String idPetugas, String nama, String jenisKelamin, String tglLahir,
            String noHp, String alamat){
        this.idPetugas = idPetugas;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tglLahir;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    Petugas(String idPetugas, String nama, String tglLahir){
        this.idPetugas = idPetugas;
        this.nama = nama;
        this.tanggalLahir = tglLahir;
    }
    
    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }
    
    public void verifikasi(Tiket tik, String idPenumpang){
        if (tik.getIdPenumpang() == idPenumpang){
            System.out.println("Terverifikasi");
        }else{
            System.out.println("ID Tidak sesuai, harap cek kembali");
        }
    }
}
