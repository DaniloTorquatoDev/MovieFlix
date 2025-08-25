package com.movieflix.controller.request;

import lombok.Builder;

@Builder
public record UserRequest(String name, String password, String email){
}
