package lab4;


public class EmployeeUser {
    private String employeeId;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;
    
    public EmployeeUser(String employeeId, String Name, String Email, String Address, String PhoneNumber)
    {
        this.employeeId = employeeId;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }
    
    public String lineRepresentation()
    {
        return this.employeeId+","+this.Name+","+this.Email+","+this.Address+","+this.PhoneNumber;
    }
    
    public String getSearchKey()
    {
        return this.employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

}
