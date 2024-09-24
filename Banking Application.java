import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
class BankWork {
 // initialize and declare objects.
 final intmax_limit = 20;
 final intmin_limit = 1;
 final double min_bal = 500;
 private String name[] = new String[20];
 private intaccNo[] = new int[20];
 private String accType[] = new String[20];
 private double balamount[] = new double[20];
 static inttotRec = 0;
 // create a constructor here of Bank.
BankWork() {
 for (inti = 0; i<max_limit; i++) {
 name[i] = "";
accNo[i] = 0;
accType[i] = "";
balamount[i] = 0.0;
 }
 }
 // Create method to create New entry.
 public void newEntry() {
 String str;
int account;
 double amount;
boolean permit;
 permit = true;
 if (totRec>max_limit) {
 System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
 permit = false;
 }
 // create new entry.
 if (permit = true) {
totRec++;
10
 // Incrementing Records
 System.out.println("\n\n\n=====SAVING NEW ENTRY=====");
 try {
accNo[totRec]=totRec;
 System.out.println("->Account Number : " + accNo[totRec]);
 // create object.
 BufferedReader obj = new BufferedReader(new
InputStreamReader(System.in));
 // enter the name of customer here.
 System.out.print("->Enter the name of the Customer : ");
System.out.flush();
 name[totRec] = obj.readLine();
 // enter the type of account.
 System.out.print("->Enter Account Type : ");
System.out.flush();
accType[totRec] = obj.readLine();
 do {
 // enter the starting amount.
 // minimum amount must be 1000.
 System.out.print("->Enter Initial Amount to be deposited : ");
System.out.flush();
str = obj.readLine();
balamount[totRec] = Double.parseDouble(str);
 }
 while (balamount[totRec] <min_bal);
 System.out.println("\n\n\n");
 } catch (Exception e) {
 System.out.println("->Exception in Entering a record.....");
 }
 }
 }
 // create method to display records.
 public void display() {
 String str;
int account = 0;
boolean valid = true;
 try {
 // create object.
 BufferedReader obj = new BufferedReader(new
11
InputStreamReader(System.in));
 // enter account number.
 System.out.print("->Enter the account number for display record : ");
System.out.flush();
str = obj.readLine();
 account = Integer.parseInt(str);
 // check for valid account number
 if (account <min_limit || account >totRec) {
 System.out.println("\n\n\nInvalid Account Number \n\n");
 valid = false;
 }
 if (valid == true) {
SimpleDateFormat formatter = new
SimpleDateFormat("dd/MM/yyyyHH:mm:ss");
 Date date = new Date();
 System.out.println("-------------------------------------");
 System.out.println("\n\n=====DISPLAYING THE
RECORDS=====\n");
 System.out.println( formatter.format(date) );
 System.out.println("\nAccount Number : " + accNo[account]);
 System.out.println("Name : " + name[account]);
 System.out.println("Account Type : " + accType[account]);
 System.out.println("Balance Amount : " + balamount[account] + "\n\n");
 System.out.println("-------------------------------------");
 }
 } catch (Exception e) {
 System.out.println("Exception in Displaying record.....");
 }
 }
 // create method to deposit amount.
 public void deposit() {
 String str;
 double amount;
int account;
boolean valid = true;
 try {
 // create object.
SimpleDateFormat formatter = new
SimpleDateFormat("dd/MM/yyyyHH:mm:ss");
 Date date = new Date();
 BufferedReader obj = new BufferedReader(new
InputStreamReader(System.in));
12
 System.out.print("Enter Account No : ");
System.out.flush();
str = obj.readLine();
 account = Integer.parseInt(str);
 // check valid account number.
 if (account <min_limit || account >totRec) {
 System.out.println("\n\n\nInvalid Account Number \n\n");
 valid = false;
 }
 if (valid == true) {
 System.out.print("Enter Amount you want to Deposit : ");
System.out.flush();
str = obj.readLine();
 amount = Double.parseDouble(str);
 String filePath = "E:\\javaproject\\New folder\\";
 String fileName = "Account";
 String fileType = "txt";
 File myFile = new File(filePath + fileName + account + "." + fileType);
FileOutputStreamfout=new FileOutputStream(myFile,true);
 fout.write("Date\t".getBytes());
 fout.write(formatter.format(date).getBytes());
 fout.write("\n".getBytes());
 fout.write("\namount deposited\t".getBytes());
 fout.write(Double.toString(amount).getBytes());
 fout.write("\n".getBytes());
balamount[account] = balamount[account] + amount;
 //Displaying Depsit Details
 System.out.println("-------------------------------------");
 System.out.println(" \n=====DEPOSIT AMOUNT===== ");
 System.out.println("Account Number : " + account);
 System.out.println("Balance Amount : " + balamount[account] +
"\n\n\n");
 System.out.println("-------------------------------------");
 }
 } catch (Exception e) {
 System.out.println("Exception in Depositing record.....");
 }
 }
 public void view_trans(){
 String str;
 double amount;
int account;
boolean valid = true;
13
 try {
 // create object.
SimpleDateFormat formatter = new
SimpleDateFormat("dd/MM/yyyyHH:mm:ss");
 Date date = new Date();
 BufferedReader obj = new BufferedReader(new
InputStreamReader(System.in));
 System.out.print("Enter Account No : ");
System.out.flush();
str = obj.readLine();
 account = Integer.parseInt(str);
 // check valid account number.
 if (account <min_limit || account >totRec) {
 System.out.println("\n\n\nInvalid Account Number \n\n");
 valid = false;
 }
 if (valid == true) {
 String filePath = "E:\\javaproject\\New folder\\";
 String fileName = "Account";
 String fileType = "txt";
 File myFile = new File(filePath + fileName + account + "." + fileType);
FileInputStreamfout=new FileInputStream(myFile);
inti;
 System.out.println("-------------------------");
 while((i=fout.read())!=-1){
 System.out.print((char)i);
 }
 System.out.println("-------------------------");
 }
 }
 catch (Exception e) {
 System.out.println("Exception in Depositing record.....");
 }
 }
 // creating method for withdraw money.
 public void withdraw() {
 String str;
 double amount, checkamount;
int account;
14
boolean valid = true;
 System.out.println("\n\n\n=====WITHDRAW MONEY=====");
 try {
 // create object.
SimpleDateFormat formatter = new
SimpleDateFormat("dd/MM/yyyyHH:mm:ss");
 Date date = new Date();
 BufferedReader obj = new BufferedReader(new
InputStreamReader(System.in));
 // enter account number for entering money
 System.out.print("Enter the account number to withdraw money : ");
System.out.flush();
str = obj.readLine();
 account = Integer.parseInt(str);
BufferedWriterbw=new BufferedWriter(new
FileWriter("E:\\javaproject\\withdraws.txt",true));
 // check for valid account number.
 if (account <min_limit || account >totRec) {
 System.out.println("\n\n\nInvalid Account Number \n\n");
 valid = false;
 }
 if (valid == true) {
 System.out.println("Balance is : " + balamount[account]);
 System.out.print("Enter Amount you want to withdraw : ");
System.out.flush();
str = obj.readLine();
 amount = Double.parseDouble(str);
 String filePath = "E:\\javaproject\\New folder\\";
 String fileName = "Account";
 String fileType = "txt";
checkamount = balamount[account] - amount;
 File myFile = new File(filePath + fileName + account + "." + fileType);
FileOutputStreamfout=new FileOutputStream(myFile,true);
 fout.write("Date\t".getBytes());
 fout.write(formatter.format(date).getBytes());
 fout.write("\n".getBytes());
 fout.write("\namount withdrawn:\t".getBytes());
 fout.write(Double.toString(amount).getBytes());
 fout.write("\nTotal amount:\t".getBytes());
 fout.write(Double.toString(checkamount).getBytes());
 fout.write("\n".getBytes());
checkamount = balamount[account] - amount;
15
 if (checkamount>= min_bal) {
balamount[account] = checkamount;
 // Updating the amount after withdraw.
 System.out.println("-------------------------------------");
 System.out.println(" \n=====WITHDRAW MONEY===== ");
 System.out.println("Account Number : " + account);
 System.out.println("Balance Amount : " + balamount[account] +
"\n\n\n");
 System.out.println("-------------------------------------");
 } else {
 System.out.println("\n\nAs per Bank Rule you should maintain
minimum balance of Rs 500\n\n\n");
 }
 }
 } catch (Exception e) {
 System.out.println("Exception in Withdrawing record.....");
 }
 }
};
public class BankDemo {
 public static void main(String args[]) {
 String str;
int choice;
 choice = 0;
BankWorkBW_obj = new BankWork();
 do {
 // creating Menu.
SimpleDateFormat formatter = new
SimpleDateFormat("dd/MM/yyyyHH:mm:ss");
 Date date = new Date();
 System.out.println("===============================");
 System.out.println("-----ONLINE BANKING SYSTEM-----");
 System.out.println(" "+formatter.format(date)+" ");
 System.out.println("Choose Your Choices ...");
 System.out.println("1) New Record Entry ");
 System.out.println("2) Display Record Details ");
 System.out.println("3) Deposit...");
 System.out.println("4) Withdraw...");
 System.out.println("5)view Transcations");
 System.out.println("6) Exit");
 System.out.println("--------------------------------");
 System.out.println("================================");
 System.out.print("Enter your choice : ");
System.out.flush();
 try {
16
 // creating objects.
 BufferedReader obj = new BufferedReader(new
InputStreamReader(System.in));
str = obj.readLine();
 choice = Integer.parseInt(str);
 switch (choice) {
 case 1:
 // for new entry.
BW_obj.newEntry();
 break;
 case 2:
 // for display.
BW_obj.display();
 break;
 case 3:
 // for deposit.
BW_obj.deposit();
 break;
 case 4:
 // for display.
BW_obj.withdraw();
 break;
 case 5:
BW_obj.view_trans();
 break;
 case 6:
 System.out.println("\n\n.....THANKS FOR VISITING.....");
 break;
 default:
 System.out.println("\nInvalid Choice \n\n");
 }
 } catch (Exception e) {
 System.out.println("Exception in Main....");
 }
 }
 while (choice != 6);
 }
}