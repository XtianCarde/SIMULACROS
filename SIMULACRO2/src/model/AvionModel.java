package model;

import database.*;
import entity.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AvionModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Avion objAvion = (Avion) obj;
        try {
            String sql = "INSERT INTO avion (modelo,capacidad) VALUES (?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objAvion.getModelo());
            objPrepare.setInt(2,objAvion.getCapacidad());

            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objAvion.setId_avion(objResult.getInt(1));
            }

        } catch (SQLException e){
            e.getMessage();
        } finally {
            ConfigDb.closeConnection();
        }
        return objAvion;
    }

    @Override
    public List<Object> findAll() {

        Connection objConnection = ConfigDb.openConnection();
        List<Object> listAviones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Avion objAvion = new Avion(objResult.getInt("id_avion"),
                        objResult.getString("modelo"),
                        objResult.getInt("capacidad"));

                listAviones.add(objAvion);
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }

        return listAviones;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Avion objAvion = (Avion) obj;
        boolean idDeleted = false;
        try {
            String sql = "DELETE FROM avion WHERE id_avion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objAvion.getId_avion());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                idDeleted = true;
                JOptionPane.showMessageDialog(null,"Fly delete finished");
            }


        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return idDeleted;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Avion objAvion = (Avion) obj;
        boolean idUpdate = false;
        try {
            String sql = "UPDATE avion SET modelo = ?, capacidad = ? WHERE id_avion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objAvion.getModelo());
            objPrepare.setInt(2,objAvion.getCapacidad());
            objPrepare.setInt(3,objAvion.getId_avion());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                idUpdate = true;
                JOptionPane.showMessageDialog(null,"Fly update finished");
            }


        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return idUpdate;
    }

    public Avion findById(int id){
        Connection objConnection = ConfigDb.openConnection();
        Avion objAvion = null;
        try {
            String sql = "SELECT * FROM avion WHERE id_avion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                objAvion = new Avion(objResult.getInt("id_avion"),
                        objResult.getString("modelo"),
                        objResult.getInt("capacidad"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return objAvion;
    }
}
