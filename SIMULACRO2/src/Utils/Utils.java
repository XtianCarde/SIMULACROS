package Utils;

import model.AvionModel;
import model.PasajeroModel;
import model.ReservaModel;
import model.VueloModel;

import java.util.List;

public class Utils {

    public static <T> T[] fromListToArray(List<T> list){
        T[] array =(T[]) new Object[list.size()];
        int i = 0;
        for (T iterator: list){
            array[i++] = iterator;
        }
        return array;
    }

    public static ReservaModel instanceOfModelReserva (){
        ReservaModel objReserva = new ReservaModel();
        return objReserva;
    }

    public static PasajeroModel instanceOfModelPasajero (){
        PasajeroModel objPasajeroModel = new PasajeroModel();
        return objPasajeroModel;
    }

    public static VueloModel instanceOfModelVuelo (){
        VueloModel objVueloModel = new VueloModel();
        return objVueloModel;
    }

    public static AvionModel instanceOfModelAvion (){
        AvionModel objAvionModel = new AvionModel();
        return objAvionModel;
    }
}
