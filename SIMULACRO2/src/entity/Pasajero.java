package entity;

public class Pasajero {
    private int id_pasajero;
    private String nombre;
    private String apellido;
    private String doc_iden;

    public Pasajero() {
    }

    public Pasajero(int id_pasajero, String nombre, String apellido, String doc_iden) {
        this.id_pasajero = id_pasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.doc_iden = doc_iden;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDoc_iden() {
        return doc_iden;
    }

    public void setDoc_iden(String doc_iden) {
        this.doc_iden = doc_iden;
    }

    @Override
    public String toString() {
        return "Pasajero: " +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", doc_iden='" + doc_iden + '\'';
    }
}
