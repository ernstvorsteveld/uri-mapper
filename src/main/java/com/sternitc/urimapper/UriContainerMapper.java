package com.sternitc.urimapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MapperUtils.class})
public interface UriContainerMapper {

    public UriContainerMapper INSTANCE = Mappers.getMapper(UriContainerMapper.class);

    @Mapping(target = "url", source="uri")
    UriContainerDomain toDomain(UriContainer source);

    @Mapping(target = "uri", source = "url")
    UriContainer toPayload(UriContainerDomain source);
}
