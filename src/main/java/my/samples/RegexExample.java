package my.samples;

public class RegexExample {
	
	public static void main(String[] args) {
		RegexExample.example1();
	}
	
	public static void example1() {
		String str = "Regex to find a specific bWEDDG word in a string in java";
		System.out.println(str.matches(".*?\\bWEDDING\\b.*?"));
		
		String str2 = "Regex to find a specific bWEDDING word in a string in java";
		System.out.println(str2.matches(".*?WEDDING.*?"));
		
		String str3 = "print a word WEDDING if you found";
		System.out.println(str3.matches(".*?\\bWEDDING\\b.*?"));
		
		String str4 = "Regex to find a specific bWEDDINGword in a string in java";
		System.out.println(str4.matches(".*WEDDING.*"));
	}



}
