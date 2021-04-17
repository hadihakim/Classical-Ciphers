/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassicalCiphersGUI;

import affinecipher.affinecipher;
import polybiussquare.Polybiussquare;
import vigenerecipher.vigenerecipher;
import playfaircipher.playfaircipher;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static playfaircipher.playfaircipher.createTable;
import static playfaircipher.playfaircipher.encode;
import static playfaircipher.playfaircipher.prepareText;
import static playfaircipher.playfaircipher.decode;
import static vigenerecipher.vigenerecipher.isnum;

/**
 *
 * @author Admin
 */
public class ClassicalCiphersFXMain extends Application {
    Scene scene1, scene2, scene3,affinescene,playfairscene,vigenerescene;
    int whichcipher, whichfunction;
    VBox vbox,affinebox,playfairbox,vigenerebox;
    @Override
    public void start(Stage primaryStage) {
      
        
         Label label = new Label("Choose a Classical Cipher:");
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Button encrypt = new Button();
        Button decrypt = new Button();
        
        //polybius nodes
        Text text = new Text();
        TextField inp = new TextField();
        Button send = new Button("Send");
        Button back = new Button("Back");
        Text text1 = new Text();
        
        //affine nodes
        Text textaffine = new Text();
        TextField affineinp = new TextField();
        Text textkey1 = new Text();
        Text textkey2 = new Text();
        TextField inpkey1 = new TextField();
        TextField inpkey2 = new TextField();
        Button sendaffine = new Button("send");
        Button backaffine = new Button("Back");
        Text affineoutput = new Text();
        sendaffine.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                //////AffineEncryption
                if(whichcipher==1 && whichfunction==1){
                    if (isnum(affineinp.getText())!=true && isnum(inpkey1.getText()) && isnum(inpkey2.getText()) && affinecipher.iscoprime(Integer.parseInt(inpkey1.getText()), 26)) {
                        
                    
                 String s = affineinp.getText();
                 int key1affine = Integer.parseInt(inpkey1.getText());
                 int key2affine = Integer.parseInt(inpkey2.getText());
                 String g = affinecipher.encrypttext(s, key1affine, key2affine);
                  affineoutput.setText(g);
                  
                    }
                    else affineoutput.setText("Please Be Sure You Enter Requirements!");
                }
                
             if(whichcipher==1 && whichfunction==2){
                 if (isnum(affineinp.getText())!=true && isnum(inpkey1.getText()) && isnum(inpkey2.getText()) && affinecipher.iscoprime(Integer.parseInt(inpkey1.getText()), 26)) {
                     
                 
                    String s = affineinp.getText();
                 int key1affine = Integer.parseInt(inpkey1.getText());
                 int key2affine = Integer.parseInt(inpkey2.getText());
                 String g = affinecipher.decrypttext(s, key1affine, key2affine);
                 affineoutput.setText(g);
                 }
                 else affineoutput.setText("Please Be Sure You Enter Requirements!");
                }
                 
                  }
         });
        
        
        //vigenere nodes
        Text textvigenere = new Text();
        TextField inpvigenere = new TextField();
        Text keyvigenere = new Text();
        TextField inpkeyvig = new TextField();
        Button sendvigenere = new Button("send");
        Button backvigenere = new Button("Back");
        Text vigenereoutput = new Text();
        //playfair nodes
        Text playtext = new Text();
        TextField playfield = new TextField();
        Text playkeytext = new Text();
        TextField playkeyfield = new TextField();
        Button playsend = new Button("Send");
        Button playback = new Button("Back");
        Text playoutput = new Text();
        
        playsend.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                //////PlayfairEncryption
                if(whichcipher==3 && whichfunction==1){
                    /*String s = playkeyfield.getText();
                    int f = Integer.parseInt(s);*/
                    
                    if (playkeyfield.getText().length()>=6 && isnum(playfield.getText())!=true && isnum(playkeyfield.getText())!=true) {
                        
                    
                    boolean bol = true;
                   // int key = Integer.parseInt(playkeyfield.getText());
                    
                    createTable(playkeyfield.getText(),bol);
                     String enc = encode(prepareText(playfield.getText(), bol));
                 //String s = playfield.getText();
                // String g = playfaircipher.encode(s);
                 playoutput.setText(enc);}
                    else playoutput.setText("Be Sure You Achieve The Requiremnets!");
                }
                
                if(whichcipher==3 && whichfunction==2){
                    if(playkeyfield.getText().length()>=6 &&  playfield.getText().length()%2==0 && isnum(playfield.getText())!=true && isnum(playkeyfield.getText())!=true ){
                    boolean bol = true;
                   createTable(playkeyfield.getText(),bol);
                     String enc = decode(prepareText(playfield.getText(), bol));
                  playoutput.setText(enc);}
                    else
                        playoutput.setText("Be Sure You Achieve The Requiremnets!");
                }
                 
                  }
         });
        playfairbox = new VBox();
        playfairbox.getChildren().addAll(playtext,playfield,playkeytext,playkeyfield,playsend,playback,playoutput);
        playfairscene = new Scene(playfairbox,700,500);
        playback.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
            playfield.clear(); 
            playkeyfield.clear();
              whichcipher=0;
              whichfunction=0;
              playoutput.setText("");
            
         });
        
        sendvigenere.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                if(whichcipher==4 && whichfunction==1){
                    if (inpvigenere.getText().length()>=inpkeyvig.getText().length() && isnum(inpkeyvig.getText())!=true && isnum(inpvigenere.getText())!=true ) {
                        
                    
                   
                   String vigstr = inpvigenere.getText();
                   String key = vigenerecipher.generateKey(vigstr, inpkeyvig.getText());
                   String h = vigenerecipher.cipherText(vigstr,key);
                   vigenereoutput.setText(h);}
                    else vigenereoutput.setText("Please Be Sure You Enter The Requirements!");
                   }
                    
                if(whichcipher==4 && whichfunction==2){
                    if (inpvigenere.getText().length()>=inpkeyvig.getText().length() && isnum(inpkeyvig.getText())!=true && isnum(inpvigenere.getText())!=true) {
                        
                    
                   String s = inpvigenere.getText();
                   String key = vigenerecipher.generateKey(s, inpkeyvig.getText());
                   String g = vigenerecipher.originalText(s,key);
                   vigenereoutput.setText(g);}
                    else vigenereoutput.setText("Please Be Sure You Enter The Requirements!");
                  }
                 
                }
         });
        
         backvigenere.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
            
            
              inpvigenere.clear(); 
              inpkeyvig.clear(); 
              whichcipher=0;
              whichfunction=0;
              vigenereoutput.setText("");
            
         });
        
        vigenerebox = new VBox();
        vigenerebox.getChildren().addAll(textvigenere,inpvigenere,keyvigenere,inpkeyvig,sendvigenere,backvigenere,vigenereoutput);
        vigenerescene = new Scene(vigenerebox,700,500);
        
        
        affinebox = new VBox();
        affinebox.getChildren().addAll(textaffine,affineinp,textkey1,inpkey1,textkey2,inpkey2,sendaffine,backaffine,affineoutput);
        affinescene = new Scene(affinebox,700,500);
        
        
        //
        //PassField pass = new PassField();
        
        
        //Polybiussquare poly = new Polybiussquare();
        
        String b = Polybiussquare.polybiusdecrypt("23 4311");
        String f = Polybiussquare.polybiusencrypt("SDGDHD");
        //String getinput = inp.getText();
        
       // text1.setText(b);
        
       
         
        
        btn1.setStyle("-fx-Background-Color: pink");
        btn3.setStyle("-fx-Background-Color: pink");
        
        
        affinecipher aff = new affinecipher();
        btn1.setText("Affine");
        btn2.setText("Polybius");
        btn3.setText("Playfair");
        btn4.setText("Vigenere");
        encrypt.setText("Encryption");
        decrypt.setText("Decryption");
        //text.setText(aff.encrypttext());
        
        btn2.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
            whichcipher = 2;
         });
        btn3.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
            whichcipher = 3;
         });
        btn4.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
            whichcipher = 4;
         });
        
       // btn1.setOnAction(e -> primaryStage.setScene(scene)); 
       /* btn2.setOnAction(new EventHandler<ActionEvent>() {
             private Scene scene;
            
           @Override
            public void handle(ActionEvent event) {
               
               primaryStage.setScene(scene);
                 
                 
            }
        });*/
         btn1.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
            whichcipher= 1;
         });
         encrypt.setOnAction((ActionEvent event) -> {
             whichfunction=1;
             if (whichcipher==2) {
                 primaryStage.setScene(scene3);
            text.setText("Enter The Plaintext(letters): ");}
             if (whichcipher==1) {
                 primaryStage.setScene(affinescene);
                 textaffine.setText("Enter The plaintext(letters): ");
                 textkey1.setText("Enter the first key (Number coprime with 26): " );
                 textkey2.setText("Enter the second key(Number) ");
               
                     
                 }
             if (whichcipher==4) {
                 //primaryStage.setScene(ascene);
                 primaryStage.setScene(vigenerescene);
                 textvigenere.setText("Enter The plaintext(letters): ");
                 keyvigenere.setText("Enter the Keyword smaller than plaintext in length(Letters): " );
                 
             }
             if (whichcipher==3) {
                 primaryStage.setScene(playfairscene);
            playtext.setText("Enter The Plaintext(letters): ");
            playkeytext.setText("Enter the keyword(letters length min = 6)");
             }

             
             
         
            
             // inp.clear();  
             
             /*if (whichcipher==1) {
                 vbox.getChildren().removeAll(send,back);
                 vbox.getChildren().addAll(textkey1,inpkey1,textkey2,inpkey2,send,back);
                 //primaryStage.setScene(affinescene);
                 
             }*/
            
         });
         decrypt.setOnAction((ActionEvent event) -> {
             whichfunction=2;
             if (whichcipher==2) {
                 
             
                primaryStage.setScene(scene3);
                text.setText("Enter The Ciphertext(DIGIT PAIRS): ");}
           // inp.clear();
           
             if (whichcipher==1) {
                 primaryStage.setScene(affinescene);
                 textaffine.setText("Enter The Ciphertext(letters): ");
                 textkey1.setText("Enter the first key (Number coprime with 26): " );
                 textkey2.setText("Enter the second key(Number) ");
                 }
              if (whichcipher==4) {
                 primaryStage.setScene(vigenerescene);
                 textvigenere.setText("Enter The ciphertext(letter): ");
                 keyvigenere.setText("Enter the Keyword smaller than ciphertext in length(letter): " );
              }
              if (whichcipher==3) {
                 primaryStage.setScene(playfairscene);
                 playtext.setText("Enter The Ciphertext(paired letters): ");
                 playkeytext.setText("Enter keyword(letters length min = 6)");
              }
            
            });
         send.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                //////PolybiusDecryption
                if(whichcipher==2 && whichfunction==2){
                    if (inp.getText().length()%2==0 && isnum(inp.getText()) && Integer.parseInt(inp.getText())<=25) {
                        
                    
                 String s = inp.getText();
                 String g = Polybiussquare.polybiusdecrypt(s);
                 //text1.setText("the cipher text is: "+f);
                 text1.setText(g);
                    }
                    else text1.setText("Please Be Sure You Enter The Requirements!");
                   }
             
                if(whichcipher==2 && whichfunction==1){
                    if (isnum(inp.getText())!=true) {
                        text1.setText(Polybiussquare.polybiusencrypt(inp.getText()));
                    }
                    else text1.setText("Please Be Sure You Enter The Requirements! ");
                }
                 /*if (whichcipher==1 && whichfunction==1) {
                     text1.setText(affinecipher.encrypttext(inp.getText(),2,3));
                     
                 }/*/
                
                 //vbox.getChildren().add(text1);
                 //text1.setText(f);
                  }
         });
         
         
         
      
        HBox gridPane = new HBox();
        gridPane.setSpacing(10);
        gridPane.getChildren().addAll(label,btn1,btn2,btn3,btn4);
        scene1 = new Scene(gridPane,700,500);
        //HBox box = new HBox();
        
        
        back.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
            
            
              inp.clear(); 
              whichcipher=0;
              whichfunction=0;
              text1.setText("");
            
         });
       
        backaffine.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
            
            
              affineinp.clear();
              inpkey1.clear();
              inpkey2.clear();
              whichcipher=0;
              whichfunction=0;
              affineoutput.setText("");
            
         });
       /* back.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
            
            
              inp.clear(); 
              whichcipher=0;
              whichfunction=0;
              text1.setText("");
            
         });*/
         //back.setOnAction(e -> primaryStage.setScene (scene1));
         HBox box = new HBox();
         box.getChildren().addAll(encrypt,decrypt);
         gridPane.setStyle("-fx-background-color:rgb(60, 179, 113);-fx-padding: 30;-fx-font-size: 14px");
         //label.setStyle("-fx-font-size: 20;");
         label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
      
         scene2 = new Scene(box,700,500);
        // btn.setStyle("-fx-");
      /* Scene scene = new Scene(gridPane,700, 500);
        Scene scene1 = new Scene(gridPane,700, 500);*/
     
       vbox = new VBox();
      vbox.getChildren().addAll(text,inp,send,back,text1);
      scene3 = new Scene(vbox,700,500);
      
     // affinebox = new VBox();
     // affinebox.getChildren().addAll(text,inp,textkey1,inpkey1,textkey2,inpkey2,send,back,text1);
      //affinescene = new Scene(affinebox,700,500);
       
      primaryStage.setTitle("Classical Cipher");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
