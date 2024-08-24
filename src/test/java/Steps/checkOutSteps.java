package Steps;

import Management_System.Classes.checkOut;
import Management_System.Classes.iteam;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.*;

import static Management_System.Classes.iteam.iteams;


public class checkOutSteps {


    checkOut check;
    String addres;
    String phone;
    String username;
    String email;
    Double totalOrder;
    public checkOutSteps() {
        check = new checkOut();
    }

    @Given("the user has added items to their cart")
    public void theUserHasAddedItemsToTheirCart() {
        iteam iteam1=new iteam("nutellaCakae",50);
        iteam iteam2=new iteam("clasicaCakae",30);
        iteam iteam3=new iteam("pistashioaCakae",40);
        iteam iteam4=new iteam("beantbuterCakae",70);
        iteams.add(iteam1);
        iteams.add(iteam2);
        iteams.add(iteam3);
        iteams.add(iteam4);
    }
    @When("they navigate to the checkout page")
    public void theyNavigateToTheCheckoutPage() {

    }
    @When("add his delivery information")
    public void addHisDeliveryInformation() {
        addres = "123";
         phone = "123";
         username = "abdulhamid";
         email = "abdulhamid@gmail.com";
         totalOrder = 150.0;
    }
    @Then("they should see all items in their cart including")
    public void theyShouldSeeAllItemsInTheirCartIncluding() {
        assertTrue(check.isValidCheckOut(iteams));
    }
    @Then("see his information")
    public void seeHisInformation() {
        check.printOrderDetail(iteams,username,email,addres,phone,totalOrder);
    }
    @Then("see confirm message")
    public void seeConfirmMessage() {
        assertEquals(check.getMsg(),"complete check out");
    }




    @Given("the user didn't add any items")
    public void theUserDidnTAddAnyItems() {
        iteams.clear();
        assertFalse(check.isValidCheckOut(iteams));
    }

    @Then("they should see error message")
    public void theyShouldSeeErrorMessage() {
        assertEquals(check.getMsg(),"incomplete check out beacuse you didnt order anythings");
    }



}
