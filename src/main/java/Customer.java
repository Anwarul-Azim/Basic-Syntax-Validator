import java.time.LocalDate;

public class Customer {
    
    private String name;
    private String email;
    private String phoneNo;
    private LocalDate dateOfBirth;

    public Customer(String name, String email, String phoneNo, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
