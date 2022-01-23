package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class hw_05 {

    WebDriver driver;

    //● https://www.amazon.com/ adresine gidin.
//            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin

        @Test
                public void test01(){

            driver.get("https://www.amazon.com/");

            List<WebElement> kategoriSayisi=driver.findElements(By.tagName("option"));

            if (kategoriSayisi.size()==45){
                System.out.println("amazon kategori sayisi testi PASS");
            }else {
                System.out.println("amazon kategori sayisi testi FAILED");
            }

        }


//-Test 2
//            1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test02(){
            driver.get("https://www.amazon.com/");
            driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        System.out.println(driver.findElement(By.xpath("//span[@dir='auto'][1]")).getText());

        String sonucKutusu=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String arananSonuc="Java";

        if (sonucKutusu.contains(arananSonuc)){
            System.out.println("Sonuc " + arananSonuc + " kelimesini iceriyor. PASS");
        }else {
            System.out.println("Sonuc " + arananSonuc + " kelimesini icermiyor. FAILED");
        }

    }




    @Before
    public void ayarlar(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void kapanis(){
            driver.close();
    }


}
