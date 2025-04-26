/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.repository;

import data.model.Pelanggan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Azhar
 */
public class PelangganRepository extends Repository<Pelanggan> {

    @Override
    public ArrayList<Pelanggan> populate(String searchText) {
        String query = "SELECT * FROM pelanggan WHERE nmplg LIKE '%" + searchText + "%' ORDER BY nmplg";
        ArrayList<Pelanggan> pelanggan = new ArrayList<Pelanggan>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Processing the result set
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nama = resultSet.getString("nmplg");
                String jenis = resultSet.getString("jenis");
                String telepon = resultSet.getString("telepon");
                String alamat = resultSet.getString("alamat");
                
                pelanggan.add(new Pelanggan(id, nama, jenis, telepon, alamat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelanggan;
    }

    @Override
    public void save(Pelanggan object) throws Exception {
        String query = String.format("""
                                     INSERT INTO pelanggan (id, nmplg, jenis, telepon, alamat)
                                     VALUES('%s', '%s', '%s', '%s', '%s')
                                     """, object.id, object.nama, object.jenisKelamin, object.noTelepon, object.alamat);
        executeUpdateQuery(query);
    }

    @Override
    public void update(Pelanggan object) throws Exception {
        String query = String.format("""
                                     UPDATE pelanggan SET id='%s', nmplg='%s', jenis='%s', telepon='%s', alamat='%s'
                                     WHERE id='%s'
                                     """, object.id, object.nama, object.jenisKelamin, object.noTelepon, object.alamat, object.id);
        executeUpdateQuery(query);
    }

    @Override
    public void delete(String id) throws Exception {
        String query = "DELETE FROM pelanggan WHERE id = '" +id+ "'";
        executeUpdateQuery(query);
    }
    
}
