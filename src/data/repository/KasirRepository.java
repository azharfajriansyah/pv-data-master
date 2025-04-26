/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.repository;

import data.model.Kasir;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Azhar
 */
public class KasirRepository extends Repository<Kasir> {

    @Override
    public ArrayList<Kasir> populate(String searchText) {
        String query = "SELECT * FROM kasir WHERE nama LIKE '%" + searchText + "%' ORDER BY nama";
        ArrayList<Kasir> listKasir = new ArrayList<Kasir>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Processing the result set
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nama = resultSet.getString("nama");
                String jenis = resultSet.getString("jenis_kelamin");
                String telepon = resultSet.getString("no_telepon");
                String agama = resultSet.getString("agama");
                String alamat = resultSet.getString("alamat");
                String password = resultSet.getString("password");
                
                listKasir.add(new Kasir(id, nama, jenis, telepon, agama, alamat, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKasir;
    }

    @Override
    public void save(Kasir object) throws Exception {
        String query = String.format("""
                                     INSERT INTO kasir (id, nama, jenis_kelamin, no_telepon, agama, alamat, password)
                                     VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')
                                     """, object.id, object.nama, object.jenisKelamin, object.noTelepon, object.agama, object.alamat, object.password);
        executeUpdateQuery(query);
    }

    @Override
    public void update(Kasir object) throws Exception {
        String query = String.format("""
                                     UPDATE kasir SET id='%s', nama='%s', jenis_kelamin='%s', no_telepon='%s', agama='%s', alamat='%s', password='%s'
                                     WHERE id='%s'
                                     """, object.id, object.nama, object.jenisKelamin, object.noTelepon, object.agama, object.alamat, object.password, object.id);
                
        executeUpdateQuery(query);
    }

    @Override
    public void delete(String id) throws Exception {
        String query = "DELETE FROM kasir WHERE id = '" +id+ "'";
        executeUpdateQuery(query);
    }
    
}
