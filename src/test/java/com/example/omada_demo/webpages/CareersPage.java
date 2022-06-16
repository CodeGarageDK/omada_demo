package com.example.omada_demo.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class CareersPage extends BasicWebPage {


    @Value("${prepath:src/test/resources/validation_texts/}")
    private String pathBegin;

    @FindBy(how = How.CSS, using = "body > section.m-text-image.pt-venti.pb-grande.bg-lightblue1.section-wide > div > div > div.col-xs-12.col-sm-6.col-content > div > p.button-wrapper > a > span")
    WebElement searchJobOpeningsButton;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.u-heading-block > div > div > h2")
    WebElement meetOmadiansHeader;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.leadership-list > div:nth-child(1) > div > img")
    WebElement gryCollignon;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.u-modal-overlay-slide.slide.is-active > div.modal-wrapper > div > div > div > div > p:nth-child(1)")
    WebElement omadianText;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.container > div.row.leadership-list > div:nth-child(3) > div")
    WebElement dariaCzajkowska;

    @FindBy(how = How.CSS, using = "body > section.m-leadership-grid.pt-superventi.pb-superventi.bg-light > div.u-modal-overlay > span.icon-close.js-modal-close > img")
    WebElement clickClosePerson;

    public void closePerson() {
        clickClosePerson.click();
    }

    public void clickSearchJobOpeningsButton() {
        searchJobOpeningsButton.click();
    }

    public void clickGryColligon() {
        new Actions(driver).moveToElement(gryCollignon).perform();
        gryCollignon.click();
    }


    public void clickDariaCzajkowska() {
        new Actions(driver).moveToElement(dariaCzajkowska).perform();
        dariaCzajkowska.click();
    }

    public boolean isOmadianTextEqual(String path) throws IOException {
        String expectedText = Files.readString(Path.of(pathBegin + path));
        return expectedText.equals(omadianText.getText());
    }

}
