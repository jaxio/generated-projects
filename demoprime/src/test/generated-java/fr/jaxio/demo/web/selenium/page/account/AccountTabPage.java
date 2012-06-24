/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/TabPage.e.vm.java
 */
package fr.jaxio.demo.web.selenium.page.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fr.jaxio.demo.web.selenium.support.Page;

@Page
public class AccountTabPage extends AccountSearchPage {
    @FindBy(css = "button[title=\"Search account\"]")
    public WebElement selectButton;
    @FindBy(css = "button[title=\"Add account\"]")
    public WebElement addButton;
    @FindBy(id = "form:ok")
    public WebElement okButton;
}