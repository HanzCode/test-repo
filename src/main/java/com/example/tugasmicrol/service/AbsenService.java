package com.example.tugasmicrol.service;

import com.example.tugasmicrol.dto.request.AbsenDTO;
import com.example.tugasmicrol.dto.response.ResponseAPI;

public interface AbsenService {

    ResponseAPI<?> saved(AbsenDTO dto);

}
