import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa un amigo de un personaje
 */
public class Amigo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private boolean piloto;
    private Nave nave;

    // Constructor
    public Amigo(String nombre, boolean piloto, Nave nave) {
        this.nombre = nombre;
        this.piloto = piloto;
        this.nave = nave;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPiloto() {
        return piloto;
    }

    public void setPiloto(boolean piloto) {
        this.piloto = piloto;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amigo amigo = (Amigo) o;
        return Objects.equals(nombre, amigo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "nombre='" + nombre + '\'' +
                ", piloto=" + piloto +
                ", nave=" + nave +
                '}';
    }
}

