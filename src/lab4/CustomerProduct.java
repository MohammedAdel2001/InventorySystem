package lab4;

import java.time.LocalDate;


public class CustomerProduct {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }
    
    public String getCustomerSSN()
    {
        return this.customerSSN;
    }
    
    public String getProductID()
    {
        return this.productID;
    }
    public LocalDate getPurchaseDate()
    {
        return this.purchaseDate;
    }
    
    public String lineRepresentation()
    {
        return this.customerSSN+","+this.productID+","+this.purchaseDate;
    }
    
    public String getSearchKey()
    {
        String string=this.purchaseDate.toString();
        String t[] = string.split("-");
        
        return this.customerSSN+","+this.productID+","+t[2]+"-"+t[1]+"-"+t[0];
    }
    
}
