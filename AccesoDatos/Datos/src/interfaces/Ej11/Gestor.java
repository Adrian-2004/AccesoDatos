package interfaces.Ej11;

import java.util.List;

public interface Gestor{
void anadir(Object elemento);
    Object buscar(String id);
    boolean eliminar(String id);
    List<?> listar();
}
