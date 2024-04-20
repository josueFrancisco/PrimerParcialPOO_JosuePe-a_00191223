import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Electronico {
    private String nombre;
    private String modelo;
    private String descripcion;
    private double precio;

    public Electronico(String nombre, String modelo, String descripcion, double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;

    }

}

interface Informacion {
    double precio(double precio);

    String descripcion(String descripcion);
}

abstract class Telefono extends Electronico {
    private String color;
    private String red;

    public Telefono(String nombre, String modelo, String descripcion, double precio, String color, String red) {
        super(nombre, modelo, descripcion, precio);
        this.color = color;
        this.red = red;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }
}

abstract class Laptop extends Electronico {
    private String teclado;
    private String pantalla;

    public Laptop(String nombre, String modelo, String descipcion, double precio, String teclado, String pantalla) {
        super(nombre, modelo, descipcion, precio);
        this.teclado = teclado;
        this.pantalla = pantalla;

    }

    public String getTeclado() {
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }
}

class GestorElectronicos {
    private Map<String, Electronico> electronicos;

    public GestorElectronicos() {
        this.electronicos = new HashMap<>();
    }

    public void agregarElectronico(Electronico electronico) {
        electronicos.put(electronico.getNombre(), electronico);

    }

    public Electronico buscarElectronico(String nombre) {
        return electronicos.get(nombre);
    }
    public void mostrar() {
        for (Electronico electronico1 : electronicos.values()) {
            System.out.println("Nombre: " + electronico1.getNombre() + ", Modelo:" + electronico1.getModelo() + " Descripcion:"+ electronico1.getDescripcion() + " Precio :$" + electronico1.getPrecio());
        }
    }

}

public class Main {
    public static void main(String[] args) {
        GestorElectronicos gestor = new GestorElectronicos();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Ingrese la opcion que desee");
            System.out.println("0-Salir del programa");
            System.out.println("1-Agregar telefono");
            System.out.println("2-Agregar laptop");
            System.out.println("3-Mostrar productos");
            System.out.println("4-Modificar nombre del electronico");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del telefono:");
                    System.out.print("Nombre: ");
                    String nombre1 = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo1 = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion1 = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio1 = scanner.nextDouble();
                    if (precio1 > 0) {
                        System.out.println("Color:");
                        String color = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Red:");
                        String red = scanner.nextLine();
                        Electronico electronico1 = new Telefono(nombre1, modelo1, descripcion1, precio1, color, red) {
                        };
                        gestor.agregarElectronico(electronico1);
                    } else {
                        System.out.println("No colocar cifras negativas.");
                    }

                    break;
                case 2:
                    System.out.println("Ingrese los datos de la computadora:");
                    System.out.print("Nombre: ");
                    String nombre2 = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo2 = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion2 = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio2 = scanner.nextDouble();
                    if (precio2 > 0) {
                    System.out.print("Teclado: ");
                    String teclado = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Pantalla: ");
                    String pantalla = scanner.nextLine();

                    Electronico electronico2 = new Laptop(nombre2, modelo2, descripcion2, precio2, teclado, pantalla) {
                    };
                    gestor.agregarElectronico(electronico2);
                    } else {
                        System.out.println("No colocar cifras negativas.");
                    }
                    break;

                case 3:
                    System.out.println("Mostrando productos:");
                    gestor.mostrar();
                    scanner.nextLine();
                    break;
                    
                case 4:
                    System.out.print("Ingrese el nombre del electronico que desea modificar: ");
                    String modificar = scanner.nextLine();

                    Electronico empleadoModificar = gestor.buscarElectronico(modificar);

                    if (empleadoModificar != null) {
                        System.out.println("Ingrese el nuevo nombre:");
                        System.out.print("Nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        scanner.nextLine();
                        empleadoModificar.setNombre(nuevoNombre);
                        ;

                        System.out.println("Electornico modificado correctamente.");
                    } else {

                        System.out.println("Electronico no encontrado.");
                    }
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (opcion != 0);
    }
}

