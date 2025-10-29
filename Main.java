import org.json.JSONException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JSONException {

        // Cargar personajes desde JSON
        System.out.println("Cargando personajes...");
        List<Personaje> personajes = JsonParser.cargarPersonajesDesdeArchivo("src/personajes");
        System.out.println("Se cargaron " + personajes.size() + " personajes");

        // Crear registro
        StarWarsRegistro<Personaje> registro = new StarWarsRegistro<>();

        // Agregar personajes al registro
        for (Personaje personaje : personajes) {
            registro.agregarPersonaje(personaje);
        }

        System.out.println("\nPersonajes en el registro:");
        System.out.println(registro);

        // Buscar personajes
        System.out.println("Buscando personajes...");
        buscarPersonaje(registro, "Luke Skywalker");
        buscarPersonaje(registro, "Darth Vader");
        buscarPersonaje(registro, "Yoda");

        // Intentar buscar personaje que no existe
        System.out.println("\nBuscando personaje inexistente...");
        buscarPersonaje(registro, "Anakin Skywalker");

        // Mostrar detalles
        System.out.println("\nDetalles de personajes:");
        mostrarDetalles(registro.listarPersonajes());

        // Extraer naves y guardar en archivo binario
        System.out.println("\nExtrayendo naves...");
        List<Nave> naves = ArchivoBinario.extraerNavesDePersonajes(personajes);
        System.out.println("Total naves: " + naves.size());

        String archivo = "naves.dat";
        if (ArchivoBinario.guardarNaves(naves, archivo)) {
            System.out.println("Naves guardadas en " + archivo);
        }

        // Mostrar archivo binario
        System.out.println("\nContenido del archivo:");
        ArchivoBinario.mostrarArchivo(archivo);

        // Eliminar personaje
        System.out.println("Eliminando personaje...");
        try {
            Personaje p = registro.obtenerPersonajePorNombre("Darth Vader");
            registro.eliminarPersonaje(p);
            System.out.println("Personaje eliminado: " + p.getNombre());
        } catch (PersonajeNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTotal personajes en registro: " + registro.cantidadPersonajes());
    }

    private static void buscarPersonaje(StarWarsRegistro<Personaje> registro, String nombre) {
        try {
            Personaje p = registro.obtenerPersonajePorNombre(nombre);
            System.out.println("Encontrado: " + p.getNombre() + " - Edad: " + p.getEdad() +
                             " - Jedi: " + p.isJedi() + " - Planeta: " + p.getPlanetaNacimiento());
        } catch (PersonajeNoEncontradoException e) {
            System.out.println("No encontrado: " + e.getNombreBuscado());
        }
    }

    private static void mostrarDetalles(List<Personaje> personajes) {
        for (Personaje p : personajes) {
            System.out.println("\n" + p.getNombre());
            System.out.println("  Edad: " + p.getEdad());
            System.out.println("  Jedi: " + p.isJedi());
            System.out.println("  Planeta: " + p.getPlanetaNacimiento());

            if (p.getMaestro() != null) {
                System.out.println("  Maestro: " + p.getMaestro().getNombre());
            }

            System.out.println("  Amigos: " + p.getAmigos().size());
            for (Amigo amigo : p.getAmigos()) {
                System.out.print("    - " + amigo.getNombre());
                if (amigo.getNave() != null) {
                    System.out.print(" (Nave: " + amigo.getNave().getNombre() + ")");
                }
                System.out.println();
            }

            System.out.println("  Eventos: " + p.getEventos().size());
            for (Evento evento : p.getEventos()) {
                System.out.println("    - " + evento.getNombre() + " (Año " + evento.getAnio() + ")");
            }
        }
    }
}
