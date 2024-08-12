package proj4;

/**
 * Plus represents the mathematical operation of addition.
 * 
 * @author Aidan Goroway
 * @version 1.12
 */
public class Plus implements Token {

    /**
     * Gets the precedence of Plus.
     * @return precedence 1, represented as an int.
     */
    public int priorityCheck() {
        return 1;
    }

    /** Returns the token as a printable String.
     *  @return the String version of the Plus, "+".
     */
    public String toString(){
    	return "+";
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
