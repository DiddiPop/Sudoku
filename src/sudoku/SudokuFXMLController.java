/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Diddi
 */
public class SudokuFXMLController implements Initializable {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label[][] label = new Label[9][9];
    
    int a[][] = new int[9][9];
    
    @FXML
    private void setGUI() {
        int num =0;
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label.length; j++) {
                a[i][j] = num;
                label[i][j] = new Label();
                label[i][j].setText(String.valueOf(num));
                gridPane.add(label[i][j], i, j);
            }
        }
    }
    public void generate(){
        int x=1;
        int y=1;
        
            for(int i=0;i<9;i++){
                x=y;
                for(int j=0;j<9;j++){
                    if(x<=9){ 
                        a[i][j]=x;
                        x++;
                }else{
                    x=1;
                    a[i][j]=x;
                    x++;
                }
            }
                y=x+3;
                if(x==10)
                y=4;
                if(y>9)
                y=(y%9)+1;
            }
    }
    
    public void combination_row(int x,int y){
        int temp;
            for(int j=0;j<9;j++)
            {
               temp=a[x][j];
               a[x][j]=a[y][j];
               a[y][j]=temp;
            }
    }
    public void combination_col(int x,int y){
        int temp;
            for(int j=0;j<9;j++){
               temp=a[j][x];
               a[j][x]=a[j][y];
               a[j][y]=temp;
            }
    }
    public void random_gen(int check){
        int k1,k2,max=2,min=0;
        Random r= new Random();
            for(int i=0;i<3;i++){
                k1=r.nextInt(max-min+1)+min;
            do{
                k2=r.nextInt(max-min+1)+min;
            }while(k1==k2);
                max+=3;min+=3;
            if(check==1){
                combination_row(k1,k2);
            }else if(check==0){
                combination_col(k1,k2);
            }
                
      }
   }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
   generate();
   random_gen(1);
   random_gen(0);

   for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
          if(j==3 || j==6){
                System.out.print(" ");
            }
         System.out.print(a[i][j]+" ");
      }
      System.out.println(" ");
            if(i==2 || i==5 || i==8){
                System.out.println(" ");
            }   
   }
           

    }  
}
