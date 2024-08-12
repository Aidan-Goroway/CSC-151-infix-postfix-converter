package proj4;

/**
 * RightParen represents the mathematical operation of the right half of a pair of parentheses.
 *
 * @author Aidan Goroway
 * @version 1.12
 */
public class RightParen implements Token{

    /**
     * Gets the precedence of a left parentheses.
     * @return precedence 0, represented as an int.
     */
    public int priorityCheck() {
        return 0;
    }

    /** Returns the token as a printable String
     *  @return the String version of a right parentheses, ")".
     */
    public String toString(){
        return ")";
    }

    /** Processes the current token. Pops and appends every token in between
     *  the right parentheses and its corresponding left parentheses, before popping itself.
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        String operatorString = "";
        while (!(s.peek() instanceof LeftParen)){ // will pop until reaching the left half of the parentheses.
            operatorString += s.pop();
        }
        s.pop(); // pops the left half of the parentheses, but doesn't append it to the string
        return operatorString;
    }
}
