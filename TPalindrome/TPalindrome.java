
import aud.Stack;

public class TPalindrome {
    // Test if text is a T-palindrome.
    // The input is guaranteed to include only valid characters, i.e.,
    // those in {'a',...,'z','(',')','*'}. You don't need to check this.

    public static boolean isTPalindrome(String text) {
        // TODO: implementation
        Stack<Character> st = new Stack<>(); // einen neuen Stack vom Typ 'Character' erzeugen
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ')') {

                StringBuilder sb = new StringBuilder();
                for (int j = i - 1; j >= 0 && st.top() != '('; j--) {
                    sb.append(st.pop());
                }
                if (st.is_empty()) {
                    return false;
                }
                st.pop();

                String subtext = sb.toString();
                if (isTPalindrome(subtext)) {
                    st.push('*');
                }

                else {
                    return false;
                }
            }

            else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.is_empty()) {
            sb.append(st.pop());
        }

        return isPalindrome(sb.toString());
    }

    private static boolean isPalindrome(String text) {  // checks for a normal palindrome
        // and used in TPalindrome method after the string is built in the end
        for (int i = 0, j = text.length() - 1; i < j; i++, j--) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO: test
        String text = "al(otto)la";
        boolean isPalindrome = isPalindrome(text);
        System.out.println(isPalindrome);
    }

    }

