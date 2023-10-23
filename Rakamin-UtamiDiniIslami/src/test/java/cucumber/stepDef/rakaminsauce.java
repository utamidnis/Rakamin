package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class rakaminsauce {
    WebDriver driver;

    @Given("User berada di halaman login Sauce Demo")
    public void userBeradaDiHalamanLoginSauceDemo() {
        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("User menginput username dan password yang valid")
    public void userMenginputUsernameDanPasswordYangValid() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("secret_sauce");
    }

    @And("User klik tombol login")
    public void userKlikTombolLogin() {
        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();
    }

    @Then("User berhasil login dan dapat melihat katalog produk")
    public void userBerhasilLoginDanDapatMelihatKatalogProduk() {
        WebElement assertion = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        assertion.isDisplayed();

        driver.close();
    }

    @When("User menginput username dan password yang invalid")
    public void userMenginputUsernameDanPasswordYangInvalid() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("123");
    }

    @Then("User mendapatkan pesan error")
    public void userMendapatkanPesanError() {
        WebElement assertion = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
        assertion.isDisplayed();

        driver.close();
    }

    @Given("User login ke website Sauce Demo")
    public void userLoginKeWebsiteSauceDemo() {
        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("secret_sauce");

        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();

        WebElement assertion = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        assertion.isDisplayed();
    }

    @When("User menambahkan beberapa produk ke keranjang")
    public void userMenambahkanBeberapaProdukKeKeranjang() {
        WebElement item1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        item1.click();

        WebElement item2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        item2.click();
    }

    @Then("Keranjang user terdapat produk yang dipilih")
    public void keranjangUserTerdapatProdukYangDipilih() {
        WebElement cart = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"));
        cart.click();

        WebElement assert1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]"));
        assert1.isDisplayed();

        WebElement assert2 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/a[1]/div[1]"));
        assert2.isDisplayed();

        driver.close();
    }

    @When("User klik tombol logout")
    public void userKlikTombolLogout() {
        WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menu.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement logout = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/a[3]"));
        logout.click();
    }


    @Then("User berhasil logout dan kembali ke halaman login")
    public void userBerhasilLogutDanKembaliKeHalamanLogin() {
        WebElement assertion = driver.findElement(By.xpath("//input[@id='login-button']"));
        assertion.isDisplayed();

        driver.close();
    }
}
