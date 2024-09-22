import java.rmi.*;
import java.util.List;

/**
 * Definicion de la interfaz remota para el Servidor de Información de Clientes
 */
public interface ServidorInfoClientesRemoto extends Remote {
    
    // Método para obtener un cliente por su ID
    Cliente getCliente(int id) throws RemoteException;
    
    // Método para listar todos los clientes
    List<Cliente> getAllClientes() throws RemoteException;
    
    // Método para agregar un nuevo cliente
    boolean addCliente(Cliente cliente) throws RemoteException;
    
    // Método para actualizar la información de un cliente
    boolean updateCliente(Cliente cliente) throws RemoteException;
    
    // Método para eliminar un cliente por su ID
    boolean deleteCliente(int id) throws RemoteException;
    
    // Método para buscar clientes por un criterio (nombre, apellido, etc.)
    List<Cliente> searchCliente(String criterio) throws RemoteException;
}
