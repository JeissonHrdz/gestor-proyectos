package com.proyectmanager.Model.Entity;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email") 
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_register")
    private Date dateRegister;

    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "username", nullable = false)
    private String username;
   
    @Column(name = "role") 
    @Enumerated(EnumType.STRING)
    Role role;

    @ManyToMany(mappedBy = "users")
    private Set<Proyect> projects; 



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {     
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public String getPassword(){
        return this.password;
    }
   

    @Override
    public boolean isAccountNonExpired() {   
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {  
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {     
        return true;
    }
    
    
}
