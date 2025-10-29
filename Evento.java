import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa un evento en la historia de Star Wars
 */
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int anio;
    private boolean ganada;

    // Constructor
    public Evento(String nombre, int anio, boolean ganada) {
        this.nombre = nombre;
        this.anio = anio;
        this.ganada = ganada;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isGanada() {
        return ganada;
    }

    public void setGanada(boolean ganada) {
        this.ganada = ganada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return anio == evento.anio && Objects.equals(nombre, evento.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, anio);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", ganada=" + ganada +
                '}';
    }
}

