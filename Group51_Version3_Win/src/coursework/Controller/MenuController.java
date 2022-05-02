package coursework.Controller;

import coursework.Entity.*;
import coursework.backend.dblayer.MenuManager;
import java.util.ArrayList;
import java.util.Objects;

public class MenuController implements MenuUtils{
    private static final MenuController menuController = new MenuController();
    private MenuController(){

    }
    ;
    public static MenuController getMenuController(){
        return menuController;
    }

     public Menu getPriceByMenuName(String MenuName){
        try{
            return Objects.requireNonNull(MenuManager.getPriceByMenuName(MenuName)).converter();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
     }


}
