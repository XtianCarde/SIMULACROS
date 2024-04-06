package controller;

import entity.Pasajero;

import javax.swing.*;
import Utils.Utils;
import static Utils.Utils.*;

public class PasajeroController {
    public static void create(){
        String nombre = JOptionPane.showInputDialog(null,"Insert the name");
        String apellido = JOptionPane.showInputDialog(null,"Insert the lastname");
        String doc_ide = JOptionPane.showInputDialog(null,"Insert de ID");

        Pasajero objPasajero = new Pasajero();
        objPasajero.setNombre(nombre);
        objPasajero.setApellido(apellido);
        objPasajero.setDoc_iden(doc_ide);

        instanceOfModelPasajero().insert(objPasajero);
        JOptionPane.showMessageDialog(null,objPasajero.toString());
    }

    public static void getAll(){
        String listPasajero = "LIST PASSENGER\n";
        for (Object iterator:instanceOfModelPasajero().findAll()){
            Pasajero objPasajero = (Pasajero) iterator;
            listPasajero += objPasajero.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listPasajero);
    }

    public static String getAllString(){
        String listPasajero = "LIST PASSENGER\n";
        for (Object iterator:instanceOfModelPasajero().findAll()){
            Pasajero objPasajero = (Pasajero) iterator;
            listPasajero += objPasajero.toString()+ "\n";
        }
        return listPasajero;
    }

    public static void delete(){
        Object[] opcionesP = Utils.fromListToArray(instanceOfModelPasajero().findAll());
        int isDeleted = 1;
        Pasajero objPasajero = (Pasajero) JOptionPane.showInputDialog(null,
                "Select the passenger to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesP,
                opcionesP[0]);

        isDeleted = JOptionPane.showConfirmDialog(null,"Are you sure the delete this passenger?\n" + objPasajero.toString());
        if (isDeleted == 0) {
            instanceOfModelPasajero().delete(objPasajero);
        }
    }

    public static void update(){
        Object[] opcionesP = Utils.fromListToArray(instanceOfModelPasajero().findAll());
        Pasajero objPasajero = (Pasajero) JOptionPane.showInputDialog(null,
                "Select the passenger to update",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesP,
                opcionesP[0]);

        String nombre = JOptionPane.showInputDialog(null,"Insert the name",objPasajero.getNombre());
        String apellido = JOptionPane.showInputDialog(null,"Insert the lastname",objPasajero.getApellido());
        String doc_ide = JOptionPane.showInputDialog(null,"Insert de ID",objPasajero.getDoc_iden());


        objPasajero.setNombre(nombre);
        objPasajero.setApellido(apellido);
        objPasajero.setDoc_iden(doc_ide);

        instanceOfModelPasajero().update(objPasajero);
    }
}
