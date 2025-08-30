public class Exercise{
    private String nombre;
    private int repeticiones;
    private int series;
    public Exercise(String nombre, int repeticiones, int series) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.series = series;
    }
    public String getNombre(){          //Obtiene el nombre del ejercicio
        return nombre;
    }
    public int getRepeticiones(){       //Obtiene las repeticiones del ejercicio
        return repeticiones;
    }
    public int getSeries(){             //Obtiene las series de repeticiones del ejercicio
        return series;
    }
}