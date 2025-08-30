public class Client{
    /*
     * Para entrenadores y rutinas se habia expresado en arreglos dinamicos, pero para mantener una persistencia de datos adecuada, se trabajará con arreglos fijo con un máximo de 3.
     */
    private String nombre;
    private String[] entrenadores;
    private String[] rutinas; 
    public Client(String nombre, String[] entrenadores, String[] rutinas) {
        this.nombre = nombre;
        this.entrenadores = entrenadores;
        this.rutinas = rutinas;
    }
    public String getNombre(){      //Obtiene el nombre del cliente
        return nombre;
    }
    public void changeTrainer(int posicion, String entrenador){     //Guarda el nombre del nuevo entrenador en la posicion seleccionada.
        try {
            entrenadores[posicion] = entrenador;
        } catch (Exception e) {
        }
    }
    public void changeRoutine(int posicion, String rutina){     //Guarda el nombre de la nueva rutina en la posicion seleccionada.
        try {
            rutinas[posicion] = rutina;
        } catch (Exception e) {
        }
    }
    public String getRoutines(){                        //Se obtienen los nombres de todas las rutinas
        String todasRutinas = "";
        for (int i = 0; i < 2; i++) {
            try {
                todasRutinas = todasRutinas + rutinas[i];
                todasRutinas = todasRutinas + "/n";
            } catch (Exception e) {
            }
        }
        try {
            todasRutinas = todasRutinas + rutinas[3];
        } catch (Exception e) {
        }
        todasRutinas = todasRutinas + ".";
        return todasRutinas;
    }
    public String getEntrenadores(){                    //Se obtienen los nombres de todos los entrenadores
        String todasEntrenadores = "";
        for (int i = 0; i < 2; i++) {
            try {
                todasEntrenadores = todasEntrenadores + entrenadores[i];
                todasEntrenadores = todasEntrenadores + "/n";
            } catch (Exception e) {
            }
        }
        try {
            todasEntrenadores = todasEntrenadores + entrenadores[3];
        } catch (Exception e) {
        }
        todasEntrenadores = todasEntrenadores + ".";
        return todasEntrenadores;
    }
}