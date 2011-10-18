/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.mbaez.slam;

import py.com.mbaez.slam.dao.*;
/**
 *
 * @author mbaez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAOImpl dao = new DAOImpl(Tabla.class);
        String []params = {"5", "6"};
        dao.get(params);
        dao.listAll();
        //dao.delete(params);
    }

}
