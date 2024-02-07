package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class CustomerProductDatabase  extends database{
    private ArrayList<CustomerProduct>records = new ArrayList<CustomerProduct>(); 
   
    public CustomerProductDatabase(String filename)
    {
        this.filename = filename;
    }
    
    public void readFromFile()
    {
        try
        {
            File f = new File(this.filename);
            Scanner sc = new Scanner(f);
            
            while(sc.hasNextLine())
            {
                String []data = sc.nextLine().split(",");
                String time[] = data[2].split("-");
                CustomerProduct cp = new CustomerProduct(data[0],data[1],LocalDate.parse( time[2]+"-"+time[1]+"-"+time[0]));
                this.records.add(cp);
            }
            
            
        }catch(FileNotFoundException e)
        {
            System.out.println("File not Found");
        }
    }
    
    public CustomerProduct createRecordFrom(String line)
    {
        String data[] = line.split(",");
        String time[] = data[2].split("-");
        CustomerProduct cp = new CustomerProduct(data[0],data[1],LocalDate.parse( time[2]+"-"+time[1]+"-"+time[0]));
        
        
        return cp; 
        
    }
    
    public ArrayList<CustomerProduct> returnAllRecords()
    {
        return this.records;
    }
    
    public boolean contains(String Key )
    {
        int i = 0;
        while(i < this.records.size())
        {
            if(this.records.get(i).getSearchKey().equals(Key))
            {
                return true;
            }
            i+=1;
        }
        return false;
    }
    
    public CustomerProduct getRecord(String Key)
    {
        int i = 0;
        while(i < this.records.size())
        {
            if(this.records.get(i).getSearchKey().equals(Key))
            {
                return this.records.get(i);
            }
            i+=1;
        }
        System.out.println("There is no customer with that key");
        return null;
    }
    
    public void insertRecord(CustomerProduct record)
    {
        this.records.add(record);
    }
    
    public void deleteRecord(String Key)
    {
        int i = 0;
        int flag = 0;
        while(i < this.records.size())
        {
            if(this.records.get(i).getSearchKey().equals(Key))
            {
                this.records.remove(i);
                flag = 1;
            }
            i+=1;
        }
        if (flag == 0)
        {
            System.out.println("There is no customer with that key");
        }
    }
    
    public void saveToFile()
    {
        try
        {
            int i = 0;
            FileWriter f = new FileWriter(this.filename);
            while(i < this.records.size())
            {
                f.write(this.records.get(i).getSearchKey()+"\n");
                i+=1;
            }
            f.close();
        }catch(IOException e)
        {
            System.out.println("error occured");
        }
    }
    
}
