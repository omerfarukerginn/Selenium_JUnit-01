package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {

    WebDriver driver;

    @Test
    public void test01(){
        // amazon.com'a gidelim ve Title'in "amazon" icerdiğini test edelim
    driver.get("https://www.amazon.com");
    String actualTitle=driver.getTitle();
    String arananKelime="amazon";

    if (actualTitle.contains(arananKelime)){
        System.out.println("amazon testi PASS");
    }else {
        System.out.println("amazon testi FAILED");
    }

    }

    @Test
    public void test02(){
        // google'a gidelim ve basligin "google" icerdigini test edelim
        driver.get("https://www.google.com");
        String actualTitle=driver.getTitle();
        String arananKelime="google";

        if (actualTitle.contains(arananKelime)){
            System.out.println("google testi PASS");
        }else {
            System.out.println("google testi FAILED");
        }

    }

    @Before
    public void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void ortaligiTopla(){
        driver.close();
    }




}
