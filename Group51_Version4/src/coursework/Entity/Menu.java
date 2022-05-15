package coursework.Entity;
/*
 * This class is for payment of meals.It includes all attributes for Menu entity.
 * It is for system to compute the total price of the ordered meals.
 * @ClassName Menu
 * @author Jiayi Zhang
 * @version 3.0
 * @date 2022/04/30
 */


public class Menu {
    private String MenuName;
    private double MenuPrice;

    public void setMenuName(String MenuName){
        this.MenuName = MenuName;
    }
    public String getMenuName(){
        return MenuName;
    }

    public void setMenuPrice(double MenuPrice){
        this.MenuPrice = MenuPrice;
    }
    public double getMenuPrice() {
        return MenuPrice;
    }

    public Menu(String MenuName, double MenuPrice){
        this.MenuName = MenuName;
        this.MenuPrice = MenuPrice;
    }

    public String toString(){
        return "Menu{" +
                "MenuName='" + MenuName + '\''+
                ", MenuPrice='" + MenuPrice +'\''+
                '}';
    }

    public coursework.backend.model.Menu converter(){
        coursework.backend.model.Menu menu = new coursework.backend.model.Menu();
        menu.MenuName = this.MenuName;
        menu.MenuPrice = this.MenuPrice;

        return menu;
    }
}
