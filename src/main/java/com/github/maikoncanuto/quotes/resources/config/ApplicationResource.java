package com.github.maikoncanuto.quotes.resources.config;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1")
@OpenAPIDefinition(
        info = @Info(
                description = "Serviço para cotações de moedas e informações monetárias",
                title = "Mcp Quote API",
                version = "0.0.1",
                contact = @Contact(
                        name = "Maikon Canuto",
                        email = "maikoncanuto@gmail.com",
                        url = "http://github.com/Maikoncanuto"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Documentação externa oficial",
                url = "https://dadosabertos.bcb.gov.br/dataset/expectativas-mercado/resource/dc8139ea-2555-48d7-9026-54e3b5d1815b?inner_span=True"
        )
)
public final class ApplicationResource extends Application {

}
