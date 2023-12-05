package com.example.tugasmicrol.service.impl;

import com.example.tugasmicrol.dto.request.AbsenDTO;
import com.example.tugasmicrol.dto.response.ResponseAPI;
import com.example.tugasmicrol.entity.Absen;
import com.example.tugasmicrol.entity.User;
import com.example.tugasmicrol.repo.AbsenRepo;
import com.example.tugasmicrol.service.AbsenService;
import com.example.tugasmicrol.validation.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AbsenServiceImpl implements AbsenService {

    private AbsenRepo repo;
    private UserServiceImpl userService;

    private Absen objectMapper(AbsenDTO dto){
        Absen absen = new Absen();
        User user = userService.findById(dto.getId());

        absen.setUser(user);
        return absen;
    }

    @Override
    public ResponseAPI<?> saved(AbsenDTO dto) {
        try{
            repo.save(objectMapper(dto));
            return ResponseAPI.builder()
                    .code(HttpStatus.CREATED.value())
                    .build();
        }catch (UserNotFoundException exception){
            return ResponseAPI.builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(exception.getMessage())
                    .build();
        }
    }
}
