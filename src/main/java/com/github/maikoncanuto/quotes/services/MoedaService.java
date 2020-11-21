package com.github.maikoncanuto.quotes.services;

import com.github.maikoncanuto.quotes.core.annotations.Auditoria;
import com.github.maikoncanuto.quotes.domain.dtos.TipoMoedaDTO;
import com.github.maikoncanuto.quotes.integrations.clients.BacenRestClient;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static com.github.maikoncanuto.quotes.core.config.LabelCache.BACEN_MOEDAS_CACHE;
import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@Auditoria
@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class MoedaService {

    @Inject
    @RestClient
    BacenRestClient bacenRestClient;

    @CacheResult(cacheName = BACEN_MOEDAS_CACHE)
    public List<TipoMoedaDTO> findAll() {
        final var moedas = bacenRestClient.getMoedas();
        return moedas.getValue();
    }

}
