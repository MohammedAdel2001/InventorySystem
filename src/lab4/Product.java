package lab4;


public class Product {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;
    
    public Product(String productId, String productName, String manufacturerName, String supplierName, int quantity, float price)
    {
        this.productID = productId;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    
    public int getQuantity()
    {
        return this.quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public String lineRepresentation()
    {
        return this.productID+","+this.productName+","+this.manufacturerName+","+this.supplierName+","+this.quantity+","+this.price;
    }
    
    public String getSearchKey()
    {
        return this.productID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public float getPrice() {
        return price;
    }
    
    
    
    
}
