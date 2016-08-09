import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bsiskova on 8/8/16.
 */
public class SeznamTest {


    private RemoteWebDriver webDriver;
    private String inputWord;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.seznam.cz/");
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

    @Test
    public void findSlovnik() {
        WebElement slovnikField = webDriver.findElement(By.linkText("Slovník"));
        slovnikField.click();

       // getUserInput();
        inputWord = "utorok";
        WebElement inputField = webDriver.findElement(By.id("slovnik-field"));
        inputField.sendKeys(inputWord + "\n");

        try {
            String results = webDriver.findElement(By.id("fastMeanings")).getText();
            String arr[] = results.split("\n|,", 2);
            String firstWord = arr[0];
            System.out.println(firstWord);
        } catch (NoSuchElementException e){
            System.out.print("Slovo sa nenachadza v slovniku");
        }


    }

    private void getUserInput(){

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

}