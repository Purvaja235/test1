package com.example.demo.repository;

import com.example.demo.model.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Integer> {
    List<SectionEntity> findByTableId(Integer tableId);
}
