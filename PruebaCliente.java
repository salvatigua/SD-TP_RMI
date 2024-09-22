import java.rmi.*;

public class PruebaCliente {
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
            // Llama al método remoto para obtener un cliente específico
            Cliente clienteInfo = servidor.getCliente(1); // Asumiendo que el ID del cliente es 1

            if (clienteInfo != null) {
                System.out.println("Cliente encontrado: " + clienteInfo.getNombre());
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("ERROR al llamar al método getCliente: " + e);
        }
    }
}
