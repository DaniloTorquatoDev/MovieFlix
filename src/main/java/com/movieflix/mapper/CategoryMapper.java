package com.movieflix.mapper;

import com.movieflix.controller.request.CategoryResponse;
import com.movieflix.controller.response.CategoryRequest;
import com.movieflix.entity.Category;
import lombok.experimental.UtilityClass;

import java.net.CacheRequest;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest){
return Category
        .builder()
        .name(categoryRequest.name())
        .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
