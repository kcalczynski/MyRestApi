package com.MyRestApiGroup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @GenericGenerator(name = "taskSequence", strategy = "sequence-identity",
            parameters = @org.hibernate.annotations.Parameter(name="sequence", value="TASKS_SEQ"))
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSequence")
    @Column(name = "TASK_ID")
    @JsonProperty
    private Long id;

    @Column(name = "TASK_NAME")
    @JsonProperty
    private String name;

    @Column(name = "TASK_DESC")
    @JsonProperty
    private String description;

    @Column(name = "TASK_STAT", columnDefinition="BIT")
    @JsonProperty
    private boolean status;

    public Task(Long id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Task(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (status != task.status) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        return description != null ? description.equals(task.description) : task.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
