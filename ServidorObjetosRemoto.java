import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorObjetosRemoto {

    public ServidorObjetosRemoto() {

        // System.setSecurityManager(new RMISecurityManager());
    }

    /**
     * Activa el servidor de objetos remotos y registra el objeto.
     */
    public void activarObjetos() {
        try {
            // Crear el objeto remoto del servidor de información de clientes
            ServidorInfoClientes servidorInfoClientes = new ServidorInfoClientes();

            // Iniciar el registro RMI en el puerto 1099 (el puerto por defecto de RMI)
            LocateRegistry.createRegistry(1099);

            // Registrar el objeto remoto en el RMI registry
            Naming.rebind("ServidorInfoClientes", servidorInfoClientes);

            System.out.println("Servidor de Información de Clientes activo y registrado.");
        } catch (RemoteException e) {
            System.out.println("Error en la creación del objeto remoto: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Crear una instancia del servidor de objetos remoto
        ServidorObjetosRemoto servidor = new ServidorObjetosRemoto();
        // Activar y registrar los objetos remotos
        servidor.activarObjetos();
    }
}
