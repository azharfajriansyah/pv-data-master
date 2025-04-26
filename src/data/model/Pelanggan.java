/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

/**
 *
 * @author Azhar
 */
public class Pelanggan {
    public String id;
    public String nama;
    public String jenisKelamin;
    public String noTelepon;
    public String alamat;
    
    public Pelanggan(String id, String nama, String jenisKelamin, String noTelepon, String alamat) {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }
}
