import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase genérica que actúa como registro de personajes de Star Wars
 * Utiliza un Set para evitar duplicados
 * @param <T> Tipo de personaje a almacenar
 */
public class StarWarsRegistro<T extends Personaje> {
    // Usamos un Set para evitar duplicados automáticamente
    private Set<T> personajes;

    // Constructor
    public StarWarsRegistro() {
        this.personajes = new HashSet<>();
    }

    /**
     * Agrega un personaje al registro
     * No se agregan duplicados gracias al uso de Set
     * @param personaje Personaje a agregar
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean agregarPersonaje(T personaje) {
        if (personaje == null) {
            return false;
        }
        return personajes.add(personaje);
    }

    /**
     * Obtiene el primer personaje encontrado con el nombre especificado
     * @param nombre Nombre del personaje a buscar
     * @return El personaje encontrado
     * @throws PersonajeNoEncontradoException Si no se encuentra el personaje
     */
    public T obtenerPersonajePorNombre(String nombre) throws PersonajeNoEncontradoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new PersonajeNoEncontradoException(nombre, "El nombre no puede ser nulo o vacío");
        }

        for (T personaje : personajes) {
            if (personaje.getNombre().equalsIgnoreCase(nombre.trim())) {
                return personaje;
            }
        }

        // Si no se encuentra, lanzar la excepción personalizada
        throw new PersonajeNoEncontradoException(nombre);
    }

    /**
     * Elimina la primera aparición del personaje especificado del registro
     * @param personaje Personaje a eliminar
     * @return true si se eliminó correctamente, false si no existía
     */
    public boolean eliminarPersonaje(T personaje) {
        if (personaje == null) {
            return false;
        }
        return personajes.remove(personaje);
    }

    /**
     * Devuelve una lista con todos los personajes del registro
     * @return Lista de personajes
     */
    public List<T> listarPersonajes() {
        return new ArrayList<>(personajes);
    }

    /**
     * Elimina todos los personajes del registro
     */
    public void limpiar() {
        personajes.clear();
    }

    /**
     * Obtiene la cantidad de personajes en el registro
     * @return Cantidad de personajes
     */
    public int cantidadPersonajes() {
        return personajes.size();
    }

    /**
     * Verifica si el registro está vacío
     * @return true si está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return personajes.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StarWarsRegistro - Total de personajes: ").append(personajes.size()).append("\n");
        for (T personaje : personajes) {
            sb.append(" - ").append(personaje.getNombre()).append("\n");
        }
        return sb.toString();
    }
}

