/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package py.com.mbaez.slam.dao;

import java.util.List;
import py.com.mbaez.slam.Reader;

/**
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 * @version 1.0 17/10/2011
 */
public class DAOImpl implements DAO {

    private Class clazz;
    private QueryGenerator generator;
    private Reader reader;
    /**
     * Constructor de la clase DAOImpl
     * @param clazz 
     */
    public DAOImpl(Class<?> clazz) {
        this.clazz = clazz;
        generator = QueryGenerator(this.clazz);
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
        //se filtran por las columnas que  son clave primaria
        this.filterBy(columns, id);
        return null;
    }

    /**
     * Este método obtiene todas las filas de la tabla.
     * SELECT * FROM Table
     *
     * @return lista de objetos
     */
    public List<Object> listAll() {
        String query = generator.selectQuery();
        System.out.println(query);
        return null;
    }

    /**
     * Este método obtiene todas las filas de la tabla
     * que cumplan con la restricción del where dada por
     * las columnas column y sus respectivos valores value.
     * <p>
     * SELECT * FROM Table WHERE column1 = value1 AND column2 = value2 ...
     *
     * @param column nombre de la coluna por la cual se desea filtrar.
     * @param value valor para por el cual se desea filtrar.
     * @return lista de objetos que cumplen con la restricción definida.
     */
    public List filterBy(String[] columns, Object[] values) {
        if (columns.length != values.length){
            throws new Exception("");
        }
        String query = generator.selectQuery(colums);
        System.out.println(query);
        //cursor = myDataBase.rawQuery(query, values);
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
     * @see #filterBy(String[], Object[])
     */
    public List filterBy(String column, Object value) {
        return filterBy(new String[]{column}, new Object[]{value});
    }

    /**
     * Este método elimina el object de la base de datos
     * 
     * DELETE * FROM Table WHERE columnas =  object
     *
     * @param object el objeto a eliminar
     */
    public void delete(Object object) {
        String query = generator.deletQuery()
        System.out.println(query);

    }

    public void persist(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
