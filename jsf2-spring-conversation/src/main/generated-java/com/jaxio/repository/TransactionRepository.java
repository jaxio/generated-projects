/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/repository/Repository.e.vm.java
 */
package com.jaxio.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.domain.Transaction;
import com.jaxio.repository.support.GenericRepository;

/**
 * {@link GenericRepository} for {@link Transaction} 
 */
@Named
@Singleton
public class TransactionRepository extends GenericRepository<Transaction, Integer> {

    public TransactionRepository() {
        super(Transaction.class);
    }

    @Override
    public Transaction getNew() {
        return new Transaction();
    }

    @Override
    public Transaction getNewWithDefaults() {
        return getNew().withDefaults();
    }
}