package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "'table'") // Specify the schema and table name
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_label")
    private String tableLabel;

    @Column(name = "datatype")
    private String datatype;

    @Column(name = "value")
    private String value;

    @Column(name = "forms")
    private Boolean forms;

    @Column(name = "list_view")
    private Boolean listView;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableLabel() {
        return tableLabel;
    }

    public void setTableLabel(String tableLabel) {
        this.tableLabel = tableLabel;
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

    public Boolean getForms() {
        return forms;
    }

    public void setForms(Boolean forms) {
        this.forms = forms;
    }

    public Boolean getListView() {
        return listView;
    }

    public void setListView(Boolean listView) {
        this.listView = listView;
    }

	public Query createNativeQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
