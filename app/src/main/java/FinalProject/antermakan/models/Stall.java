package FinalProject.antermakan.models;

public class Stall {
    private String nama;
    private String info;
    private String jenis;

    public Stall(String nama, String info, String jenis) {
        this.nama = nama;
        this.info = info;
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
