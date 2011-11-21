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
package py.com.mbaez.slam.manager;

import java.util.List;

/**
 *
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 * @param <T>
 */
public interface DBManager<T extends Object> {

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
    public T get(Object id);

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
    public T get(Object[] id);

    /**
     * Este método obtiene todas las filas de la tabla.
     * SELECT * FROM Table
     *
     * @return lista de objetos
     */
    public List<T> listAll();

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
    public List<T> filterBy(String[] columns, Object[] values);

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
    public List<T> filterBy(String column, Object value);

    /**
     * Este método elimina el entity de la base de datos
     *
     * DELETE * FROM Table WHERE columnas =  entity
     *
     * @param entity el objeto a eliminar
     */
    public void remove(T entity);

    /**
     * Saves (persists) an entity into the database, and also makes the
     * entity managed.
     */
    public void persist(T entity);

    public void update(T entity);

    /**
     * Merges an entity to the EntityManager’s persistence context and 
     * returns the merged entity.
     */
    public <T> T merge(T entity);

    /**
     * Refreshes (resets) the entity from the database.
     */
    public void refresh(T entity);

    /**
     * Closes an application-managed EntityManager.
     */
    public void close();
}
