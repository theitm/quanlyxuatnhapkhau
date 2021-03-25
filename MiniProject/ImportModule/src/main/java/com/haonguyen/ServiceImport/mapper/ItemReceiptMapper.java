package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemReceiptMapper {
    @Mappings({
            @Mapping(target = "imageUrl", expression = "java(.getImageUrl.toString()")
    })
    List<DocumentEntity> itemReceiptToDocumentEntity(List<ItemReceiptDTO> itemReceiptDTOList);

    default String mapImageUrl(List<String> listImageUrl) {
        String imageUrl = listImageUrl.toString();
        return imageUrl;
    }

}
