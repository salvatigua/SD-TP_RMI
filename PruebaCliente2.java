import java.rmi.*;

public class PruebaCliente2 {
    public static void main(String[] args) {
        // Declaración de la interfaz a utilizar en el cliente
        ServidorInfoClientesRemoto servidor;

        ClienteLocal clienteLocal = new ClienteLocal();

        String nombreServerRemoto = "127.0.0.1"; // IP del servidor remoto
        String nombreObjetoRemoto = "ServidorInfoClientes"; // Nombre del objeto remoto

        // Busca el objeto en el servidor remoto
        Object re = clienteLocal.getRemoteObject("rmi://" + nombreServerRemoto + "/" + nombreObjetoRemoto);
        servidor = (ServidorInfoClientesRemoto) re;

        try {
            // Crear un nuevo cliente
            Cliente nuevoCliente = new Cliente(1, "Juan","Belgrano 400","3442123456"); // Suponiendo que el constructor es (id, nombre)

            // Agregar el cliente al servidor
            boolean agregado = servidor.addCliente(nuevoCliente);
            if (agregado) {
                System.out.println("Cliente agregado exitosamente.");
            } else {
                System.out.println("Error al agregar el cliente.");
            }

            // Buscar el cliente agregado
            Cliente clienteBuscado = servidor.getCliente(1); // Buscar por ID
            if (clienteBuscado != null) {
                System.out.println("Cliente encontrado: " + clienteBuscado.getNombre());
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("ERROR al llamar a los métodos: " + e);
        }
    }
}
