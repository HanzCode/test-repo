package com.example.tugasmicrol.dto.response;

import lombok.Builder;

@Builder
public record ResponseAPI <T> (int code, String message, T data){
}
