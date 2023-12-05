package com.example.tugasmicrol.repo;

import com.example.tugasmicrol.entity.Absen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenRepo extends JpaRepository<Absen, Integer> {

}
