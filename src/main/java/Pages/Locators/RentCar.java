package Pages.Locators;

import Pages.base.Base_PO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class RentCar extends Base_PO {

    private @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[1]/div[2]/div[2]/label[1]/input[1]")
    WebElement pickup_field;

    private @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[1]/label[1]/input[1]")
    WebElement calendar_field;

    private @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[1]/div[5]/a[1]")
    WebElement btn_search;

    private @FindBy(xpath = "//div[@Class='availability__main']/child::div[2]/child::div/child::div/child::div[13]/child::button")
    WebElement select_car;

    private @FindBy(id = "inpName")
    WebElement name_field;

    private @FindBy(xpath = "//input[@id='phoneCustom']")
    WebElement phone_field;

    private @FindBy(id = "inpEmail")
    WebElement email_field;

    private @FindBy(xpath = "//div[@Class='tray-payment__button']/child::button")
    WebElement btn_next;


    public RentCar(){
        super();
    }

    public void navigate_to_milesPage(){
        navigateTo_URL(Global_Vars.WEBDRIVER_PAGE_URL);
    }

    public void setPickupLocate(){
        waitForWebElementandClick(pickup_field);
        pickup_field.sendKeys("Florida");
        pickup_field.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//div[@Class='modal__content qs-location']/child::div[3]/child::ul[1]/child::li[3]")))).click();
    }

    public void setCalendar(){
        waitForWebElementandClick(calendar_field);

        String month = "Enero";
        String year = "2023";
        String day = "9";

        while(true) {
            String mes = getDriver().findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/strong[1]")).getText();
            String yText = getDriver().findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).getText();
            if(mes.equals(month) && yText.equals(year)) {
                break;
            }else {
                getDriver().findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")).click();
            }
        }

        getDriver().findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[15]")).click();

        getDriver().findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[21]")).click();

    }

    public void clickSearch(){
        waitForWebElementandClick(btn_search);
    }

    public void setSelect_car(){
        javaScritpEjecutor();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(3));
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//div[@Class='availability__main']/child::div[2]/child::div/child::div/child::div[13]/child::button")))).click();
    }

    public void setName(){
        getDriver().findElement(By.xpath("//div[text()='SUBTOTAL']")).getText();
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(By.id("inpName"))).click().build().perform();
       // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(3));
       // wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.id("inpName")))).click();
        name_field.sendKeys("Mario Alvez");
    }

    public void setPhone(){
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(By.xpath("//input[@id='phoneCustom']"))).click().build().perform();
        phone_field.sendKeys("3204568596");
    }

    public void setEmail(){
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(By.id("inpEmail"))).click().build().perform();
        email_field.sendKeys("marioV@gmail.com");
    }

    public void setBtnNext(){
        waitForWebElementandClick(btn_next);
    }


    public void assertText(){
        String textMetohd = "Métodos de Pago";
        String textPage = getDriver().findElement(By.xpath("//h3[text()='Métodos de Pago']")).getText();
        Assert.assertEquals(textMetohd, textPage);

    }


}
