package com.sternitc.urimapper;

import org.mapstruct.Mapper;

import java.net.MalformedURLException;
import java.net.URL;

@Mapper(componentModel = "spring")
public interface MapperUtils {

    default URL map(String url) {
        if (url == null) {
            return null;
        } else {
            try {
                return new URL(url);
            } catch (MalformedURLException e) {
                return null;
            }
        }
    }

}
