package com.example.tugasmicrol.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tbl_absen")
public class Absen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;



}
