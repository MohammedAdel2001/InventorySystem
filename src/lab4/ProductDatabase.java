package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductDatabase extends database {
    private ArrayList<Product>records = new ArrayList<Product>();
    
    
    public ProductDatabase(String filename)
    {
        this.filename = filename;
    }
    @Override
    public void readFromFile()
    {
        try
        {
            File f = new File(this.filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine())
            {
                String[] data = sc.nextLine().split(",");
                Product p = new Product(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Float.parseFloat(data[5]));
                records.add(p);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
    
    
    public Product createRecordFrom(String line)
    {
        String []data = line.split(",");
        Product p = new Product(data[0], data[1], data[2], data[3], Integer.parseInt(data[5]), Float.parseFloat(data[5]));

        return p;
    }
    
    public ArrayList<Product> returnAllRecords()
    {
        return this.records;
    }
    
    public boolean contains(String Key)
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
    public Product getRecord(String Key)
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
        return null;
    }
    
    public void insertRecord(Product record)
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
        while (i < this.records.size())
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
            System.out.println("There is no Product with this id");
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
                f.write(this.records.get(i).getSearchKey()+","+this.records.get(i).getProductName()+","+this.records.get(i).getManufacturerName()+","+this.records.get(i).getSupplierName()+","+this.records.get(i).getQuantity()+","+this.records.get(i).getPrice()+"\n");
                i+=1;
            }
            f.close();
            
        }catch(IOException e)
        {
            System.out.println("Error occupied in write in file");
        }
    }
    
}
