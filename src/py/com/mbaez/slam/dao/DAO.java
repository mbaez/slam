/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.mbaez.slam.dao;
import java.util.List;
/**
 *
 * @author mbaez
 */
public interface DAO {
    
    public Object get(Object id);
    public Object get(Object [] id);

    public List<Object> listAll();
    public List<Object> filterBy(String []columns, Object []values);
    public List<Object> filterBy(String column, Object value);

    public void delete(Object object);
    public void persist(Object object);
    public void update(Object object);
}
