/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

/**
 *
 * @author Azhar
 */
public class Kasir {
    public String id;
    public String nama;
    public String jenisKelamin;
    public String noTelepon;
    public String agama;
    public String alamat;
    public String password;
    
    public Kasir(String id, String nama, String jenisKelamin, String noTelepon, String agama, String alamat, String password) {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.noTelepon = noTelepon;
        this.agama = agama;
        this.alamat = alamat;
        this.password = password;
    }
}
