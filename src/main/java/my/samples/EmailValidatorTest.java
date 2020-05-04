package my.samples;

/**
 * Email validator Testing
 * 
 * @author anand
 * 
 */
public class EmailValidatorTest {

	public String[] validEmailProvider() {
		return new String[] { "anand@yahoo.com",
			"anand-100@yahoo.com", "anand.100@yahoo.com",
			"anand111@anand.com", "anand-100@anand.net",
			"anand.100@anand.com.au", "anand@1.com",
			"anand@gmail.com.com", "anand+100@gmail.com",
			"anand-100@yahoo-test.com" };
	}

	public String[] invalidEmailProvider() {
		return new String[] { 
				"", 							//EMAIL is blank
				"NOEMAIL",  					//EMAIL = NOEMAIL
				"asbabc.com",  					//EMAIL without @
				"an,and@abc.my", 				//EMAIL contains ,
				"anand@a,bc.my", 				//EMAIL contains ,
				"an?and@abc.my", 				//EMAIL contains ?
				"anand@ab?c.my", 				//EMAIL contains ?
				"@ananabc.my", 					//EMAIL starts with @
				"anand***@***abc.com",			//EMAIL contains ***@***
				"anand@ab@c.com",				//Second part of email address (i.e. after @) contains '@'
				"anand@abccom",					//Second part of email address (i.e. after @) without '.'
				"@abc.com",						//Email address only contains second part of email address
				"abc.com",						//Email address only contains second part of email address
				"anand@",						//Second part of email address (i.e. after @) is absence
				"anand@abc.",					//Email address ends with '.'
				"anand@a bc.com",				//Email address contains space
				"ana nd@abc.com",				//Email address contains space
				"anand@abc.co m",				//Email address contains space
				"ana~nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana`nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana!nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana#nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana$nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana%nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana^nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana&nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana*nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana(nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana)nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana+nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"anand@a+bc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"anand@abc.c+om",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana=nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana\\nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana/nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana?nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana,nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana<nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana>nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana{nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana}nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana[nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana]nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana|nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana:nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana'nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"ana\"nd@abc.com",				//Email address contains any of following characters ( ~`!#$%^&*()+=/\?,<>{}[]|:'")
				"anand.s.n@abc.com.m1y",  					//Invalid
				"anand.s.n@abc.com",  					//Valid
				"anand.s.n@abc.com.my",  					//Valid
				"anand.s.n@abc.com.myy",  					//Valid
				"NO@EMAIL.ADDR"					//EMAIL uppercase = NO@EMAIL.ADDR
			 };
	}

	public void validEmailTest(String[] Email) {

		for (String temp : Email) {
			boolean valid = EmailValidator.validate(temp);
			System.out.println(temp + " validityyy = \t\t\t"+ valid);
		}

	}

	public void inValidEmailTest(String[] Email) {

		for (String temp : Email) {
			boolean valid = EmailValidator.validate(temp);
			System.out.println("Email ["+ temp + "] validity = \t\t"+ valid);
		}
	}
	
	
    public static void main(String[] args) {
		EmailValidatorTest emailValidatorTest = new EmailValidatorTest();
		//emailValidatorTest.validEmailTest(emailValidatorTest.validEmailProvider());
		emailValidatorTest.inValidEmailTest(emailValidatorTest.invalidEmailProvider());
	}
	
}