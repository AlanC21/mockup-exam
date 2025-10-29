import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para parsear objetos JSON a objetos Java
 */
public class JsonParser {

    /**
     * Parsea un JSONObject de nave a objeto Nave
     */
    public static Nave parsearNave(JSONObject jsonNave) {
        if (jsonNave == null) {
            return null;
        }
        String nombre = jsonNave.optString("nombre", "");
        String modelo = jsonNave.optString("modelo", "");
        return new Nave(nombre, modelo);
    }

    /**
     * Parsea un JSONObject de amigo a objeto Amigo
     */
    public static Amigo parsearAmigo(JSONObject jsonAmigo) throws JSONException {
        String nombre = jsonAmigo.optString("nombre", "");
        boolean piloto = jsonAmigo.optBoolean("piloto", false);

        Nave nave = null;
        if (jsonAmigo.has("nave") && !jsonAmigo.isNull("nave")) {
            nave = parsearNave(jsonAmigo.getJSONObject("nave"));
        }

        return new Amigo(nombre, piloto, nave);
    }

    /**
     * Parsea un JSONArray de amigos a lista de objetos Amigo
     */
    public static List<Amigo> parsearAmigos(JSONArray jsonAmigos) throws JSONException {
        List<Amigo> amigos = new ArrayList<>();
        for (int i = 0; i < jsonAmigos.length(); i++) {
            JSONObject jsonAmigo = jsonAmigos.getJSONObject(i);
            amigos.add(parsearAmigo(jsonAmigo));
        }
        return amigos;
    }

    /**
     * Parsea un JSONObject de maestro a objeto Maestro
     */
    public static Maestro parsearMaestro(JSONObject jsonMaestro) throws JSONException {
        String nombre = jsonMaestro.optString("nombre", "");
        boolean esJedi = jsonMaestro.optBoolean("es_jedi", false);

        List<String> habilidades = new ArrayList<>();
        if (jsonMaestro.has("habilidades")) {
            JSONArray jsonHabilidades = jsonMaestro.getJSONArray("habilidades");
            for (int i = 0; i < jsonHabilidades.length(); i++) {
                habilidades.add(jsonHabilidades.getString(i));
            }
        }

        return new Maestro(nombre, esJedi, habilidades);
    }

    /**
     * Parsea un JSONObject de evento a objeto Evento
     */
    public static Evento parsearEvento(JSONObject jsonEvento) {
        String nombre = jsonEvento.optString("nombre", "");
        int anio = jsonEvento.optInt("anio", 0);
        boolean ganada = jsonEvento.optBoolean("ganada", false);

        return new Evento(nombre, anio, ganada);
    }

    /**
     * Parsea un JSONArray de eventos a lista de objetos Evento
     */
    public static List<Evento> parsearEventos(JSONArray jsonEventos) throws JSONException {
        List<Evento> eventos = new ArrayList<>();
        for (int i = 0; i < jsonEventos.length(); i++) {
            JSONObject jsonEvento = jsonEventos.getJSONObject(i);
            eventos.add(parsearEvento(jsonEvento));
        }
        return eventos;
    }

    /**
     * Parsea un JSONObject de personaje a objeto Personaje
     */
    public static Personaje parsearPersonaje(JSONObject jsonPersonaje) throws JSONException {
        String nombre = jsonPersonaje.optString("nombre", "");
        int edad = jsonPersonaje.optInt("edad", 0);
        boolean jedi = jsonPersonaje.optBoolean("jedi", false);
        String planetaNacimiento = jsonPersonaje.optString("planeta_nacimiento", "");

        Maestro maestro = null;
        if (jsonPersonaje.has("maestro")) {
            maestro = parsearMaestro(jsonPersonaje.getJSONObject("maestro"));
        }

        List<Amigo> amigos = new ArrayList<>();
        if (jsonPersonaje.has("amigos")) {
            amigos = parsearAmigos(jsonPersonaje.getJSONArray("amigos"));
        }

        List<Evento> eventos = new ArrayList<>();
        if (jsonPersonaje.has("eventos")) {
            eventos = parsearEventos(jsonPersonaje.getJSONArray("eventos"));
        }

        return new Personaje(nombre, edad, jedi, planetaNacimiento, maestro, amigos, eventos);
    }

    /**
     * Parsea un JSONArray de personajes a lista de objetos Personaje
     */
    public static List<Personaje> parsearPersonajes(JSONArray jsonPersonajes) throws JSONException {
        List<Personaje> personajes = new ArrayList<>();
        for (int i = 0; i < jsonPersonajes.length(); i++) {
            JSONObject jsonPersonaje = jsonPersonajes.getJSONObject(i);
            personajes.add(parsearPersonaje(jsonPersonaje));
        }
        return personajes;
    }

    /**
     * Lee el archivo JSON de personajes y retorna la lista de personajes
     */
    public static List<Personaje> cargarPersonajesDesdeArchivo(String archivo) throws JSONException {
        String contenidoJson = JsonUtiles.leer(archivo);
        JSONObject jsonObject = new JSONObject(contenidoJson);
        JSONArray jsonPersonajes = jsonObject.getJSONArray("personajes");
        return parsearPersonajes(jsonPersonajes);
    }
}

