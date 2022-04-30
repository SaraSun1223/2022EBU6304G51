package coursework.backend.model;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

/*
 * This is a class for Menu.
 * @author Jiayi Zhang
 * @Date 2022-4-30
 */

import com.alibaba.fastjson.annotation.JSONField;

public class Menu {
    @JSONField(name = "MenuName")
        public String MenuName;

    @JSONField(name = "MenuPrice")
        public double MenuPrice;

    public coursework.Entity.Menu converter(){
        return new coursework.Entity.Menu(this.MenuName, this.MenuPrice);
    }
}
