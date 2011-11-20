/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.mbaez.slam.examples;

import py.com.mbaez.slam.manager.*;
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
        DBManager<Tabla> dao = new DBManagerFactory(Tabla.class);

        //System.out.println(dao.getClass());
        Tabla t = new Tabla();
        String []params = {"5", "6"};
        dao.get(params);
        dao.listAll();
        dao.filterBy(params, params);
        dao.remove(t);
    }

}
