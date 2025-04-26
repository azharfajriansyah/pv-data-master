/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import data.repository.Repository;
import java.util.ArrayList;

/**
 *
 * @author Azhar
 */
public abstract class BaseForm<T> extends javax.swing.JFrame {
    protected Repository<T> repository;
    protected T dataToEdit;
    protected ArrayList<T> listData;
    
    protected abstract void populateData(String searchQuery);
    protected abstract void save(T object);
    protected abstract void update(T object);
    protected abstract void delete(String id);
    protected abstract void clearForm();
    protected abstract void fillForm(T object);
    protected abstract void removeTableData();
}
