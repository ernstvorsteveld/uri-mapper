package com.sternitc.urimapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = UriController.class)
@AutoConfigureMockMvc
public class UriControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void should_create_and_get() {
        var name = "Test";
        var url = "https://www.google.com";
        this.webClient.post().uri("/uri").
                body(BodyInserters.fromObject(
                        new UriContainer(name, url)))
                .exchange()
                .expectStatus().isOk();

        UriContainer result = this.webClient.get().uri("/uri")
                .exchange()
                .expectStatus().isOk()
                .expectBody(UriContainer.class)
                .returnResult().getResponseBody();
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getUri().toString()).isEqualTo(url);
    }

    @Test
    public void should_allow_url_null_value() {
        var name = "Test";
        this.webClient.post().uri("/uri").
                body(BodyInserters.fromObject(
                        new UriContainer(name, null)))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void should_allow_url_null_value_in_mono() {
        var name = "Test";
        this.webClient.post().uri("/uri/mono").
                body(BodyInserters.fromObject(
                        new UriContainer(name, null)))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void should_return_with_url_incorrect() {
        var name = "Test";
        var url = "noway://www.google.com";
        this.webClient.post().uri("/uri").
                body(BodyInserters.fromObject(
                        new UriContainer(name, url)))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void should_return_with_url_incorrect_in_mono() {
        var name = "Test";
        var url = "noway://www.google.com";
        this.webClient.post().uri("/uri/mono").
                body(BodyInserters.fromObject(
                        new UriContainer(name, url)))
                .exchange()
                .expectStatus().isBadRequest();
    }
}
