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

import android.database.Cursor;
import java.util.List;
import py.com.mbaez.slam.QueryGenerator;
import py.com.mbaez.slam.Reader;
import py.com.mbaez.slam.Slam;

/**
 *
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 * @version 1.0 17/10/2011
 * @param <T>
 */
public class DBManagerFactory <T extends Object> implements DBManager<T> {

    private QueryGenerator generator;
    private Reader reader;
    /**
     * Constructor de la clase DBManagerFactory
     *
     * @param clazz 
     */
    public DBManagerFactory(Class<T> clazz) {
        System.out.println();
        generator = new QueryGenerator(clazz);
    }

    /**
     * @see DBManager#get(java.lang.Object)
     */
    public T get(Object id) {
        Object [] params = new Object[]{id};
        this.get(params);
        return null;
    }

    /**
     * @see DBManager#get(java.lang.Object[])
     */
    public T get(Object[] id) {
        //se filtran por las columnas que  son clave primaria
        String query = generator.selectFromPK();
        System.out.println(query);
        String params[]= new String[id.length];

        //System.arraycopy(id, 0, params, 0, id.length);

        //Cursor cursor = Slam.getDataBase().rawQuery(query, params);
        //System.out.println(cursor);

        return null;
    }

    /**
     * @see DBManager#listAll()
     */
    public List<T> listAll() {
        String query = generator.selectQuery();
        System.out.println(query);
        //Cursor cursor = Slam.getDataBase().rawQuery(query,null);
        //System.out.println(cursor);
        return null;
    }

    /**
     * @see DBManager#filterBy(java.lang.String[], java.lang.Object[])
     */
    public List<T> filterBy(String[] columns, Object[] values) {
        if (columns.length != values.length){
            //throw new Exception("");
        }
        String query = generator.selectQuery(columns);
        System.out.println(query);
        String params[]= new String[values.length];

        //System.arraycopy(values, 0, params, 0, values.length);
        //Cursor cursor = Slam.getDataBase().rawQuery(query, params);
        
        //System.out.println(cursor);
        return null;
    }

   /**
    * @see DBManager#filterBy(java.lang.String, java.lang.Object)
    */
    public List<T> filterBy(String column, Object value) {
        return filterBy(new String[]{column}, new Object[]{value});
    }

    /**
     * @see DBManager#remove(java.lang.Object)
     */
    public void remove(T entity) {
        String query = generator.deletQuery();
        System.out.println(query);

    }
    /**
     * @see DBManager#persist(java.lang.Object)
     */
    public void persist(T entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * @see DBManager#update(java.lang.Object)
     */
    public void update(T entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * @see DBManager#merge(java.lang.Object)
     */
    public <T> T merge(T entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see DBManager#refresh(java.lang.Object)
     */
    public void refresh(T entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * @see DBManager#close()
     */
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
