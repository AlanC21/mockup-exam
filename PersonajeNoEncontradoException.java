/**
 * Excepción personalizada que se lanza cuando un personaje no es encontrado en el registro
 */
public class PersonajeNoEncontradoException extends Exception {
    private String nombreBuscado;

    // Constructor que recibe el nombre del personaje buscado
    public PersonajeNoEncontradoException(String nombreBuscado) {
        super("Personaje no encontrado: " + nombreBuscado);
        this.nombreBuscado = nombreBuscado;
    }

    // Constructor con mensaje personalizado
    public PersonajeNoEncontradoException(String nombreBuscado, String mensaje) {
        super(mensaje);
        this.nombreBuscado = nombreBuscado;
    }

    // Getter para obtener el nombre buscado
    public String getNombreBuscado() {
        return nombreBuscado;
    }
}

