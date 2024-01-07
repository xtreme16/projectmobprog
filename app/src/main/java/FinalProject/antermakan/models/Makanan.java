package FinalProject.antermakan.models;

import android.widget.ImageView;

public class Makanan {
    private String nama;
    private String info;

    public Makanan(String nama, String info) {
        this.nama = nama;
        this.info = info;
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
}
