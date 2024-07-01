package com.proyectmanager.Model.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id_task")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTask;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private String pripority;

    @Column(name = "status")
    private String status;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "id_sprint")
    private Integer idSprint;
}
