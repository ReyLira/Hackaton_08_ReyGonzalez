
package dao;

import java.util.List;

/**
 *
 * @author HP
 * @param <Generic>
 */
public interface ICRUD <Generic> {
    void registrar(Generic obj) throws Exception;
    void modificar(Generic obj) throws Exception;
    void eliminar(Generic obj) throws Exception;
    void cambiarEstado(Generic obj) throws Exception;
    List<Generic> listar() throws Exception;
    List<Generic> listarTodos(char estado) throws Exception;
}
