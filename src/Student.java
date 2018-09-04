
import javafx.beans.property.SimpleStringProperty;
public  class Student {
 
        private final SimpleStringProperty sno;
        private final SimpleStringProperty name;
        private final SimpleStringProperty age;
        private final SimpleStringProperty sex;
        private final SimpleStringProperty sdept;
 
        Student(String _sno, String _name, String _age,String _sex,String _sdept) {
            this.sno = new SimpleStringProperty(_sno);
           this.name = new SimpleStringProperty(_name);
            this.age = new SimpleStringProperty(_age);
             this.sex = new SimpleStringProperty(_sex);
              this.sdept = new SimpleStringProperty(_sdept);
        }
 
        public String getSno() {
            return sno.get();
        }
 
        public void setFirstName(String _sno) {
           sno.set(_sno);
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setName(String _name) {
           name.set(_name);
        }
 
        public String getAge() {
            return age.get();
        }
 
        public void setAge(String _age) {
            age.set(_age);
        }
        
          public String getSex() {
            return sex.get();
        }
 
        public void setSex(String _sex) {
            sex.set(_sex);
        }
        
          public String getSdept() {
            return sdept.get();
        }
 
        public void setSdept(String _sdept) {
           sdept.set(_sdept);
        }
    }