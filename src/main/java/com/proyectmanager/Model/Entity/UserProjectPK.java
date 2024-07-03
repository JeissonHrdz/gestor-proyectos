package com.proyectmanager.Model.Entity;

import java.io.Serializable;
import java.util.Objects;

public class UserProjectPK implements Serializable{

    private Integer idUser;
    private Integer  idProject;

    public UserProjectPK(){}

    public UserProjectPK(Integer idUser, Integer idProject){
        this.idProject = idProject;
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProjectPK that = (UserProjectPK) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idProject, that.idProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idProject);
    }


    
}
