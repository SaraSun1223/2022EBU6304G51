package coursework.backend.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * class for Staff
 * @author Yian Zhang
 * @version 5.3
 */
public class Staff {

    @JSONField(name = "staffid")
    public String staffid;

    @JSONField(name = "password")
    public String password;


    public coursework.Entity.Staff converter() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String expireDateF = sdf.format(this.expireDate);
        return new coursework.Entity.Staff(this.staffid,this.password);
    }
}
