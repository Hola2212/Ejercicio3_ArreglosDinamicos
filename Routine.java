public class Routine{
    private String nombre;
    private Exercise[] ejercicios;
    private int clientesCant;
    public Routine(String nombre, Exercise[] ejercicios, int clientesCant) {
        this.nombre = nombre;
        this.ejercicios = ejercicios;
        this.clientesCant = clientesCant;
    }
    public String getNombreRutina(){    //Obtiene el nombre de la rutina
        return nombre;
    }
    public String getNombreEjercicio(int numEjercicio){     //Obtiene el nombre de un ejercicio específico de la rutina
        try {
            return ejercicios[numEjercicio].getNombre();
        } catch (Exception e) {
            return "No existe el ejercicio en la rutina";
        }
    }
    public int getRepeticiones(int numEjercicio){       //Obtiene las repeticiones de un ejercicio específico
        try {
            return ejercicios[numEjercicio].getRepeticiones();
        } catch (Exception e) {
            return 0;
        }
    }
    public int getSeries(int numEjercicio){             //Obtiene las series de repeticiones de un ejercicio específico
        try {
            return ejercicios[numEjercicio].getSeries();
        } catch (Exception e) {
            return 0;
        }
    }
    public void setRoutine(int numEjercicios){          //Modifica la cantidad de clientes que tienen la rutina añadida (1/-1)
        clientesCant = clientesCant + numEjercicios;
    }
    public int getRoutines(){                           //Obtiene la cantidad de clientes que tienen esta rutina.
        return clientesCant;
    }
}