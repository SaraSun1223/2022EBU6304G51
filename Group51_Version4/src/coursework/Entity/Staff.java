package coursework.Entity;

public class Staff {
    private String staffid;
    private String password;


    public String getStaffid(){
    return staffid;
    }

    public void setStaffid(String staffid){
    this.staffid=staffid;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }


    public Staff(String staffid, String password){
        this.staffid=staffid;
        this.password=password;
    }

    
    @Override
    public String toString(){
        return "Staff{" +
                "staffid='" + staffid + '\'' +
                ", password='" + password +'\''+
                '}';
    }

    public coursework.backend.model.Staff convert()
    {
        coursework.backend.model.Staff staff = new coursework.backend.model.Staff();
        staff.staffid = this.staffid;
        staff.password = this.password;

        return staff;
    }

}




