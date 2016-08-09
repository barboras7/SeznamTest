import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bsiskova on 8/9/16.
 */

public class SeznamSlovnik {

    private RemoteWebDriver webDriver;
    private String inputWord;


    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.seznam.cz/");
    }

    public void getUserInput(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Zadajte pozadovane slovo: ");

        try {
            inputWord = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Vlozili ste:" + inputWord);

        try {
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


    public void translate() {
        WebElement slovnikField = webDriver.findElement(By.linkText("Slovník"));
        slovnikField.click();

        WebElement inputField = webDriver.findElement(By.id("slovnik-field"));
        inputField.sendKeys(inputWord + "\n");

        try {
            String results = webDriver.findElement(By.id("fastMeanings")).getText();
            String arr[] = results.split("\n|,", 2);
            String firstWord = arr[0];
            System.out.println("Preklad vlozeneho slova je:" +firstWord);
        } catch (NoSuchElementException e){
            System.out.print("Slovo sa nenachadza v slovniku");
        }
    }


    public void tearDown() {
        webDriver.close();
    }

}
