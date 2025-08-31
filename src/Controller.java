import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller{
    private Scanner teclado = new Scanner(System.in);
    private ArrayList<Trainer> entrenadores = new ArrayList<>();
    private ArrayList<Client> clientes = new ArrayList<>();
    private ArrayList<Routine> rutinas = new ArrayList<>();
    private ArrayList<Exercise> ejercicios = new ArrayList<>();
    private List<String> equivalenteEjercicios = new ArrayList<>();
    public Controller() {
        setInitialTrainers();
    }
    public void setInitialTrainers(){
        String archCSV = "D:\\listaEntrenadores.csv";
        List<List<String>> data = new ArrayList<>();
        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(archCSV))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                // Add the line data to our main list
                if (lineData.get(0) == "Nombre") {}
                else{
                data.add(lineData);
                }
            }
            for (int i = 0; i < data.size(); i++) {
                String nombreEntrenador = data.get(i).get(0);
                String cantidad = data.get(i).get(1);
                int cantClientesEntrenador = Integer.parseInt(cantidad);
                entrenadores.add(new Trainer(nombreEntrenador, cantClientesEntrenador));
            }
        } catch (IOException e) {}
    }
    
    public void setInitialClients(){
        String archCSV = "D:\\listaClientes.csv";
        List<List<String>> data = new ArrayList<>();
        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(archCSV))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                // Add the line data to our main list
                if (lineData.get(0) == "Nombre") {}
                else{
                data.add(lineData);
                }
            }
            for (int i = 0; i < data.size(); i++) {
                String nombreCliente = data.get(i).get(0);
                String nombreEntrenador = data.get(i).get(1);
                String nombreRutina = data.get(i).get(2);
                clientes.add(new Client(nombreCliente,nombreEntrenador,nombreRutina));
            }
        } catch (IOException e) {}
    }
    public void setInitialExercises(){
        String archCSV = "D:\\listaEjercicios.csv";
        List<List<String>> data = new ArrayList<>();
        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(archCSV))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                // Add the line data to our main list
                if (lineData.get(0) == "Nombre") {}
                else{
                data.add(lineData);
                }
            }
            for (int i = 0; i < data.size(); i++) {
                String nombreEjercicio = data.get(i).get(0);
                int repeticiones = Integer.parseInt(data.get(i).get(1));
                int series = Integer.parseInt(data.get(i).get(2));
                equivalenteEjercicios.add(nombreEjercicio);
                ejercicios.add(new Exercise(nombreEjercicio,repeticiones,series));
            }
        } catch (IOException e) {}
    }

    public void setInitialRoutines(){
        String archCSV = "D:\\listaRutinas.csv";
        List<List<String>> data = new ArrayList<>();
        // Try-with-resources to ensure the reader gets closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(archCSV))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma and convert to a List
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                // Add the line data to our main list
                if (lineData.get(0) == "Nombre") {}
                else{
                data.add(lineData);
                }
            }
            for (int i = 0; i < data.size(); i++) {
                String nombreRutina = data.get(i).get(0);
                Exercise ejercicio1 = ejercicios.get(equivalenteEjercicios.indexOf(data.get(i).get(1)));
                Exercise ejercicio2 = ejercicios.get(equivalenteEjercicios.indexOf(data.get(i).get(2)));
                Exercise ejercicio3 = ejercicios.get(equivalenteEjercicios.indexOf(data.get(i).get(3)));
                Exercise ejercicio4 = ejercicios.get(equivalenteEjercicios.indexOf(data.get(i).get(4)));
                Exercise ejercicio5 = ejercicios.get(equivalenteEjercicios.indexOf(data.get(i).get(5)));
                Exercise ejercicio6 = ejercicios.get(equivalenteEjercicios.indexOf(data.get(i).get(6)));
                int cantClientesRutina = Integer.parseInt(data.get(i).get(7));
                Exercise[] ejercicioRutina = {ejercicio1,ejercicio2,ejercicio3,ejercicio4,ejercicio5,ejercicio6};
                rutinas.add(new Routine(nombreRutina,ejercicioRutina,cantClientesRutina));
            }
        } catch (IOException e) {}
    }
    public void agregarEntrenador(String nombre){
        try {
            entrenadores.get( entrenadores.indexOf(nombre));
        } catch (Exception e) {
            entrenadores.add(new Trainer(nombre,0));
        }
    }
    public void agregarRutina(String nombre, Exercise[] ejerciciosRutina, int cantClientesRutina){
        try {
            rutinas.get(rutinas.indexOf(nombre));
        } catch (Exception e) {
            rutinas.add(new Routine(nombre, ejerciciosRutina, cantClientesRutina));
        }
    }
    public void agregarEjercicio(String nombre, int repeticiones, int series){
        try {
            ejercicios.get(ejercicios.indexOf(nombre));
        } catch (Exception e) {
            ejercicios.add(new Exercise(nombre, repeticiones, series));
        }
    }
    
    public void agregarCliente(String nombre, String entrenador, String rutina){
        try {
            clientes.get(clientes.indexOf(nombre));
        } catch (Exception e) {
            clientes.add(new Client(nombre, entrenador, rutina));
            for (int i = 0; i < entrenadores.size(); i++) {
                if(entrenadores.get(i).getNombre() == entrenador){
                    Trainer nuevaInfoEntrenador = entrenadores.get(i);
                    nuevaInfoEntrenador.setClientes(1);
                    entrenadores.set(i,nuevaInfoEntrenador);
                }
            }
            for (int i = 0; i < rutinas.size(); i++) {
                if(rutinas.get(i).getNombreRutina() == rutina){
                    Routine nuevaInfoRutina = rutinas.get(i);
                    nuevaInfoRutina.setRoutine(1);
                    rutinas.set(i,nuevaInfoRutina);
                }
            }
        }
    }
    public int cantRutinas(){
        return rutinas.size();
    }
    public String analisisEntrenadores(){
        int maximo = 0;
        String nombre = "";
        for (int i = 0; i < entrenadores.size(); i++) {
            if(entrenadores.get(i).getClientes() > maximo){
                maximo = entrenadores.get(i).getClientes();
                nombre = entrenadores.get(i).getNombre();
            }
        }
        return (nombre + " con " + Integer.toString(maximo) + " clientes");
    }
    public String analisisRutinas(){
        int maximo = 0;
        String nombre = "";
        for (int i = 0; i < rutinas.size(); i++) {
            if(rutinas.get(i).getRoutines() > maximo){
                maximo = rutinas.get(i).getRoutines();
                nombre = rutinas.get(i).getNombreRutina();
            }
        }
        return (nombre + " con " + Integer.toString(maximo) + " clientes");
    }
}