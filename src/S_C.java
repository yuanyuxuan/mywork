
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wolf
 */
public class S_C {
    private final SimpleStringProperty sno;
    private final SimpleStringProperty ssname;
    private final SimpleStringProperty cno;
    private final SimpleStringProperty cname;
    private final SimpleStringProperty sgrade;
    S_C(String no1,String name_1,String no,String name,String grade){
        sno=new SimpleStringProperty(no1);
       ssname=new SimpleStringProperty(name_1);
        cno=new SimpleStringProperty(no);
        cname=new SimpleStringProperty(name);
        sgrade=new SimpleStringProperty(grade);
    }
    public String getSno()
    {
        return sno.get();
    }
    public String getSsname()
    {
        return ssname.get();
    }
    public String getCno(){
        return cno.get();
    }
    public String getCname(){
        return cname.get();
    }
    public String getSgrade(){
        return sgrade.get();
    }
    public void setSno(String no1)
    {
        sno.set(no1);
    }
    public void setSsname(String name1)
    {
        ssname.set(name1);
    }
    public void setCno(String no){
        cno.set(no);
    }
    public void setCname(String name){
        cname.set(name);
    }
    public void setSgrade(String dept){
        sgrade.set(dept);
    }
}
