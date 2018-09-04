/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author wolf
 */
public class Course {
    private final SimpleStringProperty cno;
    private final SimpleStringProperty cname;
    private final SimpleStringProperty cdept;
    Course(String no,String name,String dept){
        cno=new SimpleStringProperty(no);
        cname=new SimpleStringProperty(name);
        cdept=new SimpleStringProperty(dept);
    }
    public String getCno(){
        return cno.get();
    }
    public String getCname(){
        return cname.get();
    }
    public String getCdept(){
        return cdept.get();
    }
    public void setCno(String no){
        cno.set(no);
    }
    public void setCname(String name){
        cname.set(name);
    }
    public void setCdept(String dept){
        cdept.set(dept);
    }
}
