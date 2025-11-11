package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class InventarioVista {
    Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ INVENTARIO =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public Producto pedirDatosUsuario() {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.next();
        System.out.print("Ingrese SKU: ");
        String sku = sc.next();
        System.out.print("Ingrese cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Ingrese precio: ");
        double precio = sc.nextDouble();
        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        System.out.print("Ingrese SKU: ");
        return sc.next();
    }

    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}