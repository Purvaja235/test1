package com.example.demo.repository;

import com.example.demo.model.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Integer> {

	com.example.demo.controller.TableEntity save(com.example.demo.controller.TableEntity tableEntity);
}
