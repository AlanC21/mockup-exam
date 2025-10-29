import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoBinario {

    public static boolean guardarNaves(List<Nave> naves, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nombreArchivo))) {
            oos.writeObject(naves);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar naves: " + e.getMessage());
            return false;
        }
    }

    public static List<Nave> leerNaves(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(nombreArchivo))) {
            return (List<Nave>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer naves: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void mostrarArchivo(String nombreArchivo) {
        List<Nave> naves = leerNaves(nombreArchivo);

        if (naves.isEmpty()) {
            System.out.println("No hay naves en el archivo o el archivo no existe.");
            return;
        }

        System.out.println("\n=== CONTENIDO DEL ARCHIVO BINARIO: " + nombreArchivo + " ===");
        System.out.println("Total de naves: " + naves.size());
        System.out.println("-".repeat(60));

        int contador = 1;
        for (Nave nave : naves) {
            System.out.println(contador + ". " + nave);
            contador++;
        }
        System.out.println("=".repeat(60) + "\n");
    }

    public static List<Nave> extraerNavesDePersonajes(List<Personaje> personajes) {
        List<Nave> todasLasNaves = new ArrayList<>();

        for (Personaje personaje : personajes) {
            List<Nave> navesDelPersonaje = personaje.obtenerNaves();
            for (Nave nave : navesDelPersonaje) {
                // Evitar duplicados
                if (!todasLasNaves.contains(nave)) {
                    todasLasNaves.add(nave);
                }
            }
        }

        return todasLasNaves;
    }
}

