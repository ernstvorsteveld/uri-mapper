package com.sternitc.urimapper;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UriContainer {

    @NotBlank
    private String name;

    @ValidUrl
    private String uri;
}
