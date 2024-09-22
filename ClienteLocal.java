import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClienteLocal {

    public ClienteLocal() {

        // System.setSecurityManager(new RMISecurityManager());
    }

    public Object getRemoteObject(String urlRmi) {
        Object obj = null;
        try {
            // Busca el objeto remoto por su URL y lo retorna si lo encuentra
            obj = Naming.lookup(urlRmi);
            System.out.println("¡Búsqueda en el servidor remoto exitosa!");
        } catch (RemoteException re) {
            System.out.println("ERROR remoto: " + re.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR general: " + e.getMessage());
        }
        return obj;
    }

    public static void main(String[] args) {
        try {
            ClienteLocal cliente = new ClienteLocal();
            // Obtener el objeto remoto registrado con el nombre "ServidorInfoClientes"
            ServidorInfoClientesRemoto servidor = (ServidorInfoClientesRemoto) cliente.getRemoteObject("rmi://localhost/ServidorInfoClientes");

            if (servidor != null) {
                // Llamar a un método remoto, por ejemplo, obtener información de un cliente
                Cliente clienteInfo = servidor.getCliente(1);
                if (clienteInfo != null) {
                    System.out.println("Cliente encontrado: " + clienteInfo.getNombre());
                } else {
                    System.out.println("Cliente no encontrado.");
                }
            } else {
                System.out.println("No se pudo obtener el objeto remoto.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
