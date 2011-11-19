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
package py.com.mbaez.slam;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import py.com.mbaez.slam.annotation.*;
import py.com.mbaez.slam.annotation.Column;
import py.com.mbaez.slam.annotation.Id;
import py.com.mbaez.slam.annotation.Table;

/**
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 * @version 1.0 17/10/2011
 */
public class Reader {

    private Class clazz;
    private Field[] fields;
    private List<String> idColumns = null;
    private String tableName = null;

    public Reader(Class clazz) {
        this.clazz = clazz;
        this.fields = clazz.getDeclaredFields();
        idColumns = null;
        tableName = null;
    }

    /**
     * Este método obtiene la lista de los atributos
     * anotados con Id y de estos atributos se otiene el nombre de
     * la columna.
     *
     * @return lista de columnas anotadas con Id
     *
     * @see Column
     * @see Id
     */
    public List<String> getIdColumns() {
        if (idColumns == null) {
            idColumns = new ArrayList<String>();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Id.class)) {
                    idColumns.add(field.getAnnotation(Column.class).name());
                }
            }
        }
        return idColumns;
    }

    /**
     * Este método retorna el nombre de la tabla de la clase que se
     * encuentra anotada con Table.
     * 
     * @return el nombre de la tabla
     * 
     * @see Table
     */
    public String getTableName() {
        if(tableName == null){
        //se verifica si la clase esta anotada con @Table
            if (clazz.isAnnotationPresent(Table.class)) {
                //se retorna el el nombre de la tabla
                tableName = ((Table) clazz.getAnnotation(Table.class)).name();
            }
        }
        return tableName;
    }
}
