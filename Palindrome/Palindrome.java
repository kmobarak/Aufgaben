public class Palindrome {

    public static boolean isPalindrome(String text) {  // Nimmt einen String Parameter namens text und gibt einen boolean Wert zurück.
        String ignore = text.toLowerCase().replaceAll("[\\W_ ]", ""); //Ignorieren von Groß- und Kleinschreibung, Leerzeichen und Satzzeichen.


        switch (ignore.getClass().getSimpleName()) { //  die case in einen String umwandeln





            case "Integer":
                ignore = ignore.toString();
                break;
            case "boolean":
                ignore = null;
                break;
            case "String":
                // no need to do anything
                break;

        }




        int length = ignore.length(); //erstellt eine neue integer variable namens length und setzt sie auf die Länge des ignore Strings.

        for (int i = 0; i < length/2; i++){ //iteriert von 0 bis zur Hälfte der Länge von ignore





            char c = text.charAt(i); //creates a new character variable c and sets it to the character at position i in the original text string.
            if(ignore.charAt(i) != ignore.charAt(length - i - 1)) { //Überprüft, ob das Zeichen an der Position "i" in "ignore" nicht gleich dem Zeichen an der Position "length - i - 1" ist (The corresponding character from the end of the string)

                System.out.println(ignore);
                return false;
            }

            }



            return true;
        }

        public static void main(String[] args) {
            // TODO: test
            System.out.println(isPalindrome("Ka jak"));



        }
    }
