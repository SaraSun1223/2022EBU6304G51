package coursework.backend.dblayer;

import coursework.backend.model.Menu;
import java.io.IOException;
import java.util.ArrayList;

/*
 * This is a class of MenuManger.
 * @author: Jiayi Zhang
 * @date: 2022/05/01
 */

    public class MenuManager {

        public static Menu getPriceByMenuName(String MenuName) throws IOException{
            ArrayList <Menu> meals = DataManager.getInstance().meals;
            for (Menu s : meals){
                if(s.MenuName.equals(MenuName)){
                    return s;
                 }
            }
            return null;
        }

    public static void writeMenuInfo(Menu menu) throws IOException{
            ArrayList <Menu> meals = DataManager.getInstance().meals;
            for (int i=0; i< meals.size();i++){
                if (meals.get(i).MenuName.equals(menu.MenuName)){
                    meals.remove(i);
                    meals.add(menu);
                    DataManager.getInstance().commit();
                    return;
                }
            }
    }
}
