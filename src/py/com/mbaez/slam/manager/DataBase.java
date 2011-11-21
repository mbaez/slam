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

import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 */
public class DataBase {

    private SQLiteDatabase myDataBase = null;
    /**
     *
     * @param myDataBase
     */
    public DataBase(SQLiteDatabase myDataBase){
        this.myDataBase = myDataBase;
    }
    
    public DataBase(){
        
    }
    /**
     *
     * @param path
     * @return
     */
    public  SQLiteDatabase open(String path) {
        
        return open(path, SQLiteDatabase.OPEN_READWRITE);

    }
    /**
     *
     * @param path
     * @param openFlags
     * @return
     */
    public  SQLiteDatabase open(String path, int openFlags) {
        myDataBase = SQLiteDatabase.openDatabase(path, null,
                openFlags);

        return myDataBase;

    }

    public  SQLiteDatabase getMyDatabase(){
        return myDataBase;
    }

    public  synchronized void close(){
        if(myDataBase != null)
            myDataBase.close();
    }
}
