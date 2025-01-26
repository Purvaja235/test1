package com.example.demo.controller;

import com.example.demo.model.TableEntity;
import com.example.demo.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/table")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    // Create a new table
    @PostMapping
    public TableEntity createTable(@RequestBody TableEntity tableEntity) {
        return tableRepository.save(tableEntity);
    }

    // Get all tables
    @GetMapping
    public List<TableEntity> getAllTables() {
        return tableRepository.findAll();
    }

    // Get a table by ID
    @GetMapping("/{id}")
    public ResponseEntity<TableEntity> getTableById(@PathVariable Integer id) {
        Optional<TableEntity> tableEntity = tableRepository.findById(id);
        return tableEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a table by ID
    @PutMapping("/{id}")
    public ResponseEntity<TableEntity> updateTable(@PathVariable Integer id, @RequestBody TableEntity tableDetails) {
        Optional<TableEntity> optionalTableEntity = tableRepository.findById(id);
        if (optionalTableEntity.isPresent()) {
            TableEntity tableEntity = optionalTableEntity.get();
            tableEntity.setTableName(tableDetails.getTableName());
            tableEntity.setTableLabel(tableDetails.getTableLabel());
            tableEntity.setDatatype(tableDetails.getDatatype());
            tableEntity.setValue(tableDetails.getValue());
            tableEntity.setForms(tableDetails.getForms());
            tableEntity.setListView(tableDetails.getListView());
            return ResponseEntity.ok(tableRepository.save(tableEntity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a table by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Integer id) {
        Optional<TableEntity> tableEntity = tableRepository.findById(id);
        if (tableEntity.isPresent()) {
            tableRepository.delete(tableEntity.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
