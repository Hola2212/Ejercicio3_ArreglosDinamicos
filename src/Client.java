public class Client{
    /*
     * Para entrenadores y rutinas se habia expresado en arreglos dinamicos, pero para mantener una persistencia de datos adecuada, se trabajará con arreglos fijo con un máximo de 3.
     */
    private String nombre;
    private String entrenador;
    private String rutina; 
    public Client(String nombre, String entrenador, String rutina) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.rutina = rutina;
    }
    public String getNombre(){      //Obtiene el nombre del cliente
        return nombre;
    }
    public void changeTrainer(int posicion, String entrenador){     //Guarda el nombre del nuevo entrenador en la posicion seleccionada.
        try {
            entrenador = entrenador;
        } catch (Exception e) {
        }
    }
    public void changeRoutine(int posicion, String rutina){     //Guarda el nombre de la nueva rutina en la posicion seleccionada.
        try {
            rutina = rutina;
        } catch (Exception e) {
        }
    }
    public String getRoutines(){                        //Se obtienen la rutina
        return rutina;
    }
    public String getEntrenadores(){                    //Se obtienen el entrenador
        return entrenador;
    }
}