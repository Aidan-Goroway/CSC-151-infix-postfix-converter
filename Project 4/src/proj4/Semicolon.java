package proj4;

/**
 * Semicolon represents a semicolon.
 *
 * @author Aidan Goroway
 * @version 1.12
 */
public class Semicolon implements Token{

    /**
     * Gets the precedence of a semicolon.
     * @return precedence 0, represented as an int.
     */
    public int priorityCheck() {
        return 0;
    }

    /** Returns the token as a printable String.
     *  @return the String version of a semicolon, ";".
     */
    public String toString(){
        return ";";
    }

    /** Processes the current token. Pops and appends any remaining tokens in the
     *  stack that have not yet been processed.
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        String completeString = "";
        while (!s.isEmpty()){ // pops and appends any elements remaining
            completeString += s.pop();
        }
        return completeString;
    }
}
