package com.example.atvd1.repository;

import com.example.atvd1.model.AlunosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {
}
