/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/converter/JsfConverter.e.vm.java
 */
package com.jaxio.web.converter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.domain.Currency;
import com.jaxio.repository.CurrencyRepository;
import com.jaxio.web.converter.support.GenericJsfConverter;

/**
 * {@link GenericJsfConverter} for {@link Currency}.
 */
@Named
@Singleton
public class CurrencyJsfConverter extends GenericJsfConverter<Currency, Integer> {
    @Inject
    public CurrencyJsfConverter(CurrencyRepository currencyRepository) {
        super(currencyRepository, Currency.class, Integer.class);
    }
}