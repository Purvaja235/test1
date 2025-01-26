package com.example.demo.repository;

import com.example.demo.model.FieldSequence;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldSequenceRepository extends JpaRepository<FieldSequence, Integer> {
    List<FieldSequence> findAllByOrderBySequenceDesc();
    List<FieldSequence> findByTableName(String tableName);
    List<FieldSequence> findByTableNameOrderBySectionSequenceAscSequenceAsc(String tableName);
}
