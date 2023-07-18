package com.sternitc.urimapper;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/uri")
public class UriController {

    private UriContainerDomain uriContainer;

    @ResponseBody
    @GetMapping
    Mono<UriContainer> get() {
        return Mono.just(UriContainerMapper.INSTANCE.toPayload(uriContainer));
    }


    @PostMapping
    Mono<UriContainer> post(@Valid @RequestBody UriContainer container) {
        this.uriContainer = UriContainerMapper.INSTANCE.toDomain(container);
        return Mono.just(container);
    }

}
