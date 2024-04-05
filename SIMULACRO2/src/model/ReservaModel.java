package model;

import database.CRUD;
import database.ConfigDb;
import entity.Avion;
import entity.Pasajero;
import entity.Reserva;
import entity.Vuelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Reserva objReserva = (Reserva) obj;
        try {
            String sql = "INSERT INTO reserva (fk_id_pasajero,fk_id_vuelo,fecha_reserva,asiento) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1,objReserva.getFk_id_pasajero());
            objPrepare.setInt(2,objReserva.getFk_id_vuelo());
            objPrepare.setString(3,objReserva.getFecha_reserva());
            objPrepare.setString(4,objReserva.getAsiento());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult != null){
                objReserva.setId_reserva(objResult.getInt(1));
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return objReserva;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDb.openConnection();
        List<Object> listReservas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM reserva INNER JOIN pasajero ON reserva.fk_id_pasajero = pasajero.id_pasajero " +
                    "INNER JOIN vuelo ON vuelo.id_vuelo = reserva.fk_id_vuelo" +
                    "INNER JOIN avion ON vuelo.fk_id_avion = avion.id_avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Pasajero objPasajero = new Pasajero(objResult.getInt("pasajero.id_pasajero"),
                        objResult.getString("pasajero.nombre"),
                        objResult.getString("pasajero.apellido"),
                        objResult.getString("pasajero.doc_ide"));

                Vuelo objVuelo = new Vuelo(objResult.getInt("vuelo.id_vuelo"),
                        objResult.getString("vuelo.destino"),
                        objResult.getString("vuelo.fecha_salida"),
                        objResult.getString("vuelo.hora_salida"),
                        objResult.getInt("vuelo.fk_id_avion"),
                        new Avion(objResult.getInt("vuelo.fk_id_avion"), objResult.getString("avion.modelo"),objResult.getInt("avion.capacidad")));

                Reserva objReserva = new Reserva(objResult.getInt("reserva.id_reserva"),
                        objResult.getInt("reserva.fk_id_pasajero"),
                        objResult.getInt("reserva.fk_id_vuelo"),
                        objResult.getString("reserva.fecha_reserva"),
                        objResult.getString("reserva.asiento"),
                        objPasajero,
                        objVuelo);

                listReservas.add(objReserva);
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return listReservas;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDb.openConnection();
        Reserva objReserva = (Reserva) obj;
        boolean isDelete = false;

        try {
            String sql = "DELETE FROM reserva WHERE id_reserva = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objReserva.getId_reserva());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"Book delete finished");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isDelete;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }
}
