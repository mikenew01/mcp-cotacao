package com.github.maikoncanuto.quotes.core.interceptors;

import com.github.maikoncanuto.quotes.core.annotations.Auditoria;
import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static com.github.maikoncanuto.quotes.domain.enums.MessageEnum.INTERCEPTOR_METODO_EXECUTADO;
import static com.github.maikoncanuto.quotes.domain.enums.MessageEnum.INTERCEPTOR_METODO_PROBLEMA;
import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;
import static org.jboss.logging.Logger.getLogger;

@Auditoria
@Interceptor
@Priority(1)
public class AuditInterceptor {

    private static final Logger LOG = getLogger(AuditInterceptor.class);


    @AroundInvoke
    public Object intercept(final InvocationContext invocationContext) throws Exception {
        final var nameMethod = invocationContext.getMethod().getName();
        final var params = of(invocationContext.getParameters()).map(param -> format("%s, ", param)).collect(joining());

        try {
            LOG.info(format(INTERCEPTOR_METODO_EXECUTADO.get(), nameMethod, params));
            return invocationContext.proceed();
        } catch (final Exception e) {
            LOG.error(format(INTERCEPTOR_METODO_PROBLEMA.get(), nameMethod, params, e.getMessage()), e);
            throw e;
        }
    }


}
