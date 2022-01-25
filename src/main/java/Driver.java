import java.time.LocalDate;

public class Driver {
    public static void main(String[] args) {
        Customer firstCustomer = new Customer(
                "Muhammad QAnwarul Azim",
                "anwarulazimgmail.com",
                "01956367257",
                LocalDate.of(2010,12,1)
        );

        RegistrationValidator.Output result = RegistrationValidator.isValidEmail()
                .and(RegistrationValidator.isValidPhoneNo())
                .and(RegistrationValidator.isValidAge())
                .apply(firstCustomer);
        System.out.println(result);



    }
}
