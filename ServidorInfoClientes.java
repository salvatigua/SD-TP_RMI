import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase remota ServidorInfoClientes, que corre en el Servidor
 */
public class ServidorInfoClientes extends UnicastRemoteObject implements ServidorInfoClientesRemoto {

    // Lista de clientes para almacenar la información
    private List<Cliente> clientes;

    // Constructor de la clase
    public ServidorInfoClientes() throws RemoteException {
        super();
        clientes = new ArrayList<>();  // Inicialización de la lista de clientes
    }

    // Implementación de los métodos de la interfaz

    // Obtener un cliente por su ID
    @Override
    public Cliente getCliente(int id) throws RemoteException {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;  // Retornar null si no se encuentra el cliente
    }

    // Listar todos los clientes
    @Override
    public List<Cliente> getAllClientes() throws RemoteException {
        return clientes;
    }

    // Agregar un nuevo cliente
    @Override
    public boolean addCliente(Cliente cliente) throws RemoteException {
        return clientes.add(cliente);
    }

    // Actualizar la información de un cliente
    @Override
    public boolean updateCliente(Cliente cliente) throws RemoteException {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                return true;
            }
        }
        return false;  // Retorna false si el cliente no se encuentra
    }

    // Eliminar un cliente por su ID
    @Override
    public boolean deleteCliente(int id) throws RemoteException {
        return clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // Buscar clientes por un criterio (nombre, apellido, etc.)
    @Override
    public List<Cliente> searchCliente(String criterio) throws RemoteException {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().contains(criterio)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }
}
