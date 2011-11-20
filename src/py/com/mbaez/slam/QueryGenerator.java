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

/**
 * Esta clase se encarga de generar las consultas sql.
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 * @version 1.0 18/11/2011
 */
public class QueryGenerator {
    /**
     * Querys Estandar 
     */
    private String DELETE = "DELETE * FROM ";
    private String SELECT = "SELECT * FROM ";
    private String WHERE = " WHERE ";
    private String AND = " AND ";
    /**
     * Utilizado para acceder a la informacion de las clases.
     */ 
    private Reader reader;
    /**
     * Constructor de la clase, se encarga de inicializar el Reader de 
     * clases.
     * @param clazz calse sobre la cual se trabajará.
     * @see {@link Reader}
     */ 
    public QueryGenerator(Class clazz){
        reader = new Reader(clazz);
    }
    
    /**
     * Este método genera un delete, donde se construyen los filtros
     * a partir de los N atriutos definidos con {@link Id}.
     * <p>
     * DELETE * FROM TABLE_NAME WHERE pk[1] = ? ... AND pk[N] = ? 
     * 
     * @return el query de delete generado.
     * @see #QueryGenerator(Class)
     * @see #deleteQuery(String[])
     */ 
    public String deletQuery(){
        String [] columns = new String[reader.getIdColumns().size()];
        //Se obtienen las columnas que son parte de la clave
        int index = 0;
        for (String column : reader.getIdColumns()){
            columns[index] = column;
            index++;
        }
        return deleteQuery(columns);
    }
    /**
     * Este método genera un delete, donde se construyen los filtros
     * a partir de los N columnas, columns.
     * <p>
     * DELETE * FROM TABLE_NAME WHERE columns[1] = ? ... AND columns[N] = ? 
     * @param columns columnas a partir de la cual se construirán los 
     *        filtros.
     * @return el query de delete generado.
     * @see #QueryGenerator(Class)
     * @see {@link Reader#getIdColumns()}
     */ 
    public String deleteQuery(String[] columns){
        String query = DELETE;
        query += reader.getTableName();
        query += WHERE;
        int index = 0;
        for (String column : columns) {
            query += column;
            query += " = ?";

            index++;
            //si el indice apunta es igual a la cantidad de
            //columnas no se debe añadir el AND
            if (index < columns.length) {
                query += AND;
            }
        }
        return query;
    }    
    /**
     * Este metodo genera un select, donde se construyen los filtros
     * a partir de los N atriutos definidos con {@link Id} .
     * <p>
     * SELECT * FROM TABLE_NAME WHERE pk[1] = ? ... AND pk[N] = ? 
     * 
     * @return el query generado
     * @see #selectQuery(String [])
     * @see {@link Reader#getIdColumns()}
     */ 
    public String selectFromPK(){
        String [] columns = new String[reader.getIdColumns().size()];
        //Se obtienen las columnas que son parte de la clave
        int index = 0;
        for (String column : reader.getIdColumns()){
            //Los nombre de las columnas son cargados como string
            columns[index] = column;
            index++;
        }
        return selectQuery(columns);
    }
    /**
     * Este método genera un select básico, con el nombre de la tabla
     * obtneido de la clase definida en el constructor. 
     * <p>
     * SELECT * FROM TABLE_NAME
     * 
     * @return el query generado.
     * @see #QueryGenerator(Class)
     * @see {@link ReaderReader#getTableName()}
     */ 
    public String selectQuery(){
        String query = SELECT;
        query += reader.getTableName();
        //System.out.println(query);
        return query;
    }
    
    /**
     * Este método genera un select con los filtros definidos en la 
     * clausula del WHERE construidas por las columnas N, columns,
     * especificadas, de la siguiente forma:
     * <p>
     * SELECT * FROM TABLE_NAME WHERE column[1] = ? ... AND column[N] = ? 
     * 
     * @return el query generado
     * @see #selectQuery()
     */ 
    public String selectQuery(String[] columns){
        String query = selectQuery();
        query += WHERE;
        int index = 0;
        for (String column : columns) {
            query += column;
            query += " = ? "; 
            
            index++;
            if (index < columns.length) {
                query += AND;
            }
        }
        return query;
    }
    

}
