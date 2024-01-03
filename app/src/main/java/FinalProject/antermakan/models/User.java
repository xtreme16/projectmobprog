package FinalProject.antermakan.models;

import android.util.Log;

public class User {
    private int id;
    private String nama;
    private String email;
    private String telpon;
    private String alamat;
    private String password;

//    public User() {
//    }

    public User(String nama, String email, String telpon, String alamat, String password) {
//        this.id = id;
        this.nama = nama;
        this.email = email;
        this.telpon = telpon;
        this.alamat = alamat;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void print(){
        Log.d("Qiqi", id + " - " + nama + " - " + email);
    }

}
