package entity;

public class Vuelo {
    private int id_vuelo;
    private String destino;
    private String fecha_salida;
    private String hora_salida;
    private int fk_id_avion;
    private Avion avion;

    public Vuelo() {
    }

    public Vuelo(int id_vuelo, String destino, String fecha_salida, String hora_salida, int fk_id_avion, Avion avion) {
        this.id_vuelo = id_vuelo;
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.fk_id_avion = fk_id_avion;
        this.avion = avion;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getFk_id_avion() {
        return fk_id_avion;
    }

    public void setFk_id_avion(int fk_id_avion) {
        this.fk_id_avion = fk_id_avion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id_vuelo=" + id_vuelo +
                ", destino='" + destino + '\'' +
                ", fecha_salida='" + fecha_salida + '\'' +
                ", hora_salida='" + hora_salida + '\'' + "\n" +
                " " + avion.toString();
    }
}
