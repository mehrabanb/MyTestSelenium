
public class JavaTest {  
	/*Question: Write a Java code to find the length of the last word of a given string. The string contains upper/lower-case alphabets and empty space characters
String: "The longest word in any of the major English language dictionaries is pneumonoultramicroscopicsilicovolcanoconiosis" */
	
 public static void main(String[] args) {
        String str1 = "The longest word in any of the major English language dictionaries is pneumonoultramicroscopicsilicovolcanoconiosis";
		System.out.println("Original String: "+str1);
        System.out.println("Length of the last word of the above string: "+length_Of_last_word(str1));
    }

    public static int length_Of_last_word(String str1) {
        int length_word = 0;
        String[] words = str1.split(" ");
        if(words.length>0) {
            length_word = words[words.length-1].length();			
        } else {
            length_word = 0;
        }
        return length_word;
    }
}	