package com.MyRestApiGroup.entity;

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
    private Long id;

    @Column(name = "TASK_NAME")
    private String Name;

    @Column(name = "TASK_DESC")
    private String Description;

    @Column(name = "TASK_STAT", columnDefinition="BIT")
    private boolean Status;

    public Task(Long id, String name, String description, boolean status) {
        this.id = id;
        Name = name;
        Description = description;
        Status = status;
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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (Status != task.Status) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (Name != null ? !Name.equals(task.Name) : task.Name != null) return false;
        return Description != null ? Description.equals(task.Description) : task.Description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        result = 31 * result + (Status ? 1 : 0);
        return result;
    }
}
