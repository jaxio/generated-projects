/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/support/TextNotEquals.p.vm.java
 */
package fr.jaxio.demo.web.selenium.support;

import javax.annotation.Nullable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class TextNotEquals implements Function<WebDriver, Boolean> {
    private final WebElement webElement;
    private final String expected;

    public TextNotEquals(WebElement webElement, String expected) {
        this.webElement = webElement;
        this.expected = expected;
    }

    @Override
    public synchronized Boolean apply(@Nullable WebDriver driver) {
        return !expected.equals(webElement.getText());
    }
}