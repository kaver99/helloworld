import org.apache.commons.validator.EmailValidator;

public class EmailValidatorTest {

	public static void main(String[] args) {
		EmailValidator emailValidator = EmailValidator.getInstance();
		String csvColumnData = "speedparty@hanmail.net";
		Boolean chkEmail = emailValidator.isValid(csvColumnData);
		System.out.println("chkEmail : " + chkEmail);
	}
}
