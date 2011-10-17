/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.mbaez.slam;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import py.com.mbaez.slam.annotation.*;

/**
 *
 * @author mbaez
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
