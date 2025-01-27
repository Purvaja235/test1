package com.example.demo.repository;

import com.example.demo.model.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<ColumnEntity, Integer> {
    List<ColumnEntity> findBySectionId(Integer sectionId);
}
