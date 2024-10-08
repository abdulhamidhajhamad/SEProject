package Steps;

import management_system.classes.SupplierProduct;
import management_system.classes.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static management_system.classes.User.users;
import static org.junit.Assert.*;

public class addSupplierProductSteps {

    String productName;
    String supplierName;
    Double price;
    User u1;
    SupplierProduct s;
    public addSupplierProductSteps() {
        s=new SupplierProduct();
        u1=new User("ali","ali@gmail.com","123","supplier");
        users.add(u1);
    }

    @Given("I am logged in as an supplier")
    public void iAmLoggedInAsAnSupplier() {
        assertTrue(true);
    }
    @Given("I am on the Add Supplier product")
    public void iAmOnTheAddSupplierProduct() {
        assertTrue(true);
    }
    @When("I add product Name")
    public void iAddProductName() {
        productName="nutella";
    }
    @When("I add supplier name for product")
    public void iAddSupplierNameForProduct() {
        supplierName="ali";
    }
    @When("I add Price for product")
    public void iAddPriceForProduct() {
        price=10.0;
    }
    @When("I click the Add product button")
    public void iClickTheAddProductButton() {
       assertTrue(true);
    }
    @Then("I should see a confirmation message product has been added successfully")
    public void iShouldSeeAConfirmationMessageProductHasBeenAddedSuccessfully() {
        assertTrue(s.addSupplierProduct(supplierName,productName,price));
        assertEquals("product has been added successfully",s.getMsg());
    }




    @When("I miss to add product Name")
    public void iMissToAddProductName() {
        productName=null;
    }



    @Then("I should see an error message can't add because missing some fields or non exist supplier")
    public void iShouldSeeAnErrorMessageCanTAddBecauseMissingSomeFieldsOrNonExistSupplier() {
        assertFalse(s.addSupplierProduct(supplierName,productName,price));
        assertEquals("can't add because missing some fields or non exist supplier",s.getMsg());
    }







    @When("I miss to add supplier name for product")
    public void iMissToAddSupplierNameForProduct() {
       supplierName=null;
    }










    @When("I add non exist supplier name for product")
    public void iAddNonExistSupplierNameForProduct() {
        supplierName="ahmad";
    }








    @When("I miss to add Price for product")
    public void iMissToAddPriceForProduct() {
        price=0.0;
    }




}
