public class Trainer{
    private String nombre;
    private int cantidadClientes;
    public Trainer(String nombre, int cantidadClientes) {
        this.nombre = nombre;
        this.cantidadClientes = cantidadClientes;
    }
    public String getNombre(){      //Obtiene el nombre del entrenador
        return nombre;
    }
    public int getClientes(){       //Obtiene cantidad de clientes que tiene el entrenador
        return cantidadClientes;
    }
    public void setClientes(int modificador){       //Modifica la cantidad de clientes que tiene el entrenador (1/-1)
        cantidadClientes = cantidadClientes + modificador;
    }
}