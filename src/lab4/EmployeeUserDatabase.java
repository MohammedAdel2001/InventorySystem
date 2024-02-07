
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class EmployeeUserDatabase {
    
    private ArrayList<EmployeeUser> records = new ArrayList<EmployeeUser>();
    private String filename;
    
    public EmployeeUserDatabase(String filename)
    {
        this.filename = filename;
    }
    
    public void readFromFile()
    {   int i = 0;
        try
        {
            File f = new File(this.filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine())
            {
                String [] data = sc.nextLine().split(",");
                EmployeeUser e = new EmployeeUser(data[0],data[1],data[2],data[3],data[4]);
                records.add(e);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File doesn't exist");
        }
        
    }
    
    public EmployeeUser createRecordFrom(String line)
    {
        String data[] = line.split(",");
        EmployeeUser e = new EmployeeUser(data[0],data[1],data[2],data[3],data[4]);

        return e;
    }
    
    public ArrayList<EmployeeUser> returnAllRecords()
    {
        return this.records;
    }
    
    public boolean contains(String Key)
    {
        int size = this.records.size();
        int i = 0;
        
        while(i < size)
        {
            if(records.get(i).getSearchKey().equals(Key))
            {
                return true;
            }
            
            i+=1;
        }
        return false;
            
    }
    
    public EmployeeUser getRecord(String Key)
    {
        
        int size = this.records.size();
        int i = 0;
        
        while(i < size)
        {
            if(records.get(i).getSearchKey().equals(Key))
            {
                return records.get(i);
            }
            
            i+=1;
        }
        System.out.println("There is no employee with this id");
        return null;
    }
    
    public void insertRecord(EmployeeUser record)
    {
        if(this.contains(record.getSearchKey()))
        {
            System.out.println("Sorry ! Id is already taken");
        }
        else
        {
            this.records.add(record);
        }
    }
    
    public void deleteRecord(String Key)
    {
        
        int i = 0;
        int flag = 0;
        
        while(i < this.records.size())
        {
            if(this.records.get(i).getSearchKey().equals(Key))
            {
                records.remove(this.records.get(i));
                flag = 1;
            }
            
            i+=1;
        }
        if(flag == 0)
        {
            System.out.println("There is no employee with that id");
        }
        
    }
    
    public void saveOfToFile() throws IOException
    {
        int size = this.records.size();
        int i = 0;
        
        try
        {
            FileWriter f = new FileWriter(this.filename);
            while(i < size)
            {
                f.write(this.records.get(i).getSearchKey()+","+this.records.get(i).getName()+","+this.records.get(i).getEmail()+","+this.records.get(i).getAddress()+","+this.records.get(i).getPhoneNumber()+"\n");
                i+=1;
            }
            f.close();
        }catch(IOException e)
        {
            System.out.println("error occupied");
        }
        
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
    
}
