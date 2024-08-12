package proj4;

/**
 *  @author Aidan Goroway
 *  @version 1.12
 *
 * Our stack that we load tokens into.
 * @param <Token> A token, which our stack is created to hold.
 */
public class Stack<Token> {

    // Constants
    public static final int INITIAL_CAPACITY_10 = 10;
    public static final int START_OF_SEQUENCE = 0;
    public static final int CAPACITY_SIZE_LIMIT = (int) Math.pow(2,20);

    // Instance Variables
    private int size;
    private int capacity = INITIAL_CAPACITY_10;
    private Object[] stackObject;

    /**
     * Constructor.
     */
    public Stack() {
       this.stackObject = new Object[INITIAL_CAPACITY_10];
    }

    /**
     * Updates the capacity of the stack. Due to implementation choices, this is a necessity.
     */
    private void updateCapacity(){
        Object[] replacementArray = new Object[capacity];
        for (int index = START_OF_SEQUENCE; index < size(); index++){
            replacementArray[index] = stackObject[index];
        }
        this.stackObject = replacementArray;
    }

    /**
     * Doubles the capacity and adds 1 to it.
     */
    private void doubleCapacity(){
        capacity = ((getCapacity()*2) + 1);
        if (capacity > CAPACITY_SIZE_LIMIT){
            capacity = CAPACITY_SIZE_LIMIT;
        }
        this.updateCapacity();
    }

    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Determines of the stack is empty.
     * @return True if empty, otherwise false.
     */
    public boolean isEmpty() {
        if ((size() - 1) < 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Places an item on the top of the stack.
     * @param toPush the element being pushed onto the stack.
     */
    public void push(Token toPush) {
        if (size() == getCapacity()){
            doubleCapacity();
        }
        stackInsert(toPush);
    }

    /**
     * Helps with push, privatized for information hiding.
     * @param toPush the element being pushed onto the stack.
     */
    private void stackInsert(Token toPush){
        stackObject[size()] = toPush;
        incrementSize();
    }

    /**
     * Getter for tokens.
     * @param position The position we are getting from on the stock.
     * @return The gotten token.
     */
    private Token tokenGet(int position){
        return (Token) stackObject[position];
    }

    /**
     * Removes the frontmost elemtn from the stack.
     * @return The popped element, null if stack is empty.
     */
    public Token pop() {
        if (!isEmpty()){ // must not be empty
            Token toReturn = tokenGet(size() - 1);
            deIncrementSize();
            return toReturn;
        }
        return null;
    }

    /**
     * Peeks at the next element in the stock.
     * @return The token we have peeked at, null if empty.
     */
    public Token peek() {
        if (!isEmpty()){
            return tokenGet(size() - 1);
        }
        return null;
    }

    /**
     * Getter for size.
     * @return size of the array.
     */
    public int size() {
    	return size;
    }

    /**
     * Increments the size upwards by one.
     */
    private void incrementSize(){
        size += 1;
    }

    /**
     * Decrements the size upwards by one.
     */
    private void deIncrementSize(){
        size -= 1;
    }

    /**
     * ToString method.
     * @return The stack, in String form.
     */
    public String toString() {

        String stackString = "{>";

        for (int index = size() - 1; index >= START_OF_SEQUENCE; index--){ //iterates through stack, from the top down
            stackString += tokenGet(index);

            if (index > START_OF_SEQUENCE){ // as long as token isn't bottom of stack
                stackString += ",";
            }
        }
        stackString += "}";
        return stackString;
    }
} 
