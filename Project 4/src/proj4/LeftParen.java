package proj4;

/**
 * LeftParen represents the mathematical operation of the left half of a pair of parentheses.
 *
 * @author Aidan Goroway
 * @version 1.12
 */
public class LeftParen implements Token{

    /**
     * Gets the precedence of a left parentheses.
     * @return precedence 0, represented as an int.
     */
    public int priorityCheck() {
        return 0;
    }

    /** Returns the token as a printable String
     *  @return the String version of a left parentheses, "(".
     */
    public String toString(){
        return "(";
    }

    /** Processes the current token. Pushes the token and takes no other action.
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        s.push (this);
        return ""; // a string is not really needed, because parenthesis do not occur in postfix notation.
    }
}
