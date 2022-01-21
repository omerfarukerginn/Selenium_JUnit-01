package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_SearchTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameBox=driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameBox.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        System.out.println(ilkUrun.getText());
        ilkUrun.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrunIsmiElementi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrunIsmi=sepettekiUrunIsmiElementi.getText();

        if (ilkUrun.equals(sepettekiUrunIsmi)){
            System.out.println("Alisveris testi PASS");
        }else {
            System.out.println("Alisveris testi FAILED");
        }

        //9. Sayfayi kapatin
        driver.close();





    }
}
