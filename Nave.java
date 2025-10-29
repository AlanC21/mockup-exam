import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa una nave en el universo Star Wars
 * Implementa Serializable para poder ser guardada en archivo binario
 */
public class Nave implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String modelo;

    // Constructor
    public Nave(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nave nave = (Nave) o;
        return Objects.equals(nombre, nave.nombre) && Objects.equals(modelo, nave.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, modelo);
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}

