import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un personaje de Star Wars
 */
public class Personaje implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;
    private boolean jedi;
    private String planetaNacimiento;
    private Maestro maestro;
    private List<Amigo> amigos;
    private List<Evento> eventos;

    // Constructor
    public Personaje(String nombre, int edad, boolean jedi, String planetaNacimiento,
                     Maestro maestro, List<Amigo> amigos, List<Evento> eventos) {
        this.nombre = nombre;
        this.edad = edad;
        this.jedi = jedi;
        this.planetaNacimiento = planetaNacimiento;
        this.maestro = maestro;
        this.amigos = amigos != null ? amigos : new ArrayList<>();
        this.eventos = eventos != null ? eventos : new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isJedi() {
        return jedi;
    }

    public void setJedi(boolean jedi) {
        this.jedi = jedi;
    }

    public String getPlanetaNacimiento() {
        return planetaNacimiento;
    }

    public void setPlanetaNacimiento(String planetaNacimiento) {
        this.planetaNacimiento = planetaNacimiento;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Amigo> amigos) {
        this.amigos = amigos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * Obtiene todas las naves asociadas al personaje (de sus amigos)
     */
    public List<Nave> obtenerNaves() {
        List<Nave> naves = new ArrayList<>();
        for (Amigo amigo : amigos) {
            if (amigo.getNave() != null) {
                naves.add(amigo.getNave());
            }
        }
        return naves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", jedi=" + jedi +
                ", planetaNacimiento='" + planetaNacimiento + '\'' +
                ", maestro=" + maestro +
                ", amigos=" + amigos +
                ", eventos=" + eventos +
                '}';
    }
}

