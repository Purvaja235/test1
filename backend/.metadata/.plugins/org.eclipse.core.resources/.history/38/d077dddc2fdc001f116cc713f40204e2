package com.example.demo.controller;

import com.example.demo.model.ColumnEntity;
import com.example.demo.repository.ColumnRepository;
import com.example.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/column")
public class ColumnController {

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private SectionRepository sectionRepository;

    // Create a new column
    @PostMapping
    public ColumnEntity createColumn(@RequestBody ColumnEntity columnEntity) {
        return columnRepository.save(columnEntity);
    }

    // Get all columns
    @GetMapping
    public List<ColumnEntity> getAllColumns() {
        return columnRepository.findAll();
    }

    // Get a column by ID
    @GetMapping("/{id}")
    public ResponseEntity<ColumnEntity> getColumnById(@PathVariable Integer id) {
        Optional<ColumnEntity> columnEntity = columnRepository.findById(id);
        return columnEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a column by ID
    @PutMapping("/{id}")
    public ResponseEntity<ColumnEntity> updateColumn(@PathVariable Integer id, @RequestBody ColumnEntity columnDetails) {
        Optional<ColumnEntity> optionalColumnEntity = columnRepository.findById(id);
        if (optionalColumnEntity.isPresent()) {
            ColumnEntity columnEntity = optionalColumnEntity.get();
            columnEntity.setColumnName(columnDetails.getColumnName());
            columnEntity.setColumnLabel(columnDetails.getColumnLabel());
            columnEntity.setDatatype(columnDetails.getDatatype());
            columnEntity.setValue(columnDetails.getValue());
            return ResponseEntity.ok(columnRepository.save(columnEntity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a column by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColumn(@PathVariable Integer id) {
        Optional<ColumnEntity> columnEntity = columnRepository.findById(id);
        if (columnEntity.isPresent()) {
            columnRepository.delete(columnEntity.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get columns by section ID
    @GetMapping("/section/{sectionId}")
    public List<ColumnEntity> getColumnsBySectionId(@PathVariable Integer sectionId) {
        return columnRepository.findBySectionId(sectionId);
    }
}
