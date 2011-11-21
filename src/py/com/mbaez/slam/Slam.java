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

import android.database.sqlite.SQLiteDatabase;
import py.com.mbaez.slam.manager.DataBase;

/**
 *
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 */
public class Slam {
    
    private static DataBase database;

    //public abstract static init();
    public static void init(String dbPath){
        init(dbPath, true);
    }
    public static void init(String dbPath, boolean open){
        database = new DataBase();
        if(open)
            database.open(dbPath);
    }
    
    public static void init(SQLiteDatabase myDataBase){
        database =  new DataBase(myDataBase);
    }
    
    public static SQLiteDatabase getDataBase(){
        return database.getMyDatabase();
    }
    
}
