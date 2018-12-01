package Model;

/**
 *
 * @author wira
 */

public class Petugas extends Manusia {
    private String idPetugas;
    private String password;
    private String email;
    
    public Petugas(String idPetugas, String nama, String jenisKelamin, String tglLahir,
            String noHp, String email, String alamat, String password){
        this.idPetugas = idPetugas;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tglLahir;
        this.noHp = noHp;
        this.email = email;
        this.alamat = alamat;
        this.password = password;
    }
    
    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
