package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    Producto nuevo = vista.pedirDatosUsuario();
                    baseDatos.agregarProducto(nuevo);
                    vista.mostrarMensaje("✅ Producto agregado correctamente.");
                    break;
                case 2:
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                case 3:
                    vista.mostrarProductos(baseDatos.buscarTodos());
                    break;
                case 4:
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.eliminarProducto(skuEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("🗑️ Producto eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("❌ No se encontró el producto.");
                    }
                    break;
                case 5:
                    vista.mostrarMensaje("👋 Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }
}