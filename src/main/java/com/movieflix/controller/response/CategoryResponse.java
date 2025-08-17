package com.movieflix.controller.request;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
