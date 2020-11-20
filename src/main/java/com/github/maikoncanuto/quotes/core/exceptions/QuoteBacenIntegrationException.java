package com.github.maikoncanuto.quotes.core.exceptions;

import java.io.Serializable;

public class QuoteBacenIntegrationException extends Exception implements Serializable {

    public QuoteBacenIntegrationException(String message) {
        super(message);
    }

}
