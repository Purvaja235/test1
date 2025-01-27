package com.example.demo.controller;

import com.example.demo.model.SectionEntity;
import com.example.demo.repository.SectionRepository;
import com.example.demo.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private TableRepository tableRepository;

    // Create a new section
    @PostMapping
    public SectionEntity createSection(@RequestBody SectionEntity sectionEntity) {
        return sectionRepository.save(sectionEntity);
    }

    // Get all sections
    @GetMapping
    public List<SectionEntity> getAllSections() {
        return sectionRepository.findAll();
    }

    // Get a section by ID
    @GetMapping("/{id}")
    public ResponseEntity<SectionEntity> getSectionById(@PathVariable Integer id) {
        Optional<SectionEntity> sectionEntity = sectionRepository.findById(id);
        return sectionEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a section by ID
    @PutMapping("/{id}")
    public ResponseEntity<SectionEntity> updateSection(@PathVariable Integer id, @RequestBody SectionEntity sectionDetails) {
        Optional<SectionEntity> optionalSectionEntity = sectionRepository.findById(id);
        if (optionalSectionEntity.isPresent()) {
            SectionEntity sectionEntity = optionalSectionEntity.get();
            sectionEntity.setSectionName(sectionDetails.getSectionName());
            sectionEntity.setSectionLabel(sectionDetails.getSectionLabel());
            sectionEntity.setSectionSequence(sectionDetails.getSectionSequence());
            sectionEntity.setDatatype(sectionDetails.getDatatype());
            sectionEntity.setValue(sectionDetails.getValue());
            return ResponseEntity.ok(sectionRepository.save(sectionEntity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a section by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Integer id) {
        Optional<SectionEntity> sectionEntity = sectionRepository.findById(id);
        if (sectionEntity.isPresent()) {
            sectionRepository.delete(sectionEntity.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get sections by table ID
    @GetMapping("/table/{tableId}")
    public List<SectionEntity> getSectionsByTableId(@PathVariable Integer tableId) {
        return sectionRepository.findByTableId(tableId);
    }
}
