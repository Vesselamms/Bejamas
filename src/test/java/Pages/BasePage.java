package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;


public abstract class BasePage {
    @FindBy(xpath = "//p[normalize-space(text())='Photo of the day']")
    public WebElement PhotoDay;

    @FindBy(xpath = "//button[@aria-label='sorting-order']")
    public WebElement SortingButton;

    @FindBy(xpath = "//div[@class='SortingSelectstyle__SortingSelectWrapper-sc-1r760yq-0 gcZyvG']//select")
    public WebElement SortMod;

    @FindBy(xpath = "//p[normalize-space(text())='$0.99']")
    public WebElement LowestProduct;

    @FindBy(xpath = "//p[normalize-space(text())='$4.95']")
    public WebElement SecondLowestProduct;

    @FindBy(xpath = "//p[normalize-space(text())='$6.99']")
    public WebElement ThirdLowestProduct;

    @FindBy(xpath = "//p[normalize-space(text())='$7.99']")
    public WebElement LastoneProduct;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[5]/div/div[1]/div/div[2]")
    public WebElement Categories;

    @FindBy(xpath = "//img[@alt='watch']")
    public WebElement watch;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[5]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/button")
    public WebElement addToChartButton;

    @FindBy(xpath = "//p[normalize-space(text())='Best Seller']")
    public WebElement BestSellerFlag;

  //I created this method for click radio buttons which is under the categories module
    public void Category(String RadioButton) {
        String ClickRadioBut = "//input[@label ='" + RadioButton + "']";

        Driver.get().findElement(By.xpath(ClickRadioBut)).click();

        BrowserUtils.waitFor(2);


    }
    //I created this method for assert radio buttons which is under the categories module
    public WebElement RadioButtons(String RadioButton) {
        Driver.get().findElement(By.xpath("//input[@label ='" + RadioButton + "']"));

        return  Driver.get().findElement(By.xpath("//input[@label ='" + RadioButton + "']"));
    }



    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
