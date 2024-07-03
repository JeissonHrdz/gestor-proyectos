package com.proyectmanager.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Entity
@IdClass(UserProjectPK.class)
@Builder
@Table(name = "user_project")
public class UserProject {

    @Id
    @Column(name = "id_user") 
    private Integer idUser;

    @Id
    @Column(name = "id_project")
    private Integer idProject;

}
