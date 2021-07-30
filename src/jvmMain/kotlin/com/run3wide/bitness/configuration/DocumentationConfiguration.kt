package com.run3wide.bitness.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
    info = Info(
        title = "Bitness API",
        description = "REST API serving cryptocurrency exchange rates.",
        contact = Contact(
            name = "run3wide",
            url = "https://run3wide.com",
            email = "paul@run3wide.com",
        ),
        license = License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html",
        )
    ),
)
class DocumentationConfiguration
