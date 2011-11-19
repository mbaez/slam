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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 * @version 1.0 20/10/2011
 */
public class Reflect {

    /**
     *Constructor de la clase reflect
     */
    public Reflect() {
    }

    /**
     *
     * Se obtien el nombre del atributo y se genera construye una cadena que
     * contiene el nombre del seter de dicho atributo. La cadena se construye de
     * la siguiente forma:
     *<p>
     * seterName = la cadena "set" + el primer caracter de fieldName en
     * mayusculas + los caracteres restantates de la cadena fieldName.
     *<p>
     * La construcción se realiza de esta respentando la nomenclatura camelCase.
     *
     * @param fieldName
     *            nombre del atributo
     * @return el nombre del metodo set para el atributo de nombre fieldName
     */
    private String getSeterName(String fieldName) {

        String seterName = "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
        return seterName;
    }

    /**
     *
     * Se obtien el nombre del atributo y se genera construye una cadena que
     * contiene el nombre del geter de dicho atributo. La cadena se construye de
     * la siguiente forma:
     *<p>
     * geterName = la cadena "get" + el primer caracter de fieldName en
     * mayusculas + los caracteres restantates de la cadena fieldName.
     *<p>
     * La construcción se realiza de esta respentando la nomenclatura camelCase.
     *
     * @param fieldName
     *            nombre del atributo
     * @return el nombre del metodo get para el atributo de nombre fieldName
     */
    private String getGeterName(String fieldName) {

        String geterName = "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
        return geterName;
    }

    /**
     * Este método se encarga de de invocar al metodo set del atributo field,
     * perteneciente a la clase clazz ,cuya instancia es instance y establecerle
     * el valor value.
     *
     * @param clazz
     *            clase de la cual se invocara su metodo methodName
     * @param instance
     *            objeto que representa una instancia de la clase clazz.
     * @param field
     *            atributo de la clase clazz.
     * @param value
     *            valor para el atributo a ser establecido a instance.
     * @param methodName
     *             el nombre del metodo a invocar.
     *
     * @return el resultado de invcar al metodo.
     *
     * @throws InstantiationException
     *             No se pudo crear una instancia de clazz
     * @throws IllegalAccessException
     *             No se posee acceso a la clase clazz
     * @throws NoSuchMethodException
     *             No se pudo obtener el seter del atributo
     * @throws SecurityException
     *             No se pueden obtener los atributos de la clase
     * @throws InvocationTargetException
     *             Ocurrio un problema al invocar al seter
     * @throws IllegalArgumentException
     *             El parametro para el seter es icompatible
     */
    private Object invokeMethod(Class clazz, Object instance, Class[] parametros,
            Object value, String methodName) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {

        // Se obtien la referencia del seter del atributo
        Method seter = clazz.getMethod(methodName, parametros);
        clazz.getMethod(methodName);
        // Se invoca al seter de la instancia correspondiente
        return seter.invoke(instance, value);
    }

    /**
     *
     * @param clazz
     * @param instance
     * @param methodName
     * @return
     */
    private Object invokeMethod(Class clazz, Object instance, String methodName)
            throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException {
        
        Method seter = clazz.getMethod(methodName);
        clazz.getMethod(methodName);
        return seter.invoke(instance);
    }

    /**
     * Este método se encarga de de invocar al metodo set del atributo field,
     * perteneciente a la clase clazz ,cuya instancia es instance y establecerle
     * el valor value.
     *
     * @param clazz
     *            clase de la cual se invocara su metodo el metodo set
     * @param instance
     *            objeto que representa una instancia de la clase clazz
     * @param field
     *            atributo de la clase clazz
     * @param value
     *            valor para el atributo a ser establecido a instance
     *
     * @throws SQLException
     *             No se encuentra la columna en rs
     * @throws InstantiationException
     *             No se pudo crear una instancia de clazz
     * @throws IllegalAccessException
     *             No se posee acceso a la clase clazz
     * @throws NoSuchMethodException
     *             No se pudo obtener el seter del atributo
     * @throws SecurityException
     *             No se pueden obtener los atributos de la clase
     * @throws InvocationTargetException
     *             Ocurrio un problema al invocar al seter
     * @throws IllegalArgumentException
     *             El parametro para el seter es icompatible
     */
    public void invokeSeter(Class clazz, Object instance, Field field,
            Object value) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {

        String seterName = getSeterName(field.getName());
        Class[] parametros = {field.getType()};
        invokeMethod(clazz, instance, parametros, value, seterName);
    }

    /**
     * Este método se encarga de de invocar al metodo get del atributo field,
     * perteneciente a la clase clazz ,cuya instancia es instance y establecerle
     * el valor value.
     *
     * @param clazz
     *            clase de la cual se invocara su metodo el metodo get
     * @param instance
     *            objeto que representa una instancia de la clase clazz
     * @param field
     *            atributo de la clase clazz
     * @return
     *            el valor para el atributo field
     *
     * @throws InstantiationException
     *             No se pudo crear una instancia de clazz
     * @throws IllegalAccessException
     *             No se posee acceso a la clase clazz
     * @throws NoSuchMethodException
     *             No se pudo obtener el seter del atributo
     * @throws SecurityException
     *             No se pueden obtener los atributos de la clase
     * @throws InvocationTargetException
     *             Ocurrio un problema al invocar al seter
     * @throws IllegalArgumentException
     *             El parametro para el seter es icompatible
     */
    public Object invokeGeter(Class clazz, Object instance, Field field) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {

        String geterName = getGeterName(field.getName());
        return invokeMethod(clazz, instance, geterName);
    }
}
