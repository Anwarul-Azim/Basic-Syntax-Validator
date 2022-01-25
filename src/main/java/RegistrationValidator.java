import java.time.LocalDate;
import java.time.Period;
import java.util.function.*;

public interface RegistrationValidator extends Function<Customer, RegistrationValidator.Output> {
    static RegistrationValidator isValidEmail() {
        return Customer -> (Customer.getEmail().contains("@"))
                ?
                Output.SUCCESS : Output.INVALID_EMAIL;
    }

    static RegistrationValidator isValidPhoneNo() {
        return Customer -> (Customer.getPhoneNo().startsWith("01") &&
                Customer.getPhoneNo().length() == 11)
                ?
                Output.SUCCESS : Output.INVALID_PHONE_NO;
    }

    static RegistrationValidator isValidAge() {
        return Customer -> (Period.between(Customer.getDateOfBirth(), LocalDate.now()))
                .getYears() > 18
                ?
                Output.SUCCESS : Output.UNDERAGE;
    }

    default RegistrationValidator and (RegistrationValidator other) {
        return customer -> {
            Output result = this.apply(customer);
            return result.equals(Output.SUCCESS) ?
                    other.apply(customer) : result;
        };
    }




    public enum Output {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PHONE_NO,
        UNDERAGE
    }

}
