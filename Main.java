import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    String nombre;
    int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad;
    }
}

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Ver clientes");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Salir");
            System.out.print("Elegí una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);
    }

    static void agregarCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        clientes.add(new Cliente(nombre, edad));
        System.out.println("✅ Cliente agregado correctamente");
    }

    static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("⚠️ No hay clientes cargados.");
        } else {
            System.out.println("\n📋 Lista de clientes:");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(i + " - " + clientes.get(i));
            }
        }
    }

    static void eliminarCliente() {
        mostrarClientes();

        if (!clientes.isEmpty()) {
            System.out.print("Índice del cliente a eliminar: ");
            int index = sc.nextInt();

            if (index >= 0 && index < clientes.size()) {
                clientes.remove(index);
                System.out.println("🗑️ Cliente eliminado correctamente");
            } else {
                System.out.println("❌ Índice inválido");
            }
        }
    }
                }
