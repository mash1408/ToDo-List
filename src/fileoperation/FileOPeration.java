
package fileoperation;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;

class ToDoList {
   private String yourName;
   int index=0;
    ToDoList(String name){
        yourName=name;
    }
void createList(){
    System.out.println("Enter items into your List\nEnter \"exit\" to quit anytime");
    
try {

  String temp;
 File myObj = new File(System.getProperty("user.home")+"/Documents/"+yourName+".txt");
FileWriter myWriter = new FileWriter(System.getProperty("user.home")+"/Documents/"+yourName+".txt");
Scanner myScan=new Scanner(System.in);
String myList[]=new String[10];
while(true){
   try{ 
     myList[index]=myScan.nextLine();
     temp=myList[index];
       if(myList[index].equals("exit"))
         break;
      index++;
   }
   catch(ArrayIndexOutOfBoundsException e){
     System.out.println("That's enough.\n 10 items ONLY");
     break;
   }
  myWriter.write(index+")"+temp+"\n");
 }
System.out.println("Done with your List");
myWriter.close();

} catch (IOException e) {

System.out.println("An error occurred.");

e.printStackTrace();


}
}
void readList(){
 try {

File myObj = new File(System.getProperty("user.home")+"/Documents/"+yourName+".txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
}
    myReader.close();
} 
catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();

}
    
    
}
void appendList(){
    String temp=null;
    if(index>=10){
        System.out.println("Reached maximum to dos :10");
        return;
    }
    try{
        FileWriter file=new FileWriter(System.getProperty("user.home")+"/Documents/"+yourName+".txt", true);
        BufferedWriter out = new BufferedWriter(file); 
        Scanner myScan=new Scanner(System.in);
        String myList[]=new String[9];
        while(true && index<9){
            try{ 
                myList[index]=myScan.nextLine();
                temp=myList[index];
                if(myList[index].equals("exit"))
                    break;
                index++;
   }
    catch(ArrayIndexOutOfBoundsException e){
         System.out.println("That's enough.\n 10 items ONLY");
         break;
 }
    out.write(index+")"+temp+"\n");
 }
   
   out.close();
    }
    catch (IOException e) { 
            System.out.println("exception occoured" + e); 
} 
}
void deleteList(){
    File myObj = new File(System.getProperty("user.home")+"/Documents/"+yourName+".txt");
    if (myObj.delete()) {
        System.out.println("Deleted the file: " + myObj.getName());
} 
    else {
        System.out.println("Failed to delete the file.");

}
}
}

public class FileOPeration {

    public static void main(String[] args) {
   System.out.println("Welcome to TO DO lIST!!!");
   System.out.println("Let's get your name");
   Scanner myObj= new Scanner(System.in);
   String yourName=myObj.nextLine();
   System.out.println("1-Create List\n2-Append item\n3-Delete lIST\n4-See list\n5-Exit");
 int choice;
   ToDoList item= new ToDoList(yourName);
   do{
         choice=myObj.nextInt();
        switch(choice){
            case 1:
                item.createList();
                    break;
            case 2:
                item.appendList();
                    break;
            case 3:
                item.deleteList();
                    break;
            case 4:
                item.readList();
                    break;
       }
   }while(choice!=5);

}
}
    

