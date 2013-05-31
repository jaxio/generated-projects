/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/SearchFormsIT.p.vm.java
 */
package com.jaxio.web.selenium;

import org.junit.Test;

import com.jaxio.web.selenium.page.account.AccountSearchPage;
import com.jaxio.web.selenium.support.SeleniumTest;

public class SearchFormsIT extends SeleniumTest {
    AccountSearchPage accountSearchPage;

    @Test
    public void ajaxNavigation() {
        englishHomePage();
        loginAsAnAdmin();
        webClient.step("Go to accounts, and verify their number");
        loggedHomePage.accounts();
        accountSearchPage.paginator.hasSize(53);
        webClient.step("Search by mail and verify ajax, next/previous navigation");
        accountSearchPage.searchByEmail("1");
        accountSearchPage.paginator.isPage(1);
        accountSearchPage.paginator.hasSize(13);
        accountSearchPage.paginator.next();
        accountSearchPage.paginator.isPage(2);
        accountSearchPage.paginator.previous();
        accountSearchPage.paginator.isPage(1);
    }

    @Test
    public void complex() {
        englishHomePage();
        loginAsAnAdmin();
        loggedHomePage.accounts();
        webClient.step("Test complex searches");
        webClient.autocomplete(accountSearchPage.homeAddress, "pari", "Paris");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);

        webClient.autocomplete(accountSearchPage.homeAddress, "tok", "Tokyo");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(52);

        webClient.autocomplete(accountSearchPage.securityRoles, "use", "ROLE_USER");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(2);

        webClient.autocomplete(accountSearchPage.securityRoles, "role_admin", "ROLE_ADMIN");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);

        webClient.step("Reset search form");
        accountSearchPage.resetSearch();

        webClient.autocomplete(accountSearchPage.username, "homer");
        webClient.autocomplete(accountSearchPage.username, "admin");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(2);

        webClient.autocomplete(accountSearchPage.securityRoles, "mon", "ROLE_MONITORING");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);
    }

    @Test
    public void fullText() {
        englishHomePage();
        loginAsAnAdmin();
        loggedHomePage.accounts();

        webClient.step("Full text search on all fields");
        accountSearchPage.fullTextQuery("hoomer");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);

        accountSearchPage.resetSearch();
        accountSearchPage.paginator.hasSize(53);

        webClient.step("Full text search on a specific field");
        webClient.autocomplete(accountSearchPage.username, "hoomhe", "homer");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);

        accountSearchPage.resetSearch();
        accountSearchPage.paginator.hasSize(53);

        webClient.step("Full text search on a many to many field");
        webClient.autocomplete(accountSearchPage.securityRoles, "hadmihn", "ROLE_ADMIN");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);

        accountSearchPage.resetSearch();
        accountSearchPage.paginator.hasSize(53);

        webClient.step("Full text search on a many to one field");
        webClient.autocomplete(accountSearchPage.homeAddress, "frankisko", "San Francisco");
        webClient.autocomplete(accountSearchPage.homeAddress, "parhis", "Paris");
        accountSearchPage.search();
        accountSearchPage.paginator.hasSize(1);
    }
}