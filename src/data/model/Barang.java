/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

/**
 *
 * @author Azhar
 */
public class Barang {
    public int id;
    public String kode;
    public String nama;
    public String jenis;
    public int hargaBeli;
    public int hargaJual;
    
    public Barang(int id, String kode, String nama, String jenis, int hargaBeli, int hargaJual) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.jenis = jenis;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
    }
}
