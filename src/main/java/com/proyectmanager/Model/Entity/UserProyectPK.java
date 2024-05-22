package com.proyectmanager.Model.Entity;

import java.io.Serializable;
import java.util.Objects;

public class UserProyectPK implements Serializable{

    private Integer idUser;
    private Integer  idProyect;

    public UserProyectPK(){}

    public UserProyectPK(Integer idUser, Integer idProyect){
        this.idProyect = idProyect;
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProyectPK that = (UserProyectPK) o;
        return Objects.equals(idUser, that.idUser) &&
               Objects.equals(idProyect, that.idProyect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idProyect);
    }


    
}
