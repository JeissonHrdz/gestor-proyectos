package com.proyectmanager.Model.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id_project")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProject;

    @Column(name = "name")
    private String name;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "date_creation")
    private Date dateCreation;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "user_project",
        joinColumns = @JoinColumn(name = "id_project"),
        inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users;

   

    
}
