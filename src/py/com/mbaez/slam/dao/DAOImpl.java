/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.mbaez.slam.dao;

import java.util.List;
import py.com.mbaez.slam.Reader;

/**
 *
 * @author mbaez
 */
public class DAOImpl implements DAO {

    private Class clazz;
    private Reader reader;
    /**
     * Constructor de la clase DAOImpl
     * @param clazz 
     */
    public DAOImpl(Class clazz) {
        this.clazz = clazz;
        reader = new Reader(this.clazz);
    }

    /**
     * Este método obtiene la fila de la tabla que cumple con la
     * restricción del where dada por la columna que es la clave primaria
     * y su respectivo valor id.
     *
     * SELECT * FROM Table WHERE pk = id
     *
     * @param id la clave primaria
     * @return un objeto que cumpla con la restriccion dada por la clave primaria
     */
    public Object get(Object id) {
        this.filterBy(reader.getIdColumns().get(0), id);
        return null;
    }

    /**
     * Este método obtiene la fila de la tabla que cumple con la
     * restricción del where dada por las columnas que son forman parte de la
     * clave primaria y sus respectivos valores id.
     *
     * SELECT * FROM Table WHERE pk1 = id1 AND pk2 = id2 ...
     *
     * @param id valores de la clave primaria
     * @return un objeto que cumpla con la restriccion dada por la clave primaria
     */
    public Object get(Object[] id) {
        this.filterBy((String[]) reader.getIdColumns().toArray(), id);
        return null;
    }

    /**
     * Este método obtiene todas las filas de la tabla.
     * SELECT * FROM Table
     *
     * @return lista de objetos
     */
    public List listAll() {
        String query = "SELECT * FROM ";
        query += reader.getTableName();
        System.out.println(query);
        return null;
    }

    /**
     * Este método obtiene todas las filas de la tabla
     * que cumplan con la restricción del where dada por
     * las columnas column y sus respectivos valores value.
     *
     * SELECT * FROM Table WHERE column1 = value1 AND column2 = value2 ...
     *
     * @param column nombre de la coluna por la cual se desea filtrar.
     * @param value valor para por el cual se desea filtrar.
     * @return lista de objetos que cumplen con la restricción definida.
     */
    public List filterBy(String[] columns, Object[] values) {
        String query = "SELECT * FROM ";
        query += reader.getTableName();
        query += " WHERE ";
        int index = 0;

        for (String column : columns) {
            query += column;
            query += " = " + values[index];

            index++;

            if (index < reader.getIdColumns().size()) {
                query += " AND ";
            }
        }
        System.out.println(query);
        return null;
    }

    /**
     * Este método obtiene todas las filas de la tabla
     * que cumplan con la restricción del where dada por
     * las columna column y sus respectivo valor value.
     *
     * SELECT * FROM Table WHERE column = value
     *
     * @param column nombre de la coluna por la cual se desea filtrar.
     * @param value valor para por el cual se desea filtrar.
     * @return lista de objetos que cumplen con la restricción definida.
     */
    public List filterBy(String column, Object value) {
        String query = "SELECT * FROM ";
        query += reader.getTableName();
        query += " WHERE ";
        query += column;
        query += " = " + value;
        System.out.println(query);
        return null;
    }

    /**
     * Este método elimina el object de la base de datos
     * 
     * DELETE * FROM Table WHERE columnas =  object
     *
     * @param object el objeto a eliminar
     */
    public void delete(Object object) {
        String query = "DELETE * FROM ";
        query += reader.getTableName();
        query += " WHERE ";
        int index = 0;
        for (String column : reader.getIdColumns()) {
            query += column;
            query += " = ?";

            index++;

            if (index < reader.getIdColumns().size()) {
                query += " AND ";
            }
        }
        System.out.println(query);

    }

    public void persist(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
