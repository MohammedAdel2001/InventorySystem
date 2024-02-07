package lab4;

import java.time.Duration;
import java.time.LocalDate;


public class EmployeeRole {
   public ProductDatabase productsDatabase = new ProductDatabase("Products.txt");
   public CustomerProductDatabase customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    
    public EmployeeRole()
    {
        this.productsDatabase.readFromFile();
        this.customerProductDatabase.readFromFile();
    }
    
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price)
    {
        this.productsDatabase.insertRecord(new Product(productID,productName,manufacturerName,supplierName,quantity,price));
    }
    
    public Product[] getListOfProducts()
    {
        Product[] p = new Product[this.productsDatabase.returnAllRecords().size()];
        int i = 0;
        while(i < this.productsDatabase.returnAllRecords().size())
        {
            p[i] = this.productsDatabase.returnAllRecords().get(i);
            i+=1;
        }
        
        return p;
    }
    
    public CustomerProduct[] getListOfPurchasingOperations()
    {
        CustomerProduct[] p = new CustomerProduct[this.customerProductDatabase.returnAllRecords().size()];
        int i = 0;
        while(i < this.customerProductDatabase.returnAllRecords().size())
        {
            p[i] = this.customerProductDatabase.returnAllRecords().get(i);
            i+=1;
        }
        
        return p;
    }
    
   public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        int i = 0;
        while(i < this.productsDatabase.returnAllRecords().size())
        {
            if(productID.equals(this.productsDatabase.returnAllRecords().get(i).getProductID()))
            {
                if(this.productsDatabase.returnAllRecords().get(i).getQuantity()==0)
                    {
                        return false;
                    }
                else
                    {
                          this.productsDatabase.returnAllRecords().get(i).setQuantity(this.productsDatabase.returnAllRecords().get(i).getQuantity()-1);
                          this.customerProductDatabase.insertRecord(new CustomerProduct(customerSSN, productID, purchaseDate));
                          this.customerProductDatabase.saveToFile();
                          this.productsDatabase.saveToFile();
                          return true;
                    }
                
            }
            i+=1;
            
        }
        return false;
    }
    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate ,LocalDate returnDate)
    {
        String[] string = purchaseDate.toString().split("-");
        String time = string[2]+"-"+string[1]+"-"+string[0];        
        
        if(Duration.between(purchaseDate.atStartOfDay(), returnDate.atStartOfDay()).toDays() <= 14)
        {
            if(this.productsDatabase.contains(productID))
            {
                if(this.customerProductDatabase.contains(customerSSN+","+productID+","+time))
                {
                    this.productsDatabase.getRecord(productID).setQuantity(this.productsDatabase.getRecord(productID).getQuantity()+1);
                    this.productsDatabase.saveToFile();
                    this.customerProductDatabase.deleteRecord(customerSSN+","+productID+","+time);
                    this.customerProductDatabase.saveToFile();
                    return this.productsDatabase.getRecord(productID).getPrice();
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return -1;
            }
        }
        
        else
        {
            return -1;
        }
    }
    
    public void logout()
    {
        this.customerProductDatabase.saveToFile();
        this.productsDatabase.saveToFile();
    }
    
    
    }

