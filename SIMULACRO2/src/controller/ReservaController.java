package controller;

import Utils.Utils;
import entity.*;
import javax.swing.*;
import static Utils.Utils.*;

public class ReservaController {

    public static void create(){

        Object[] opcionP = Utils.fromListToArray(instanceOfModelPasajero().findAll());
        Object[] opcionV = Utils.fromListToArray(instanceOfModelVuelo().findAll());

        try {

            Pasajero pasajero = (Pasajero) JOptionPane.showInputDialog(null,
                    "Selecciona el id del pasajero: ",
                    "",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionP,
                    opcionP[0]);

            Vuelo vuelo = (Vuelo) JOptionPane.showInputDialog(null,
                    "Selecciona el id del vuelo",
                    "",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionV,
                    opcionV[0]);

            String fecha_reserva = JOptionPane.showInputDialog("Ingresa fecha de resesrva en este formato YYYY-MM-DD");
            String asiento = JOptionPane.showInputDialog("Ingresa el asiento a asignar");
            if (!instanceOfModelReserva().findByAsiento(asiento)){
                if (instanceOfModelReserva().findAll().size() < instanceOfModelAvion().findById(vuelo.getFk_id_avion()).getCapacidad()){
                    Reserva objReserva = new Reserva();
                    objReserva.setFk_id_pasajero(pasajero.getId_pasajero());
                    objReserva.setFk_id_vuelo(vuelo.getId_vuelo());
                    objReserva.setFecha_reserva(fecha_reserva);
                    objReserva.setAsiento(asiento);
                    objReserva.setPasajero(pasajero);
                    objReserva.setVuelo(vuelo);

                    instanceOfModelReserva().insert(objReserva);
                    JOptionPane.showMessageDialog(null,objReserva.toString());
                } else {
                    JOptionPane.showMessageDialog(null,"Ya no hay reservas disponibles para este vuelo, Gracias por tu comprensión!");
                }
            } else {
                JOptionPane.showMessageDialog(null,"El asiento ya ha sido asignado intenta de nuevo");
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingresa un carácter numerico" + e.getMessage());
        }
    }

    public static void getAll(){
        String listaReservas = "BOOK LIST\n";
        for (Object iterator: instanceOfModelReserva().findAll()){
            Reserva objReserva = (Reserva) iterator;
            listaReservas += objReserva.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaReservas);
    }

    public static String getAllString(){
        String listaReservas = "BOOK LIST\n";
        for (Object iterator: instanceOfModelReserva().findAll()){
            Reserva objReserva = (Reserva) iterator;
            listaReservas += objReserva.toString() + "\n";
        }
        return listaReservas;
    }

    public static void delete(){
        Object[] Reservas = Utils.fromListToArray(instanceOfModelReserva().findAll());
        int isDeleted;
        Reserva objReserva = (Reserva) JOptionPane.showInputDialog(null,
                "Selecciona la reserva a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Reservas,
                Reservas[0]);

        isDeleted = JOptionPane.showConfirmDialog(null,"Are you sure of the delete?\n" + objReserva.toString());
        if (isDeleted == 0){
            instanceOfModelReserva().delete(objReserva);
        }
    }

    public static void update(){
        Object[] Reservas = Utils.fromListToArray(instanceOfModelReserva().findAll());
        Object[] opcionP = Utils.fromListToArray(instanceOfModelPasajero().findAll());
        Object[] opcionV = Utils.fromListToArray(instanceOfModelVuelo().findAll());
        try {

            Reserva objReserva = (Reserva) JOptionPane.showInputDialog(null,
                    "Selecciona la reserva a actualizar: ",
                    "",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Reservas,
                    Reservas[0]);

            objReserva = instanceOfModelReserva().findById(objReserva.getId_reserva());

            if (objReserva == null){
                JOptionPane.showMessageDialog(null, "Book not found");
            }else {
                Pasajero pasajero = (Pasajero) JOptionPane.showInputDialog(null,
                        "Selecciona el pasajero: ",
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionP,
                        objReserva.getPasajero());

                Vuelo vuelo = (Vuelo) JOptionPane.showInputDialog(null,
                        "Selecciona el id del vuelo",
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionV,
                        objReserva.getVuelo());

                String fecha_reserva = JOptionPane.showInputDialog(null,"Ingresa fecha de resesrva en este formato YYYY-MM-DD",objReserva.getFecha_reserva());
                String asiento = JOptionPane.showInputDialog(null,"Ingresa el asiento a asignar",objReserva.getAsiento());

                objReserva.setFk_id_pasajero(pasajero.getId_pasajero());
                objReserva.setFk_id_vuelo(vuelo.getId_vuelo());
                objReserva.setFecha_reserva(fecha_reserva);
                objReserva.setAsiento(asiento);
                objReserva.setPasajero(pasajero);
                objReserva.setVuelo(vuelo);
                instanceOfModelReserva().update(objReserva);
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingresa un carácter numerico" + e.getMessage());
        }

    }

}
