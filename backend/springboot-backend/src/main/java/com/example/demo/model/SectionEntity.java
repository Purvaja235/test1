package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "section")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableEntity table;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "section_label")
    private String sectionLabel;

    @Column(name = "section_sequence")
    private Integer sectionSequence;

    @Column(name = "datatype")
    private String datatype;

    @Column(name = "value")
    private String value;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TableEntity getTable() {
        return table;
    }

    public void setTable(TableEntity table) {
        this.table = table;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionLabel() {
        return sectionLabel;
    }

    public void setSectionLabel(String sectionLabel) {
        this.sectionLabel = sectionLabel;
    }

    public Integer getSectionSequence() {
        return sectionSequence;
    }

    public void setSectionSequence(Integer sectionSequence) {
        this.sectionSequence = sectionSequence;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
