package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class hw_04 {
    //1. Bir class oluşturun: LocatorsIntro
    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    // a. http://a.testaddressbook.com adresine gidiniz.
    // b. Sign in butonuna basin
    // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    // i. Username : testtechproed@gmail.com
    // ii.Password : Test1234!
    // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    //3. Sayfada kac tane link oldugunu bulun.
    //4.Linklerin yazisini nasil yazdirabiliriz
    //5. driver i kapatin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@id='sign-in']")).click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextbox= driver.findElement(By.xpath("//input[@id='session_email']"));
        WebElement passwordTextbox= driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signInButton= driver.findElement(By.xpath("//input[@name='commit']"));


        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        // ii.Password : Test1234!

        emailTextbox.sendKeys("testtechproed@gmail.com");
        passwordTextbox.sendKeys("Test1234!");
        signInButton.click();

        // e. Expected user id nin  oldugunu dogrulayin(verify).
        String actualUserId = driver.findElement(By.xpath("//span[@class='navbar-text']")).getText();;
        String expectedUserId="testtechproed@gmail.com";

        if (actualUserId.contains(expectedUserId)){
            System.out.println("User id testi PASS");
        }else{
            System.out.println("User id testi FAILED");
        }

        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses= driver.findElement(By.xpath("//a[@data-test='addresses']"));
        WebElement signOut= driver.findElement(By.xpath("//a[@data-test='sign-out']"));

        if (addresses.isDisplayed()){
            System.out.println("Addresses gorunurluk testi PASS");
        }else {
            System.out.println("Addresses gorunurluk testi FAILED");
        }

        if (signOut.isDisplayed()){
            System.out.println("Sign Out gorunurluk testi PASS");
        }else {
            System.out.println("Sign Out gorunurluk testi FAILED");
        }

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkSayisi=driver.findElements(By.tagName("a"));
        System.out.println(linkSayisi.size());

        //4.Linklerin yazisini nasil yazdirabiliriz
        for (WebElement each: linkSayisi){
            System.out.println(each.getText());
        }

        //5. driver i kapatin
        driver.close();

    }
}
