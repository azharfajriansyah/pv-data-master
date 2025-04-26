/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.repository;

import data.model.Barang;
import static data.repository.Repository.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Azhar
 */
public class BarangRepository extends Repository<Barang> {

    @Override
    public ArrayList<Barang> populate(String searchText) {
        String query = "SELECT * FROM barang WHERE nama LIKE '%" + searchText + "%' ORDER BY nama";
        System.out.println(query);
        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Processing the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String kode = resultSet.getString("kode");
                String nama = resultSet.getString("nama");
                String jenis = resultSet.getString("jenis");
                int hargaBeli = resultSet.getInt("harga_beli");
                int hargaJual = resultSet.getInt("harga_jual");
                
                
                listBarang.add(new Barang(id, kode, nama, jenis, hargaBeli, hargaJual));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBarang;
    }

    @Override
    public void save(Barang object) throws Exception {
        String query = String.format("""
                                     INSERT INTO barang (kode, nama, jenis, harga_beli, harga_jual) VALUES ('%s', '%s', '%s', %d, %d)
                                     """, object.kode, object.nama, object.jenis, object.hargaBeli, object.hargaJual);
        executeUpdateQuery(query);
    }

    @Override
    public void update(Barang object) throws Exception {
        String query = String.format("""
                                     UPDATE barang SET kode='%s', nama='%s', jenis='%s', harga_beli=%d, harga_jual=%d WHERE id=%d
                                     """, object.kode, object.nama, object.jenis, object.hargaBeli, object.hargaJual, object.id);
        executeUpdateQuery(query);
    }

    @Override
    public void delete(String id) throws Exception {
        String query = "DELETE FROM barang WHERE id = " +id+ "";
        executeUpdateQuery(query);
    }
    
}
