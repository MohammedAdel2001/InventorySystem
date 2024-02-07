package lab4;

import java.io.FileWriter;
import java.io.IOException;


public class AdminRole {
    private EmployeeUserDatabase database = new EmployeeUserDatabase("Employee.txt");
    public AdminRole()
    {
        this.database.readFromFile();
    }
    
    public void addEmployee(String EmployeeId, String Name, String Email, String Address, String phoneNumber) throws IOException
    {
        EmployeeUser e = new EmployeeUser(EmployeeId, Name, Email, Address, phoneNumber);
        database.insertRecord(e);
       
    }
    
    public EmployeeUser[] getListOfEmployees()
    {
        EmployeeUser[] arr = new EmployeeUser[this.database.returnAllRecords().size()];
        int i = 0;
        while(i < database.returnAllRecords().size())
        {
            arr[i] = database.returnAllRecords().get(i);
            i+=1;
        }
        
        return arr;
    }
    
    public void removeEmployee(String Key) throws IOException
    {
        this.database.deleteRecord(Key);
        this.database.saveOfToFile();
    }
    
    public void logout() throws IOException
    {
        this.database.saveOfToFile();
    }
    public EmployeeUserDatabase data(){
        return this.database;
    }
}
