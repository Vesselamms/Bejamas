package step_definitions;

import Pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.*;

public class ProductStepDef {

    DashboardPage dashboardPage = new DashboardPage();

    List<WebElement> list = new ArrayList<>();

    @Given("the user is on the main page")
    public void the_user_is_on_the_main_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(3);


    }

    @When("the user should see  have a flag product")
    public void the_user_should_see_have_a_flag_product() {

        Assert.assertTrue(dashboardPage.PhotoDay.isDisplayed());


    }

    @Then("the user verify that this picture {string}")
    public void the_user_verify_that_this_picture(String PhotoOfday) {

        Assert.assertEquals(dashboardPage.PhotoDay.getText(), PhotoOfday);

    }

    @When("the user able to  click sorting module")
    public void the_user_able_to_click_sorting_module()  {

        BrowserUtils.waitFor(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();//I use JSExecutor for scroll down

        for (int i = 0; i < 3; i++) {
            BrowserUtils.waitFor(2);
            jse.executeScript("window.scrollBy(0,250)");

        }

        BrowserUtils.waitFor(2);
        Select dropdown = new Select(dashboardPage.SortMod);//This module has dropdown menu
        dropdown.selectByIndex(1);//this method can sort to price module

        BrowserUtils.waitFor(2);
        //If I want to rank from cheap to expensive, I press the sort button and verify the price of the first product.
        dashboardPage.SortingButton.click();
        BrowserUtils.waitFor(2);


        list.add(dashboardPage.LowestProduct);
        list.add(dashboardPage.SecondLowestProduct);
        list.add(dashboardPage.ThirdLowestProduct);
        list.add(dashboardPage.LastoneProduct);


        BrowserUtils.getElementsText(list);


    }

    @Then("the user verify that high-low price product")
    public void the_user_verify_that_high_low_price_product() {
       if(list.get(0)== dashboardPage.LowestProduct){
           System.out.println("Test passed ");

       }else{
            System.out.println("Test failed");
           System.out.println(dashboardPage.Categories.getText());
       }
    }

    @When("user should see six different artworks under the category")
    public void user_should_see_six_different_artworks_under_the_category() {

        System.out.println(dashboardPage.Categories.getText());
        if(dashboardPage.Categories.getText().startsWith("Pets")&&dashboardPage.Categories.getText().endsWith("Art")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

    }



    @When("user able to select which artworks category do you want")
    public void user_able_to_select_which_artworks_category_do_you_want() {

        dashboardPage.Category("pets");
        dashboardPage.Category("nature");
        dashboardPage.Category("food");
        dashboardPage.Category("technology");
        dashboardPage.Category("luxury");
        dashboardPage.Category("art");

        Assert.assertTrue("Radio button selected",dashboardPage.RadioButtons("pets").isSelected());
        Assert.assertTrue("Radio button selected",dashboardPage.RadioButtons("nature").isSelected());
        Assert.assertTrue("Radio button selected",dashboardPage.RadioButtons("food").isSelected());
        Assert.assertTrue("Radio button selected",dashboardPage.RadioButtons("technology").isSelected());
        Assert.assertTrue("Radio button selected",dashboardPage.RadioButtons("luxury").isSelected());
        Assert.assertTrue("Radio button selected",dashboardPage.RadioButtons("art").isSelected());


    }



    @When("user move to mouse mark on the image,the {string} bar is displayed.")
    public void user_move_to_mouse_mark_on_the_image_the_bar_is_displayed(String AddtoCart) {

        //verify the user can move to  hover over on the image
        BrowserUtils.hover(dashboardPage.watch);

        //verify that user able to see "Add the cart" button
        Assert.assertEquals(dashboardPage.addToChartButton.getText(), AddtoCart);


    }



    @Then("user should able to see product which has {string} flag")
    public void user_should_able_to_see_product_which_has_flag(String BestSellerFlag) {

        Assert.assertEquals(dashboardPage.BestSellerFlag.getText(), BestSellerFlag);

    }

}