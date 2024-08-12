package proj4;
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 *
 * @author Aidan Goroway
 * @version 1.12
 */

/**
 * The client. Houses a single "main" method in which a converter object is constructed.
 */
public class Client{
    public static void main(String[] args){
        Converter converter = new Converter("proj4_input.txt");
        converter.convert();
    }
}
