import javafx.application.Application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 *
 * @author wolf
 */

public class RealWork extends Application{
    public void start(Stage primaryStage)
    {
         /*String url="jdbc:mysql://localhost:3306/workplace";
         String driverName="com.mysql.jdbc.Driver";
         String username="Wolf";
         String password="yuan2439115241";*/
        BorderPane pane=new BorderPane();
        MainPane MAINPANE=new MainPane();
        StudentPane STUDENTPANE=new StudentPane();
        CoursePane COURSEPANE=new CoursePane();
        ScPane SCPANE=new ScPane();       
        
        pane.setCenter(MainPane.mainpane);
        Scene scene=new Scene(pane,780,580);
        primaryStage.setTitle("学生信息管理");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
      launch(args);
      
    }
    
}

/**
 *
 * @author wolf
 */

class MainPane
{
    static StackPane mainpane=new StackPane();
    public MainPane(){
       SignPane panesign=new SignPane();
        MenuPane panemenu=new MenuPane();
        mainpane.getChildren().addAll(SignPane.signpane,MenuPane.Rpane);
        MenuPane.Rpane.setVisible(false);
    }
}
class SignPane
{
     public static BorderPane signpane=new BorderPane();
     public static GridPane dpane=new GridPane();
    public SignPane(){
           /* RadioButton rb1=new RadioButton("管理员");
            RadioButton rb2=new RadioButton("学生");
            ToggleGroup group=new ToggleGroup();
            rb1.setToggleGroup(group);
            rb2.setToggleGroup(group);*/
            dpane.setAlignment(Pos.CENTER);
            dpane.setHgap(5.5);
            dpane.setVgap(5.5);
            /*dpane.add(rb1,0,0);
            dpane.add(rb2,1,0);*/
            TextField asscount=new TextField();
            dpane.add(new Label("用户名:"),0,1);
            dpane.add(asscount,1,1);
            PasswordField password=new PasswordField();
            dpane.add(new Label("密  码:"),0,2);
            dpane.add(password,1,2);
            Button btSign=new Button("登录");
            dpane.add(btSign,1,4);           
            GridPane.setHalignment(btSign,HPos.RIGHT);
           dpane.setMaxHeight(150);
           dpane.setMaxWidth(250);
            dpane.setStyle("-fx-border-style:solid;-fx-background-color:#EEE8AA;-fx-border-color:#5F9EA0;");
            signpane.setStyle("-fx-background-image:url(\"01.jpg\")");
            signpane.setCenter(dpane);
            signpane.setAlignment(dpane,Pos.CENTER_LEFT);
            signpane.setPadding(new Insets(15,0,0,150));
            btSign.setOnAction(e->{
                //if(checkuser(asscount.getText(),password.getText())>0)
            	if(true)
                {
                    asscount.setText("");
                    password.setText("");
                    signpane.setVisible(false);
                    MenuPane.Rpane.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "登录失败请检查用户名和密码", "错误", JOptionPane.INFORMATION_MESSAGE); 
                }
            });
           
      }
    int checkuser(String uname,String upass){
    String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String susername="Wolf";
    String spassword="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, susername, spassword);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.userinformation WHERE username='"+uname+"';");
    result.next();
   System.out.println(result.getString(1)+"\t"+result.getString(2));
    if(upass.equalsIgnoreCase(result.getString(2)))
    {
        conn.close();
        System.out.println("登录成功");
        return 1;
    }   
    else
    { 
        conn.close();
        System.out.println("登录失败");
        return 0;
    }
    }catch(Exception f){
        System.out.println("连接失败");
       return 0;
    }   
  
    //return true;
    }
}

class MenuPane 
{
    public static BorderPane Rpane=new BorderPane();
    public static StackPane Spane=new StackPane();
    public MenuPane(){
        ImageView image=new ImageView("05.jpg");
        Rpane.setTop(image);
        Rpane.setCenter(Spane);
         VBox vbox=new VBox();
        Label label=new Label();
        label.setText("学生信息");
         label.setFont(Font.font(20));
        
          Label labela=new Label();
        labela.setText("新增");
         labela.setFont(Font.font(20));
          labela.setTextFill(Color.BLUE);
        
          Label labelb=new Label();
        labelb.setText("修改");
         labelb.setFont(Font.font(20));
          labelb.setTextFill(Color.BLUE);
       
          Label labelc=new Label();
        labelc.setText("查询");
         labelc.setFont(Font.font(20));
          labelc.setTextFill(Color.BLUE);
       
            Label labele=new Label();
        labele.setText("浏览");
         labele.setFont(Font.font(20));
          labele.setTextFill(Color.BLUE);
          
          Label labeld=new Label();
        labeld.setText("删除");
         labeld.setFont(Font.font(20));
          labeld.setTextFill(Color.BLUE);
       
        Label label1=new Label();
        label1.setText("课程信息");
        label1.setFont(Font.font(20));
       
         Label label1a=new Label();
        label1a.setText("新增");
         label1a.setFont(Font.font(20));
          label1a.setTextFill(Color.BLUE);
     
          Label label1b=new Label();
        label1b.setText("修改");
         label1b.setFont(Font.font(20));
          label1b.setTextFill(Color.BLUE);
      
          Label label1c=new Label();
        label1c.setText("查询");
         label1c.setFont(Font.font(20));
         label1c.setTextFill(Color.BLUE);
         
              Label label1e=new Label();
        label1e.setText("浏览");
         label1e.setFont(Font.font(20));
          label1e.setTextFill(Color.BLUE);
      
          Label label1d=new Label();
        label1d.setText("删除");
         label1d.setFont(Font.font(20));
          label1d.setTextFill(Color.BLUE);

        Label label2=new Label();
        label2.setText("成绩信息");
        label2.setFont(Font.font(20));
       
         Label label2a=new Label();
        label2a.setText("查询");
         label2a.setFont(Font.font(20));
          label2a.setTextFill(Color.BLUE);
        label2a.setOnMouseClicked(e->{
           
        });
          Label label2b=new Label();
        label2b.setText("新增");
         label2b.setFont(Font.font(20));
          label2b.setTextFill(Color.BLUE);
        label2b.setOnMouseClicked(e->{
           
        });
          Label label2c=new Label();
        label2c.setText("修改");
         label2c.setFont(Font.font(20));
          label2c.setTextFill(Color.BLUE);
        label2c.setOnMouseClicked(e->{
           
        });
         
        CalendarPane cpane=new CalendarPane();
        HBox hbb=new HBox();
        hbb.setMaxSize(600, 350);
        hbb.getChildren().add(cpane);
        hbb.setAlignment(Pos.CENTER);
            Label label6=new Label();
      label6.setText("日历");
      label6.setFont(Font.font(20));
      label6.setOnMouseClicked(e->{
          Spane.getChildren().remove(0, Spane.getChildren().size());
          Spane.getChildren().addAll(hbb);
      });
      
        Label label2d=new Label();
        label2d.setText("浏览");
         label2d.setFont(Font.font(20));
       
        Label label3=new Label();
        label3.setText("注销");
        label3.setFont(Font.font(20));
      Label label4=new Label();
      label4.setText("退出");
      label4.setFont(Font.font(20));
      label4.setOnMouseClicked(e->{
         System.exit(0); 
      });
        vbox.getChildren().addAll(label,label1,label2,label6,label3,label4);
        vbox.setSpacing(8);
      
        Rpane.setLeft(vbox);
        
        vbox.setPadding(new Insets(30,20,0,20));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setStyle("-fx-border-color:#48D1CC;");
         Label label5=new Label();
       label5.setText("欢迎使用");
       label5.setTextFill(Color.GRAY);
       label5.setFont(Font.font(40));
       
        label.setOnMouseClicked(e->{
             Spane.getChildren().remove(0, Spane.getChildren().size());
              Spane.getChildren().addAll(label5,StudentPane.studentpane);
             StudentPane.studentpane.setVisible(false);
            label5.setVisible(true);
           vbox.getChildren().remove(0, vbox.getChildren().size());
           vbox.getChildren().addAll(label,labela,labelb,labele,labelc,labeld,label1,label2,label6,label3,label4);
           
        });
        
         label1.setOnMouseClicked(e->{
             Spane.getChildren().remove(0, Spane.getChildren().size());
               Spane.getChildren().addAll(label5,CoursePane.coursepane);
                CoursePane.coursepane.setVisible(false);
                label5.setVisible(true);
          vbox.getChildren().remove(0, vbox.getChildren().size());
           vbox.getChildren().addAll(label,label1,label1a,label1b,label1e,label1c,label1d,label2,label6,label3,label4);
        });
         
          label2.setOnMouseClicked(e->{
                Spane.getChildren().remove(0, Spane.getChildren().size());
              Spane.getChildren().addAll(label5,ScPane.spane);
        ScPane.spane.setVisible(false);
       label5.setVisible(true);
              vbox.getChildren().remove(0, vbox.getChildren().size());
           vbox.getChildren().addAll(label,label1,label2,label2a,label2b,label2c,label2d,label6,label3,label4);
        });
        
        label3.setOnMouseClicked(e->{
            MenuPane.Rpane.setVisible(false);
            SignPane.signpane.setVisible(true);
             vbox.getChildren().remove(0, vbox.getChildren().size());
             vbox.getChildren().addAll(label,label1,label2,label6,label3,label4);
              StudentPane.studentpane.setVisible(false);
             label5.setVisible(true);
             Spane.getChildren().remove(0,Spane.getChildren().size());
             Spane.getChildren().addAll(StudentPane.studentpane,label5);
            
        });
        
      
       Spane.getChildren().addAll(label5,StudentPane.studentpane);
       StudentPane.studentpane.setVisible(false);
       StudentPane.studentpane.getChildren().add(StudentPane.addpane);
       CoursePane.coursepane.getChildren().add(CoursePane.checkpane);
       ScPane.spane.getChildren().add(ScPane.addpane);
       labela.setOnMouseClicked(e->{
          label5.setVisible(false);
          StudentPane.studentpane.setVisible(true);
          StudentPane.studentpane.getChildren().remove(0);
          StudentPane.studentpane.getChildren().add(StudentPane.addpane);
        });
       labelb.setOnMouseClicked(e->{
             label5.setVisible(false);
          StudentPane.studentpane.setVisible(true);
          StudentPane.studentpane.getChildren().remove(0);
          StudentPane.studentpane.getChildren().add(StudentPane.updatepane);
       });
        label1b.setOnMouseClicked(e->{
           label5.setVisible(false);
          CoursePane.coursepane.setVisible(true);
           CoursePane.coursepane.getChildren().remove(0);
          CoursePane.coursepane.getChildren().add(CoursePane.updatepane);
       });
       labelc.setOnMouseClicked(e->{
           label5.setVisible(false);
            StudentPane.studentpane.setVisible(true);
          StudentPane.studentpane.getChildren().remove(0);
          StudentPane.studentpane.getChildren().add(StudentPane.checkpane);
       });
       labele.setOnMouseClicked(e->{ 
          label5.setVisible(false);
          StudentPane.studentpane.setVisible(true);
          StudentPane.studentpane.getChildren().remove(0);
          StudentPane.studentpane.getChildren().add(StudentPane.tablebox);
           StudentPane.list.remove(0, StudentPane.list.size());
            String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";    
        try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.student;");    
   while( result.next())
   {
        Student s=new Student(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
    StudentPane.list.add(s);
   }
        conn.close();
        }catch(Exception f){
      System.out.println("异常");
    }
       
        StudentPane.table.setEditable(true);
        StudentPane.table.setItems(StudentPane.list);
        
       });
        
       label1a.setOnMouseClicked(e->{
          label5.setVisible(false);
        CoursePane.coursepane.setVisible(true);
           CoursePane.coursepane.getChildren().remove(0);
          CoursePane.coursepane.getChildren().add(CoursePane.addpane);
        });
        label1e.setOnMouseClicked(e->{
          label5.setVisible(false);
        CoursePane.coursepane.setVisible(true);
           CoursePane.coursepane.getChildren().remove(0);
          CoursePane.coursepane.getChildren().add(CoursePane.tablebox);
            String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";    
    CoursePane.list.remove(0, CoursePane.list.size());
        try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.course;");    
   while( result.next())
   {
        Course s=new Course(result.getString(1),result.getString(2),result.getString(3));
    CoursePane.list.add(s);
   }
        conn.close();
        }catch(Exception f){
      System.out.println("异常");
    }
        CoursePane.table.setEditable(true);
        CoursePane.table.setItems(CoursePane.list);
        });
       label1c.setOnMouseClicked(e->{
           label5.setVisible(false);
          CoursePane.coursepane.setVisible(true);
           CoursePane.coursepane.getChildren().remove(0);
          CoursePane.coursepane.getChildren().add(CoursePane.checkpane);
       });
        label1d.setOnMouseClicked(e->{
           label5.setVisible(false);
          CoursePane.coursepane.setVisible(true);
           CoursePane.coursepane.getChildren().remove(0);
          CoursePane.coursepane.getChildren().add(CoursePane.deletepane);
       });
        labeld.setOnMouseClicked(e->{
           label5.setVisible(false);
            StudentPane.studentpane.setVisible(true);
          StudentPane.studentpane.getChildren().remove(0);
          StudentPane.studentpane.getChildren().add(StudentPane.deletepane);
       });
        label2b.setOnMouseClicked(e->{ 
           label5.setVisible(false);
           ScPane.spane.setVisible(true);
           ScPane.spane.getChildren().remove(0);
           ScPane.spane.getChildren().add(ScPane.addpane);
        });
       label2a.setOnMouseClicked(e->{ 
           label5.setVisible(false);
           ScPane.spane.setVisible(true);
           ScPane.spane.getChildren().remove(0);
           ScPane.spane.getChildren().add(ScPane.checkpane);
        });
        label2c.setOnMouseClicked(e->{ 
           label5.setVisible(false);
           ScPane.spane.setVisible(true);
           ScPane.spane.getChildren().remove(0);
           ScPane.spane.getChildren().add(ScPane.updatepane);
        });
        label2d.setTextFill(Color.BLUE);
       label2d.setOnMouseClicked(e->{
            label5.setVisible(false);
          ScPane.spane.setVisible(true);
          ScPane.spane.getChildren().remove(0);
          ScPane.spane.getChildren().add(ScPane.tablebox);
           ScPane.list.remove(0, ScPane.list.size());
            String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";    
        try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT sc.sno,student.sname,sc.cno,course.cname,grade FROM student,course,sc where student.sno=sc.sno and course.cno=sc.cno;");    
    
   while( result.next())
   {
       S_C s=new S_C(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
       System.out.println(result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5));
    ScPane.list.add(s);
   }
        conn.close();
        }catch(Exception f){
      System.out.println("异常");
    }
       
        StudentPane.table.setEditable(true);
        StudentPane.table.setItems(StudentPane.list);
        
        });
    }
}
class StudentPane{
   static StackPane studentpane=new StackPane();
   static GridPane addpane=new GridPane();
   static BorderPane checkpane=new BorderPane();
   static BorderPane deletepane=new BorderPane();
   static GridPane deletelook=new GridPane();
   static GridPane deletelook2=new GridPane();
   static GridPane checklook=new GridPane();
   static GridPane checklook2=new GridPane();
   static BorderPane updatepane=new BorderPane();
    static BorderPane tablebox=new BorderPane();
    static ObservableList list=FXCollections.<Student>observableArrayList();  
       static   TableView<Student> table = new TableView<>();
    public StudentPane(){
        {            
      TableColumn col1=new TableColumn("学号");
      TableColumn col2=new TableColumn("姓名");
      TableColumn col3=new TableColumn("性别");
      TableColumn col4=new TableColumn("年龄");
      TableColumn col5=new TableColumn("系别");   
        col1.setMinWidth(100);
        col1.setCellValueFactory(new PropertyValueFactory<Student,String>("sno"));
        col2.setMinWidth(100);
         col2.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
         col3.setMinWidth(100);
          col3.setCellValueFactory(new PropertyValueFactory<Student,String>("age"));
          col4.setMinWidth(100);
           col4.setCellValueFactory(new PropertyValueFactory<Student,String>("sex"));
           col5.setMinWidth(100);
            col5.setCellValueFactory(new PropertyValueFactory<Student,String>("sdept"));
            table.setItems(list);
            table.getColumns().addAll(col1,col2,col3,col4,col5);            
          HBox hb=new HBox();
          hb.getChildren().add(table);
            tablebox.setCenter(hb);
            tablebox.setPadding(new Insets(10,15,10,75));
        }
        
        {
        Label label=new Label("\t新增学生信息");
        label.setFont(Font.font(20));
        Label label0=new Label();
        label0.setText("学号:");
        TextField textfield0=new TextField();
         Label label1=new Label();
        label1.setText("姓名:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("性别:");
        TextField textfield2=new TextField();
         Label label3=new Label();
        label3.setText("年龄:");
        TextField textfield3=new TextField();
         Label label4=new Label();
        label4.setText("系别:");
        TextField textfield4=new TextField();
        addpane.add(label0, 1, 2);
        addpane.add(textfield0,3,2);
        addpane.add(label1, 1, 3);
        addpane.add(textfield1,3,3);
        addpane.add(label2, 1, 4);
        addpane.add(textfield2,3,4);
        addpane.add(label3, 1, 5);
        addpane.add(textfield3,3,5);
        addpane.add(label4, 1, 6);
        addpane.add(textfield4,3,6);
        addpane.add(label,0,0,5,1);
        label.setAlignment(Pos.TOP_RIGHT);
       // studentpane.getChildren().add(addpane);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
        label3.setFont(Font.font(12));
        label4.setFont(Font.font(12));
        textfield0.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
        textfield3.setFont(Font.font(12));
        textfield4.setFont(Font.font(12));
        addpane.setPadding(new Insets(0,20,10,20));
        addpane.setVgap(10);
        addpane.setHgap(8);
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        addpane.add(hbox,3,8);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        addpane.setAlignment(Pos.CENTER);
        btok.setOnAction(e->{
            if(textfield0.getText().isEmpty()||textfield1.getText().isEmpty()||textfield2.getText().isEmpty()||textfield3.getText().isEmpty()||textfield4.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null,"请输入全部信息", "错误", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                 String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   state.executeUpdate("INSERT INTO student values('"+ textfield0.getText()+"','"+ textfield1.getText()+"','"+ textfield2.getText()+"','"+ textfield3.getText()+"','"+ textfield4.getText()+"')");
   JOptionPane.showMessageDialog(null,"录入成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception k){
      System.out.println("异常3");
    }
            }
        });
        btof.setOnAction(e->{ 
            textfield0.setText("");
             textfield1.setText("");
              textfield2.setText("");
               textfield3.setText("");
                textfield4.setText("");
        });
    }
        {
           Label label=new Label("\t查询学生信息");
        label.setFont(Font.font(20));
        Label labelname=new Label("学号");
        TextField textfieldname=new TextField();
        labelname.setFont(Font.font(12));
        textfieldname.setFont(Font.font(12));
        checklook.add(label, 0, 0,2,1);
        checklook.add(labelname, 0, 1);
        checklook.add(textfieldname,1,1);
        checklook.setHgap(15);
        checklook.setVgap(20);
        checklook.setAlignment(Pos.CENTER);
        checklook.setPadding(new Insets(70,10,10,10));
        checkpane.setTop(checklook);  
        Label label0=new Label();
        label0.setText("学号:");
        TextField textfield0=new TextField();
        textfield0.setEditable(false);
         Label label1=new Label();
        label1.setText("姓名:");
        TextField textfield1=new TextField();
        textfield1.setEditable(false);
         Label label2=new Label();
        label2.setText("性别:");
        TextField textfield2=new TextField();
                textfield2.setEditable(false);
         Label label3=new Label();
        label3.setText("年龄:");
        TextField textfield3=new TextField();
                textfield3.setEditable(false);
         Label label4=new Label();
        label4.setText("系别:");
        TextField textfield4=new TextField();
                textfield4.setEditable(false);
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
        label3.setFont(Font.font(12));
        label4.setFont(Font.font(12));
        textfield0.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
        textfield3.setFont(Font.font(12));
        textfield4.setFont(Font.font(12));
        Button btok=new Button("确定");
        Button btof=new Button("取消");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        checklook2.add(label0, 0, 0);
        checklook2.add(label1, 0, 1);
        checklook2.add(label2, 0, 2);
        checklook2.add(label3, 0, 3);
        checklook2.add(label4, 0, 4);
        checklook2.add(textfield0, 1, 0);
        checklook2.add(textfield1, 1, 1);
        checklook2.add(textfield2, 1, 2);
        checklook2.add(textfield3, 1, 3);
        checklook2.add(textfield4, 1, 4);
        checklook2.setAlignment(Pos.TOP_CENTER);
        checkpane.setCenter(checklook2);
        checklook2.setHgap(10);
        checklook2.setVgap(10);
        checklook2.setPadding(new Insets(30,10,8,10));
        //studentpane.getChildren().add(checkpane);
        textfieldname.setOnAction(e->{
             String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.student where sno='"+textfieldname.getText()+"'");
    result.next();
    System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
    textfield0.setText(result.getString(1));
    textfield1.setText(result.getString(2));
    textfield2.setText(result.getString(3));
    textfield3.setText(result.getString(4));
    textfield4.setText(result.getString(5));
    conn.close();
    }catch(Exception x){
      System.out.println("异常");
    }
        });
        }
        {
           Label label=new Label("\t删除学生信息");
        label.setFont(Font.font(20));
        Label labelname=new Label("学号");
        TextField textfieldname=new TextField();
        labelname.setFont(Font.font(12));
        textfieldname.setFont(Font.font(12));
        deletelook.add(label, 0, 0,2,1);
        deletelook.add(labelname, 0, 1);
        deletelook.add(textfieldname,1,1);
        deletelook.setHgap(15);
        deletelook.setVgap(20);
        deletelook.setAlignment(Pos.CENTER);
        deletelook.setPadding(new Insets(70,10,10,10));
        deletepane.setTop(deletelook);  
       Label label0=new Label();
        label0.setText("学号:");
        TextField textfield0=new TextField();
        textfield0.setEditable(false);
         Label label1=new Label();
        label1.setText("姓名:");
        TextField textfield1=new TextField();
        textfield1.setEditable(false);
         Label label2=new Label();
        label2.setText("性别:");
        TextField textfield2=new TextField();
                textfield2.setEditable(false);
         Label label3=new Label();
        label3.setText("年龄:");
        TextField textfield3=new TextField();
                textfield3.setEditable(false);
         Label label4=new Label();
        label4.setText("系别:");
        TextField textfield4=new TextField();
                textfield4.setEditable(false);
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
        label3.setFont(Font.font(12));
        label4.setFont(Font.font(12));
        textfield0.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
        textfield3.setFont(Font.font(12));
        textfield4.setFont(Font.font(12));
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        deletelook2.add(label0, 0, 0);
        deletelook2.add(label1, 0, 1);
        deletelook2.add(label2, 0, 2);
        deletelook2.add(label3, 0, 3);
        deletelook2.add(label4, 0, 4);
        deletelook2.add(textfield0, 1, 0);
        deletelook2.add(textfield1, 1, 1);
        deletelook2.add(textfield2, 1, 2);
        deletelook2.add(textfield3, 1, 3);
        deletelook2.add(textfield4, 1, 4);
        deletelook2.add(hbox,1,5);
        deletelook2.setAlignment(Pos.TOP_CENTER);
        deletepane.setCenter(deletelook2);
        
        deletelook2.setHgap(10);
        deletelook2.setVgap(10);
        deletelook2.setPadding(new Insets(30,10,8,10));
        textfieldname.setOnAction(e->{
             String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.student where sno='"+textfieldname.getText()+"'");
    result.next();
    System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
    textfield0.setText(result.getString(1));
    textfield1.setText(result.getString(2));
    textfield2.setText(result.getString(3));
    textfield3.setText(result.getString(4));
    textfield4.setText(result.getString(5));
    conn.close();
    }catch(Exception x){
      System.out.println("异常");
    }
        });
        btok.setOnAction(e->{
              String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
             try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   state.executeUpdate("delete from student where(sno='"+textfieldname.getText()+"')");
   JOptionPane.showMessageDialog(null,"删除成功", "信息", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception x){
      System.out.println("异常");
    }
        });
         btof.setOnAction(e->{ 
             textfieldname.setText("");
            textfield0.setText("");
             textfield1.setText("");
              textfield2.setText("");
               textfield3.setText("");
                textfield4.setText("");
        });
        //studentpane.getChildren().add(checkpane);
        }
        {
            BorderPane rightpane=new BorderPane();
            GridPane leftlook=new GridPane();
             GridPane leftlook2=new GridPane();
            BorderPane leftpane=new BorderPane();  
            GridPane rightlook=new GridPane();
            HBox chbox=new HBox();
             String chs=new String();
               TextField textfieldname=new TextField();
                  TextField textfield10=new TextField();
     
        textfield10.setEditable(false);
            { Label label=new Label("");
        label.setFont(Font.font(20));
        Label labelname=new Label("学号");
      
        labelname.setFont(Font.font(12));
        textfieldname.setFont(Font.font(12));
        leftlook.add(label, 0, 0,2,1);
        leftlook.add(labelname, 0, 1);
        leftlook.add(textfieldname,1,1);
        leftlook.setHgap(15);
        leftlook.setVgap(20);
        leftlook.setAlignment(Pos.CENTER);
        leftlook.setPadding(new Insets(70,10,10,10));
        leftpane.setTop(leftlook);  
        Label label0=new Label();
        label0.setText("学号:");
        TextField textfield0=new TextField();
        textfield0.setEditable(false);
         Label label1=new Label();
        label1.setText("姓名:");
        TextField textfield1=new TextField();
        textfield1.setEditable(false);
         Label label2=new Label();
        label2.setText("性别:");
        TextField textfield2=new TextField();
                textfield2.setEditable(false);
         Label label3=new Label();
        label3.setText("年龄:");
        TextField textfield3=new TextField();
                textfield3.setEditable(false);
         Label label4=new Label();
        label4.setText("系别:");
        TextField textfield4=new TextField();
                textfield4.setEditable(false);
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
        label3.setFont(Font.font(12));
        label4.setFont(Font.font(12));
        textfield0.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
        textfield3.setFont(Font.font(12));
        textfield4.setFont(Font.font(12));
        Button btok=new Button("确定");
        Button btof=new Button("取消");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        leftlook2.add(label0, 0, 0);
        leftlook2.add(label1, 0, 1);
        leftlook2.add(label2, 0, 2);
        leftlook2.add(label3, 0, 3);
        leftlook2.add(label4, 0, 4);
        leftlook2.add(textfield0, 1, 0);
        leftlook2.add(textfield1, 1, 1);
        leftlook2.add(textfield2, 1, 2);
        leftlook2.add(textfield3, 1, 3);
        leftlook2.add(textfield4, 1, 4);
        leftlook2.setAlignment(Pos.TOP_CENTER);
        leftpane.setCenter(leftlook2);
        leftlook2.setHgap(10);
        leftlook2.setVgap(10);
        leftlook2.setPadding(new Insets(18,10,8,10));
        //studentpane.getChildren().add(leftpane);
        textfieldname.setOnAction(e->{
               textfield10.setText(textfieldname.getText());
             String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.student where sno='"+textfieldname.getText()+"'");
    result.next();
    System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
    textfield0.setText(result.getString(1));
    textfield1.setText(result.getString(2));
    textfield2.setText(result.getString(3));
    textfield3.setText(result.getString(4));
    textfield4.setText(result.getString(5));
    conn.close();
    }catch(Exception x){
      System.out.println("异常");
    }
        });}
         {
        Label label=new Label("");
        label.setFont(Font.font(20));
        Label label0=new Label();
        label0.setText("学号:");
     
         Label label1=new Label();
        label1.setText("姓名:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("性别:");
        TextField textfield2=new TextField();
         Label label3=new Label();
        label3.setText("年龄:");
        TextField textfield3=new TextField();
         Label label4=new Label();
        label4.setText("系别:");
        TextField textfield4=new TextField();
        rightlook.add(label0, 1, 3);
        rightlook.add(textfield10,3,3);
        rightlook.add(label1, 1, 4);
        rightlook.add(textfield1,3,4);
        rightlook.add(label2, 1, 5);
        rightlook.add(textfield2,3,5);
        rightlook.add(label3, 1, 6);
        rightlook.add(textfield3,3,6);
        rightlook.add(label4, 1, 7);
        rightlook.add(textfield4,3,7);
        rightlook.add(label,0,0,5,1);
        label.setAlignment(Pos.TOP_RIGHT);
       // studentpane.getChildren().add(rightlook);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
        label3.setFont(Font.font(12));
        label4.setFont(Font.font(12));
        textfield10.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
        textfield3.setFont(Font.font(12));
        textfield4.setFont(Font.font(12));
        rightlook.setPadding(new Insets(0,20,10,20));
        rightlook.setVgap(10);
        rightlook.setHgap(8);
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        rightlook.add(hbox,3,8);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        rightlook.setAlignment(Pos.CENTER);
        btok.setOnAction(e->{
            if(textfield10.getText().isEmpty()||textfield1.getText().isEmpty()||textfield2.getText().isEmpty()||textfield3.getText().isEmpty()||textfield4.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null,"请输入全部信息", "错误", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                 String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   state.executeUpdate("UPDATE student SET sno='"+ textfield10.getText()+"',sname='"+ textfield1.getText()+"',ssex='"+ textfield2.getText()+"',sage='"+ textfield3.getText()+"',sdept='"+ textfield4.getText()+"' WHERE sno='"+textfield10.getText() +"' ");
   JOptionPane.showMessageDialog(null,"修改成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception f){
      System.out.println("异常");
    }
            }
        });
        btof.setOnAction(e->{ 
            textfield10.setText("");
             textfield1.setText("");
              textfield2.setText("");
               textfield3.setText("");
                textfield4.setText("");
        });
            }
        
           /* updatepane.setLeft(leftpane);
            updatepane.setRight(rightlook);
            updatepane.setAlignment(leftpane,Pos.CENTER_RIGHT);
            updatepane.setAlignment(rightlook,Pos.CENTER_LEFT);*/
           chbox.getChildren().addAll(leftpane,rightlook);
           chbox.setAlignment(Pos.CENTER);
           updatepane.setCenter(chbox);
           updatepane.setAlignment(chbox,Pos.CENTER);
        }
    }
}
class CoursePane{
    static StackPane coursepane=new StackPane();
   static GridPane addpane=new GridPane();
   static BorderPane checkpane=new BorderPane();
   static BorderPane deletepane=new BorderPane();
   static GridPane deletelook=new GridPane();
   static GridPane deletelook2=new GridPane();
   static GridPane checklook=new GridPane();
   static GridPane checklook2=new GridPane();
   static BorderPane updatepane=new BorderPane();
   static BorderPane tablebox=new BorderPane();
      static TableView<Student> table = new TableView<>();
      static   ObservableList list=FXCollections.<Student>observableArrayList(); 
   public CoursePane()
   {
       {
      TableColumn col1=new TableColumn("课程号");
      TableColumn col2=new TableColumn("课程名");     
      TableColumn col3=new TableColumn("系别");
    
      
        col1.setMinWidth(100);
        col1.setCellValueFactory(new PropertyValueFactory<Course,String>("cno"));
        col2.setMinWidth(100);
         col2.setCellValueFactory(new PropertyValueFactory<Course,String>("cname"));
         col3.setMinWidth(100);
          col3.setCellValueFactory(new PropertyValueFactory<Course,String>("cdept"));
            
            table.getColumns().addAll(col1,col2,col3);
          //HBox hb=new HBox();
         // hb.setMinHeight(800);
          //hb.setMinWidth(600);
          //hb.getChildren().add(table);
          tablebox.setMinWidth(400);
            tablebox.setCenter(table);
            tablebox.setPadding(new Insets(10,15,10,15));
        }
        {
        Label label=new Label("\t新增课程信息");
        label.setFont(Font.font(20));
        Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
         Label label1=new Label();
        label1.setText("课程名:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("专业:");
        TextField textfield2=new TextField();
        
        addpane.add(label0, 1, 2);
        addpane.add(textfield0,3,2);
        addpane.add(label1, 1, 3);
        addpane.add(textfield1,3,3);
        addpane.add(label2, 1, 4);
        addpane.add(textfield2,3,4);
        addpane.add(label,0,0,5,1);
        label.setAlignment(Pos.TOP_RIGHT);
       // studentpane.getChildren().add(addpane);
        label0.setFont(Font.font(14));
        label1.setFont(Font.font(14));
        label2.setFont(Font.font(14));
        textfield0.setFont(Font.font(14));
        textfield1.setFont(Font.font(14));
        textfield2.setFont(Font.font(14));
        addpane.setPadding(new Insets(0,20,10,20));
        addpane.setVgap(10);
        addpane.setHgap(8);
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        addpane.add(hbox,3,8);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        addpane.setAlignment(Pos.CENTER);
        btok.setOnAction(e->{
            if(textfield0.getText().isEmpty()||textfield1.getText().isEmpty()||textfield2.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null,"请输入全部信息", "错误", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                 String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   state.executeUpdate("INSERT INTO course values('"+ textfield0.getText()+"','"+ textfield1.getText()+"','"+ textfield2.getText()+"')");
   JOptionPane.showMessageDialog(null,"录入成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception f){
      System.out.println("异常");
    }
            }
        });
        btof.setOnAction(e->{ 
            textfield0.setText("");
             textfield1.setText("");
              textfield2.setText("");
               
        });
    }
       { 
           Label label=new Label("\t查询课程信息");
        label.setFont(Font.font(25));
        Label labelname=new Label("课程号");
        TextField textfieldname=new TextField();
        labelname.setFont(Font.font(14));
        textfieldname.setFont(Font.font(14));
        checklook.add(label, 0, 0,2,1);
        checklook.add(labelname, 0, 1);
        checklook.add(textfieldname,1,1);
        checklook.setHgap(15);
        checklook.setVgap(14);
        checklook.setAlignment(Pos.CENTER);
        checklook.setPadding(new Insets(100,10,10,10));
        checkpane.setTop(checklook);     
        Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
         Label label1=new Label();
        label1.setText("课程名:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("专业:");
        TextField textfield2=new TextField();
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(14));
        label1.setFont(Font.font(14));
        label2.setFont(Font.font(14));
        textfield0.setFont(Font.font(14));
        textfield1.setFont(Font.font(14));
        textfield2.setFont(Font.font(14));
        Button btok=new Button("确定");
        Button btof=new Button("取消");
        btok.setFont(Font.font(15));
        btof.setFont(Font.font(15));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        checklook2.add(label0, 0, 0);
        checklook2.add(label1, 0, 1);
        checklook2.add(label2, 0, 2);
        checklook2.add(textfield0, 1, 0);
        checklook2.add(textfield1, 1, 1);
        checklook2.add(textfield2, 1, 2);
        checklook2.setAlignment(Pos.TOP_CENTER);
        checkpane.setCenter(checklook2);
        checklook2.setHgap(15);
        checklook2.setVgap(15);
        checklook2.setPadding(new Insets(50,10,10,10));
           
        textfieldname.setOnAction(e->{
        String url="jdbc:mysql://localhost:3306/workplace";
        String driverName="com.mysql.jdbc.Driver";
        String username="Wolf";
        String password="yuan2439115241";
        try{
        Class.forName(driverName);
        Connection conn=DriverManager.getConnection(url, username, password);
        Statement state=conn.createStatement();
        ResultSet result=state.executeQuery("SELECT * FROM workplace.course where cno='"+textfieldname.getText()+"'");
        result.next();
       // System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
        textfield0.setText(result.getString(1));
        textfield1.setText(result.getString(2));
        textfield2.setText(result.getString(3));
        conn.close();
        }catch(Exception x){
          System.out.println("异常");
        }
        });
   } 
       {
            Label label=new Label("\t删除课程信息");
        label.setFont(Font.font(20));
        Label labelname=new Label("课程号");
        TextField textfieldname=new TextField();
        labelname.setFont(Font.font(12));
        textfieldname.setFont(Font.font(12));
        deletelook.add(label, 0, 0,2,1);
        deletelook.add(labelname, 0, 1);
        deletelook.add(textfieldname,1,1);
        deletelook.setHgap(15);
        deletelook.setVgap(20);
        deletelook.setAlignment(Pos.CENTER);
        deletelook.setPadding(new Insets(70,10,10,10));
        deletepane.setTop(deletelook);  
       Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
        textfield0.setEditable(false);
         Label label1=new Label();
        label1.setText("课程名:");
        TextField textfield1=new TextField();
        textfield1.setEditable(false);
         Label label2=new Label();
        label2.setText("专业:");
        TextField textfield2=new TextField();
                textfield2.setEditable(false);
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
       
        textfield0.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
    
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        deletelook2.add(label0, 0, 0);
        deletelook2.add(label1, 0, 1);
        deletelook2.add(label2, 0, 2);
      
        deletelook2.add(textfield0, 1, 0);
        deletelook2.add(textfield1, 1, 1);
        deletelook2.add(textfield2, 1, 2);
      
        deletelook2.add(hbox,1,5);
        deletelook2.setAlignment(Pos.TOP_CENTER);
        deletepane.setCenter(deletelook2);        
        deletelook2.setHgap(10);
        deletelook2.setVgap(10);
        deletelook2.setPadding(new Insets(30,10,8,10));
        textfieldname.setOnAction(e->{
             String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.course where cno='"+textfieldname.getText()+"'");
    result.next();
   // System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
    textfield0.setText(result.getString(1));
    textfield1.setText(result.getString(2));
    textfield2.setText(result.getString(3));
    conn.close();
    }catch(Exception x){
      System.out.println("异常");
    }
        });
     btok.setOnAction(e->{
              String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
             try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   state.executeUpdate("delete from course where(cno='"+textfieldname.getText()+"')");
   JOptionPane.showMessageDialog(null,"删除成功", "信息", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception x){
      System.out.println("异常5");
    }
        });
         btof.setOnAction(e->{ 
             textfieldname.setText("");
            textfield0.setText("");
             textfield1.setText("");
              textfield2.setText("");              
        });        
       }
       {
             BorderPane rightpane=new BorderPane();
            GridPane leftlook=new GridPane();
             GridPane leftlook2=new GridPane();
            BorderPane leftpane=new BorderPane();  
            GridPane rightlook=new GridPane();
            HBox chbox=new HBox();
             String chs=new String();
               TextField textfieldname=new TextField();
                  TextField textfield10=new TextField();
     
        textfield10.setEditable(false);
            { Label label=new Label("");
        label.setFont(Font.font(20));
        Label labelname=new Label("课程号");
      
        labelname.setFont(Font.font(12));
        textfieldname.setFont(Font.font(12));
        leftlook.add(label, 0, 0,2,1);
        leftlook.add(labelname, 0, 1);
        leftlook.add(textfieldname,1,1);
        leftlook.setHgap(15);
        leftlook.setVgap(20);
        leftlook.setAlignment(Pos.CENTER);
        leftlook.setPadding(new Insets(90,10,10,10));
        leftpane.setTop(leftlook);  
        Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
        textfield0.setEditable(false);
         Label label1=new Label();
        label1.setText("课程名:");
        TextField textfield1=new TextField();
        textfield1.setEditable(false);
         Label label2=new Label();
        label2.setText("专业:");
        TextField textfield2=new TextField();
                textfield2.setEditable(false);
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
     
        textfield0.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
      
        Button btok=new Button("确定");
        Button btof=new Button("取消");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        leftlook2.add(label0, 0, 0);
        leftlook2.add(label1, 0, 1);
        leftlook2.add(label2, 0, 2);
      
        leftlook2.add(textfield0, 1, 0);
        leftlook2.add(textfield1, 1, 1);
        leftlook2.add(textfield2, 1, 2);
      
        leftlook2.setAlignment(Pos.TOP_CENTER);
        leftpane.setCenter(leftlook2);
        leftlook2.setHgap(10);
        leftlook2.setVgap(10);
        leftlook2.setPadding(new Insets(18,10,8,10));
        //studentpane.getChildren().add(leftpane);
        textfieldname.setOnAction(e->{
               textfield10.setText(textfieldname.getText());
             String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
    ResultSet result=state.executeQuery("SELECT * FROM workplace.course where cno='"+textfieldname.getText()+"'");
    result.next();
   
    textfield0.setText(result.getString(1));
    textfield1.setText(result.getString(2));
    textfield2.setText(result.getString(3));
   
    conn.close();
    }catch(Exception x){
      System.out.println("异常");
    }
        });}
         {
        Label label=new Label("");
        label.setFont(Font.font(20));
        Label label0=new Label();
        label0.setText("课程号:");
     
         Label label1=new Label();
        label1.setText("课程名:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("专业:");
        TextField textfield2=new TextField();
       
      
        rightlook.add(label0, 1, 3);
        rightlook.add(textfield10,3,3);
        rightlook.add(label1, 1, 4);
        rightlook.add(textfield1,3,4);
        rightlook.add(label2, 1, 5);
        rightlook.add(textfield2,3,5);
      
        rightlook.add(label,0,0,5,1);
        label.setAlignment(Pos.TOP_RIGHT);
       // studentpane.getChildren().add(rightlook);
        label0.setFont(Font.font(12));
        label1.setFont(Font.font(12));
        label2.setFont(Font.font(12));
     
        textfield10.setFont(Font.font(12));
        textfield1.setFont(Font.font(12));
        textfield2.setFont(Font.font(12));
     
        rightlook.setPadding(new Insets(0,20,10,20));
        rightlook.setVgap(10);
        rightlook.setHgap(8);
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        rightlook.add(hbox,3,8);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        rightlook.setAlignment(Pos.CENTER);
        btok.setOnAction(e->{
            if(textfield10.getText().isEmpty()||textfield1.getText().isEmpty()||textfield2.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null,"请输入全部信息", "错误", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                 String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   state.executeUpdate("UPDATE course SET cno='"+ textfield10.getText()+"',cname='"+ textfield1.getText()+"',cdept='"+ textfield2.getText()+"' ");
   JOptionPane.showMessageDialog(null,"修改成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception z){
      System.out.println("异常");
    }
            }
        });
        btof.setOnAction(e->{ 
            textfield10.setText("");
             textfield1.setText("");
              textfield2.setText("");
             
        });
            }
        
           /* updatepane.setLeft(leftpane);
            updatepane.setRight(rightlook);
            updatepane.setAlignment(leftpane,Pos.CENTER_RIGHT);
            updatepane.setAlignment(rightlook,Pos.CENTER_LEFT);*/
           chbox.getChildren().addAll(leftpane,rightlook);
           chbox.setAlignment(Pos.CENTER);
           updatepane.setCenter(chbox);
           updatepane.setAlignment(chbox,Pos.CENTER);
       }
   }
}
class ScPane{
    static StackPane spane=new StackPane();
static GridPane addpane=new GridPane();
 static GridPane updatepane=new GridPane();
 static BorderPane checkpane=new BorderPane();
  static GridPane checklook=new GridPane();
   static GridPane checklook2=new GridPane();
      static BorderPane tablebox=new BorderPane();
      static TableView<Student> table = new TableView<>();
      static   ObservableList list=FXCollections.<Student>observableArrayList();
public ScPane()
 {
             {            
      TableColumn col1=new TableColumn("学号");
      TableColumn col2=new TableColumn("姓名");
      TableColumn col3=new TableColumn("课序号");
      TableColumn col4=new TableColumn("课程名");
      TableColumn col5=new TableColumn("成绩");   
        col1.setMinWidth(100);
        col1.setCellValueFactory(new PropertyValueFactory<S_C,String>("sno"));
        col2.setMinWidth(100);
         col2.setCellValueFactory(new PropertyValueFactory<S_C,String>("ssname"));
         col3.setMinWidth(100);
          col3.setCellValueFactory(new PropertyValueFactory<S_C,String>("cno"));
          col4.setMinWidth(100);
           col4.setCellValueFactory(new PropertyValueFactory<S_C,String>("cname"));
           col5.setMinWidth(100);
            col5.setCellValueFactory(new PropertyValueFactory<S_C,String>("sgrade"));
            table.setItems(list);
            table.getColumns().addAll(col1,col2,col3,col4,col5);            
          HBox hb=new HBox();
          hb.getChildren().add(table);
            tablebox.setCenter(hb);
            tablebox.setPadding(new Insets(10,15,10,75));
        }
     {
         Label label=new Label("\t新增成绩信息");
        label.setFont(Font.font(20));
        Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
         Label label1=new Label();
        label1.setText("学号:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("成绩:");
        TextField textfield2=new TextField();        
        addpane.add(label0, 1, 2);
        addpane.add(textfield0,3,2);
        addpane.add(label1, 1, 3);
        addpane.add(textfield1,3,3);
        addpane.add(label2, 1, 4);
        addpane.add(textfield2,3,4);
        addpane.add(label,0,0,5,1);
        label.setAlignment(Pos.TOP_RIGHT);
       // studentpane.getChildren().add(addpane);
        label0.setFont(Font.font(14));
        label1.setFont(Font.font(14));
        label2.setFont(Font.font(14));
        textfield0.setFont(Font.font(14));
        textfield1.setFont(Font.font(14));
        textfield2.setFont(Font.font(14));
        addpane.setPadding(new Insets(0,20,10,20));
        addpane.setVgap(10);
        addpane.setHgap(8);
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        addpane.add(hbox,3,8);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        addpane.setAlignment(Pos.CENTER);
        btok.setOnAction(e->{
            if(textfield0.getText().isEmpty()||textfield1.getText().isEmpty()||textfield2.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null,"请输入全部信息", "错误", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                 String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
   ResultSet result=state.executeQuery("Select count(*) FROM sc where cno='"+textfield0.getText()+"' AND sno='"+textfield1.getText()+"'");
   //if(result.next())  JOptionPane.showMessageDialog(null,"成绩已提交无法提交", "错误", JOptionPane.INFORMATION_MESSAGE);;
   state.executeUpdate("INSERT INTO sc values('"+ textfield0.getText()+"','"+ textfield1.getText()+"','"+ textfield2.getText()+"')");
   JOptionPane.showMessageDialog(null,"录入成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception f){
      System.out.println("异常");
       JOptionPane.showMessageDialog(null,"请检查学号或课程号", "错误", JOptionPane.INFORMATION_MESSAGE); 
    }
            }
        });
        btof.setOnAction(e->{ 
            textfield0.setText("");
             textfield1.setText("");
              textfield2.setText("");               
        });
      }
     {
          Label label=new Label("\t修改成绩信息");
        label.setFont(Font.font(20));
        Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
         Label label1=new Label();
        label1.setText("学号:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("成绩:");
        TextField textfield2=new TextField();        
        updatepane.add(label0, 1, 2);
        updatepane.add(textfield0,3,2);
        updatepane.add(label1, 1, 3);
        updatepane.add(textfield1,3,3);
        updatepane.add(label2, 1, 4);
        updatepane.add(textfield2,3,4);
        updatepane.add(label,0,0,5,1);
        label.setAlignment(Pos.TOP_RIGHT);
       // studentpane.getChildren().add(updatepane);
        label0.setFont(Font.font(14));
        label1.setFont(Font.font(14));
        label2.setFont(Font.font(14));
        textfield0.setFont(Font.font(14));
        textfield1.setFont(Font.font(14));
        textfield2.setFont(Font.font(14));
        updatepane.setPadding(new Insets(0,20,10,20));
        updatepane.setVgap(10);
        updatepane.setHgap(8);
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(11));
        btof.setFont(Font.font(11));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        updatepane.add(hbox,3,8);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        updatepane.setAlignment(Pos.CENTER);
        btok.setOnAction(e->{
            if(textfield0.getText().isEmpty()||textfield1.getText().isEmpty()||textfield2.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null,"请输入全部信息", "错误", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                 String url="jdbc:mysql://localhost:3306/workplace";
    String driverName="com.mysql.jdbc.Driver";
    String username="Wolf";
    String password="yuan2439115241";
    try{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement state=conn.createStatement();
  state.executeQuery("delete FROM sc where cno='"+textfield0.getText()+"' AND sno='"+textfield1.getText()+"'");
     state.executeUpdate("INSERT INTO sc values('"+ textfield0.getText()+"','"+ textfield1.getText()+"','"+ textfield2.getText()+"')");
   JOptionPane.showMessageDialog(null,"录入成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
    conn.close();
    }catch(Exception f){
      System.out.println("异常");
       JOptionPane.showMessageDialog(null,"请检查学号或课程号", "错误", JOptionPane.INFORMATION_MESSAGE); 
    }
            }
        });
        btof.setOnAction(e->{ 
            textfield0.setText("");
             textfield1.setText("");
              textfield2.setText("");               
        });
     }
     {
         Label label=new Label("\t查询成绩信息");
        label.setFont(Font.font(20));
        Label labelc=new Label("课程号");
        TextField textfieldc=new TextField();
        labelc.setFont(Font.font(14));        
        Label labels=new Label("学 号");
        TextField textfields=new TextField();
        labels.setFont(Font.font(14));
        textfieldc.setFont(Font.font(14));
         textfields.setFont(Font.font(14));
        checklook.add(label, 0, 0,2,1);
        checklook.add(labelc, 0, 1);
        checklook.add(textfieldc,1,1);
        checklook.add(labels, 0, 2);
        checklook.add(textfields,1,2);
        checklook.setHgap(15);
        checklook.setVgap(14);
        checklook.setAlignment(Pos.CENTER);
        checklook.setPadding(new Insets(40,10,10,10));
        checkpane.setTop(checklook);
        //checklook.setMaxHeight(50);
        Label label0=new Label();
        label0.setText("课程号:");
        TextField textfield0=new TextField();
         Label label1=new Label();
        label1.setText("课程名:");
        TextField textfield1=new TextField();
         Label label2=new Label();
        label2.setText("学号:");
        TextField textfield2=new TextField();
         Label label3=new Label();
        label3.setText("姓名:");
        TextField textfield3=new TextField();
          Label label4=new Label();
        label4.setText("成绩:");
        TextField textfield4=new TextField();
        label.setAlignment(Pos.TOP_RIGHT);
        label0.setFont(Font.font(14));
        label1.setFont(Font.font(14));
        label2.setFont(Font.font(14));
         label3.setFont(Font.font(14));
        label4.setFont(Font.font(14));
        textfield0.setFont(Font.font(14));
        textfield1.setFont(Font.font(14));
        textfield2.setFont(Font.font(14));
        textfield3.setFont(Font.font(14));
        textfield4.setFont(Font.font(14));
        Button btok=new Button("确定");
        Button btof=new Button("清空");
        btok.setFont(Font.font(15));
        btof.setFont(Font.font(15));
        HBox hbox=new HBox();
        hbox.getChildren().addAll(btok,btof);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        checklook2.add(label0, 0, 0);
        checklook2.add(label1, 0, 1);
        checklook2.add(label2, 0, 2);
        checklook2.add(textfield0, 1, 0);
        checklook2.add(textfield1, 1, 1);
        checklook2.add(textfield2, 1, 2);
         checklook2.add(label3, 0, 3);
        checklook2.add(label4, 0, 4);
        checklook2.add(textfield3, 1, 3);
        checklook2.add(textfield4, 1, 4);
     
        checklook2.add(hbox,1,5);
        checklook2.setAlignment(Pos.TOP_CENTER);
        checkpane.setCenter(checklook2);
        checklook2.setHgap(10);
        checklook2.setVgap(8);
        checklook2.setPadding(new Insets(20,10,8,10));
           
        btok.setOnAction(e->{
        String url="jdbc:mysql://localhost:3306/workplace";
        String driverName="com.mysql.jdbc.Driver";
        String username="Wolf";
        String password="yuan2439115241";
        try{
        Class.forName(driverName);
        Connection conn=DriverManager.getConnection(url, username, password);
        Statement state=conn.createStatement();
        ResultSet result=state.executeQuery("SELECT course.cno,course.cname,student.sno,sname,grade FROM workplace.sc,student,workplace.course where cno='"+textfieldc.getText()+"' and sno='"+textfields.getText()+"'");
        result.next();
       // System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
        textfield0.setText(result.getString(1));
        textfield1.setText(result.getString(2));
        textfield2.setText(result.getString(3));
         textfield3.setText(result.getString(4));
        textfield4.setText(result.getString(5));
        conn.close();
        }catch(Exception x){
          System.out.println("异常");
        }
        });
       btof.setOnAction(e->{
           textfieldc.setText("");
              textfields.setText("");
             textfield0.setText("");
        textfield1.setText("");
        textfield2.setText("");
         textfield3.setText("");
        textfield4.setText("");
       });
     }
 }
}
