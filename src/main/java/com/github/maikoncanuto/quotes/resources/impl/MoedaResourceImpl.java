package com.github.maikoncanuto.quotes.resources.impl;

import com.github.maikoncanuto.quotes.resources.config.BaseResource;
import com.github.maikoncanuto.quotes.resources.IMoedaResource;
import com.github.maikoncanuto.quotes.services.MoedaService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;


public class MoedaResourceImpl extends BaseResource implements IMoedaResource {

    @Inject
    MoedaService moedaService;

    @Override
    public Response findAll() {
        final var moedas = moedaService.findAll();
        return toResponse(OK, moedas);
    }

}
