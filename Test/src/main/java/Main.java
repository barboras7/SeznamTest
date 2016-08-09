/**
 * Created by bsiskova on 8/9/16.
 */
public class Main {

    public static void main(String[] args){

        SeznamSlovnik seznamSlovnik = new SeznamSlovnik();

        seznamSlovnik.setUp();
        seznamSlovnik.getUserInput();
        seznamSlovnik.translate();
        seznamSlovnik.tearDown();
    }
}
