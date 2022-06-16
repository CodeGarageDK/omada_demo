package com.example.omada_demo.cucumber.glue;

import com.example.omada_demo.webpages.CandidateHR;
import com.example.omada_demo.webpages.CareersPage;
import com.example.omada_demo.webpages.FrontPage;
import com.example.omada_demo.webpages.OmadaIdentityCloudPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OmadaSteps {


    @Autowired
    private WebDriver driver;

    @Autowired
    private FrontPage frontPage;

    @Autowired
    private OmadaIdentityCloudPage omadaIdentityCloudPage;

    @Autowired
    private CareersPage careersPage;

    @Autowired
    private CandidateHR candidateHR;

    private static Boolean isFirstRun = true;

    @Before
    public void before() {
        if(isFirstRun){
            System.out.println("This will run before the Scenario");
            frontPage.openPageAllowCookies();
            isFirstRun = false;
        }
    }


    @Given("I Open Omada front page")
    public void iOpenOmadaFrontPage() {
        frontPage.openPage();
    }



    @When("I through the top menu selects Products => Omada Identity Cloud")
    public void iThroughTheTopMenuSelectsProductsOmadaIdentityCloud() {
        frontPage.clickProducts();
        frontPage.clickHeaderMenuOmadaIdentityCloudPage();
    }


    @When("I through the bottom menu selects Omada Identity Cloud")
    public void iThroughTheBottomMenuSelectsOmadaIdentityCloud() {
        frontPage.clickBottomMenuOmadaIdentityCloudPage();
    }

    @When("I through the top menu selects Company => Careers")
    public void iThroughTheTopMenuSelectsCompanyCareers() {
        frontPage.clickHeaderMenuCompanyCareers();
    }

    @Then("the Omada Identity Cloud Page loads as expected")
    public void theOmadaIdentityCloudPageLoadsAsExpected() {
        assertThat(omadaIdentityCloudPage.isBookADemoButtonClickable()).isEqualTo(true);
        assertThat(omadaIdentityCloudPage.isBookADemoButtonTextPresent()).isEqualTo(true);
        assertThat(omadaIdentityCloudPage.isCompanyHeaderTextInBottomMenyPresent()).isEqualTo(true);
    }

    @And("I on Carreers page selects button - search our job openings")
    public void iOnCarreersPageSelectsButtonSearchOurJobOpenings() {
        careersPage.clickSearchJobOpeningsButton();
    }

    @Then("the CandidateHR site loads as expected")
    public void theCandidateHRSiteLoadsAsExpected() {
        candidateHR.isSiteLoaded();
    }

    @And("I on Carreers page select Gry Collignon")
    public void iOnCarreersPageSelectGryCollignon() {
        careersPage.clickGryColligon();
    }

    @Then("I expect the Persons text to be equal with {string}")
    public void iExpectPersonTextToBeEqualWith(String arg0) throws IOException {
        assertThat(careersPage.isOmadianTextEqual(arg0)).isEqualTo(true);
    }

    @When("I close the person")
    public void iCloseThePerson() {
        careersPage.closePerson();

    }

    @And("I on Carreers page select Daria Czajkowska")
    public void iOnCarreersPageSelectDariaCzajkowska() {
        careersPage.clickDariaCzajkowska();
    }
}
