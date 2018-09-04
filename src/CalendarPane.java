import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

class CalendarPane extends BorderPane { 

  private Label[] lblDay = new Label[49];

  private Calendar calendar;
  private int month;  
  private int year;  

  public CalendarPane() {
    for (int i = 0; i < 49; i++) {
      lblDay[i] = new Label();
      lblDay[i].setTextAlignment(TextAlignment.RIGHT);
    }
     
    lblDay[0].setText("Sunday");
    lblDay[1].setText("Monday");
    lblDay[2].setText("Tuesday");
    lblDay[3].setText("Wednesday");
    lblDay[4].setText("Thursday");
    lblDay[5].setText("Friday");
    lblDay[6].setText("Saturday");

    GridPane dPane = new GridPane();
    dPane.setAlignment(Pos.CENTER);
    dPane.setHgap(9);
    dPane.setVgap(9);
    for (int i = 0; i < 49; i++) {
      dPane.add(lblDay[i], i %7, i / 7);
    }    
    this.setCenter(dPane);

    calendar = new GregorianCalendar();
    month = calendar.get(Calendar.MONTH);
    year = calendar.get(Calendar.YEAR);
    
    //TextField yearMessage=new TextField(getYear()+"");
    ComboBox<String> yearMessage=new ComboBox<>();
    for(int i=1970;i<2060;i++)
    {
        yearMessage.getItems().addAll(""+i+"");
    }
    yearMessage.setValue(""+getYear()+"");
    yearMessage.setStyle("-fx-text-fill:gray");
    Button btYear1=new Button("<");
    Button btYear2=new Button(">");
    
    //TextField monthMessage=new TextField(getMonth()+1+"");
     ComboBox<String> monthMessage=new ComboBox<>();
    monthMessage.setStyle("-fx-text-fill:gray");
      for(int i=1;i<13;i++)
    {
        monthMessage.getItems().addAll(""+i+"");
    }
   monthMessage.setValue(1+getMonth()+"");
    Button btMonth1=new Button("<");
    Button btMonth2=new Button(">");
    HBox hBox0=new HBox(2);
    HBox hBoxy=new HBox(3);
    HBox hBoxm=new HBox(3);
    hBoxy.getChildren().addAll(btYear1,yearMessage,btYear2);
    hBoxm.getChildren().addAll(btMonth1,monthMessage,btMonth2);
    hBox0.getChildren().addAll(hBoxy,hBoxm);
    HBox.setMargin(hBoxy,new Insets(10,50,0,20));
    HBox.setMargin(hBoxm,new Insets(10,90,0,0));
    hBox0.setAlignment(Pos.CENTER);
     this.setTop(hBox0);
     
     yearMessage.setOnAction(e->
     {
         //String s=yearMessage.getText();
         String s=yearMessage.getValue();
         int cyear=-1;
         cyear=Integer.parseInt(s);
         if(cyear>-9999&&cyear<9999)
         setYear(cyear);
     }
     );
     
     monthMessage.setOnAction(e->
     {
         //String s=monthMessage.getText();
           String s=monthMessage.getValue();
         int cmonth=-1;
         cmonth=Integer.parseInt(s);
         if(cmonth>0&&cmonth<13)
         setMonth(cmonth-1);
         Set_Right();
     }
     );
     btYear1.setOnAction(e->
     {
         setYear(year-1);
         //yearMessage.setText(getYear()+"");
         yearMessage.setValue(""+getYear()+"");
     }
     );
     btYear2.setOnAction(e->
     {
         setYear(year+1);
         //yearMessage.setText(getYear()+"");
          yearMessage.setValue(""+getYear()+"");
     }
     );
     
      btMonth1.setOnAction(e -> {
      int currentMonth =month;
      if (currentMonth == 0) { 
        setYear(year-1);
        setMonth(11);
      }
      else {
        setMonth(month-1);
      }
     // yearMessage.setText(getYear()+"");
      yearMessage.setValue(""+getYear()+"");
      //monthMessage.setText(getMonth()+1+"");
        monthMessage.setValue(1+getMonth()+"");
      Set_Right();
    });
    
    btMonth2.setOnAction(e -> {
      int currentMonth = month;
      if (currentMonth == 11) 
        setYear(year+1);
      setMonth((month+1)%12);
      // yearMessage.setText(getYear()+"");
       yearMessage.setValue(""+getYear()+"");
      //monthMessage.setText(getMonth()+1+"");
       monthMessage.setValue(1+getMonth()+"");
      Set_Right();
    });
    Set_Right();
    updateCalendar();
    showDays();
  }

  public void showDays() {
    int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);

    Calendar cloneCalendar = (Calendar) calendar.clone();
    cloneCalendar.add(Calendar.DATE, -1);
    int daysInPrecedingMonth = cloneCalendar.getActualMaximum(
            Calendar.DAY_OF_MONTH);

    for (int i = 0; i < startingDayOfMonth - 1; i++) {
      lblDay[i + 7].setTextFill(Color.LIGHTGRAY);
      lblDay[i + 7].setText(daysInPrecedingMonth
              - startingDayOfMonth + 2 + i + "");
    }


    int daysInCurrentMonth = calendar.getActualMaximum(
            Calendar.DAY_OF_MONTH);
    for (int i = 1; i <= daysInCurrentMonth; i++) {
      lblDay[i - 2 + startingDayOfMonth + 7].setTextFill(Color.BLACK);
      lblDay[i - 2 + startingDayOfMonth + 7].setText(i + "");
    }

 
    int j = 1;
    for (int i = daysInCurrentMonth - 1 + startingDayOfMonth + 7;
            i < 49; i++) {
      lblDay[i].setTextFill(Color.LIGHTGRAY);
      lblDay[i].setText(j++ + "");
    }
  }


  public void updateCalendar() {
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DATE, 1);
  }

 public void Set_Right()
 {
     {if(month>=2&&month<=4)
    { Image image1=new Image("春.jpg");
     ImageView imageView1=new ImageView(image1);
     imageView1.setFitHeight(250);
     imageView1.setFitWidth(100);
     VBox vBox=new VBox(1);
     vBox.getChildren().addAll(imageView1);
     vBox.setAlignment(Pos.CENTER);
     this.setRight(vBox);
    }
    if(month>=5&&month<=7)
    {
         Image image1=new Image("夏.jpg");
     ImageView imageView1=new ImageView(image1);
     imageView1.setFitHeight(250);
     imageView1.setFitWidth(100);
     VBox vBox=new VBox(1);
     vBox.getChildren().addAll(imageView1);
     vBox.setAlignment(Pos.CENTER);
     this.setRight(vBox);
    }
    if(month>=8&&month<=10)
    {
         Image image1=new Image("秋.jpg");
     ImageView imageView1=new ImageView(image1);
     imageView1.setFitHeight(250);
     imageView1.setFitWidth(100);
     VBox vBox=new VBox(1);
     vBox.getChildren().addAll(imageView1);
     vBox.setAlignment(Pos.CENTER);
     this.setRight(vBox);
    }
    if(month>=11||month<=1)
    {
     Image image1=new Image("冬.jpg");
     ImageView imageView1=new ImageView(image1);
     imageView1.setFitHeight(250);
     imageView1.setFitWidth(100);
     VBox vBox=new VBox(1);
     vBox.getChildren().addAll(imageView1);
     vBox.setAlignment(Pos.CENTER);
     this.setRight(vBox);
    }}
 }
  public int getMonth() {
    return month;
  }

 
  public void setMonth(int newMonth) {
    month = newMonth;
    updateCalendar();
     showDays();
  }


  public int getYear() {
    return year;
  }
  
  public void setYear(int newYear) {
    year = newYear;
    updateCalendar();
    showDays();
  }
}


