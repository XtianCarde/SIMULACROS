package entity;

public class Reserva {
    private int id_reserva;
    private int fk_id_pasajero;
    private int fk_id_vuelo;
    private String fecha_reserva;
    private String asiento;
    private Pasajero pasajero;
    private Vuelo vuelo;

    public Reserva() {
    }

    public Reserva(int id_reserva, int fk_id_pasajero, int fk_id_vuelo, String fecha_reserva, String asiento, Pasajero pasajero, Vuelo vuelo) {
        this.id_reserva = id_reserva;
        this.fk_id_pasajero = fk_id_pasajero;
        this.fk_id_vuelo = fk_id_vuelo;
        this.fecha_reserva = fecha_reserva;
        this.asiento = asiento;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getFk_id_pasajero() {
        return fk_id_pasajero;
    }

    public void setFk_id_pasajero(int fk_id_pasajero) {
        this.fk_id_pasajero = fk_id_pasajero;
    }

    public int getFk_id_vuelo() {
        return fk_id_vuelo;
    }

    public void setFk_id_vuelo(int fk_id_vuelo) {
        this.fk_id_vuelo = fk_id_vuelo;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public String toString() {
        return "Reserva: " +
                "fecha_reserva='" + fecha_reserva + '\'' +
                ", asiento='" + asiento + '\'' + "\n" +
                " " + pasajero.getNombre() + "\n" +
                " " + vuelo.toString();
    }
}
