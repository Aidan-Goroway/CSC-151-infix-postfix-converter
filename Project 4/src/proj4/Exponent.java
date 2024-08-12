package proj4;

/**
 * Exponent represents the mathematical operation of raising to a power.
 *
 * @author Aidan Goroway
 * @version 1.12
 */
public class Exponent implements Token{

    /**
     * Gets the precedence of Exponent.
     * @return precedence 3, represented as an int.
     */
    public int priorityCheck() {
        return 3;
    }

    /** Returns the token as a printable String.
     *  @return the String version of Exponent, "^".
     */
    public String toString(){
        return "^";
    }

    /** Processes the current token. Pushes the token, and pops and appends any tokens of higher precedence under it.
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        String handleString = "";

        while (!s.isEmpty()){
            if (s.peek().priorityCheck() >= this.priorityCheck()){ // if token under this one is of greater precedence
                handleString += s.pop();
            }
            else { // exits loop if token under is of greater precedence
                break;
            }
        }

        s.push(this);
        return handleString;
    }
}
