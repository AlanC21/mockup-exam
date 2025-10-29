import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un maestro Jedi o Sith
 */
public class Maestro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private boolean esJedi;
    private List<String> habilidades;

    // Constructor
    public Maestro(String nombre, boolean esJedi, List<String> habilidades) {
        this.nombre = nombre;
        this.esJedi = esJedi;
        this.habilidades = habilidades != null ? habilidades : new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsJedi() {
        return esJedi;
    }

    public void setEsJedi(boolean esJedi) {
        this.esJedi = esJedi;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maestro maestro = (Maestro) o;
        return Objects.equals(nombre, maestro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Maestro{" +
                "nombre='" + nombre + '\'' +
                ", esJedi=" + esJedi +
                ", habilidades=" + habilidades +
                '}';
    }
}

