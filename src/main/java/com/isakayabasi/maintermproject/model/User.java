package com.isakayabasi.maintermproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Collection;


@Component
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends TimeStampModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    /////////////////////////////////
    @Column(name = "role")
    private String role;
    //////////////////////////////////
    public String email;
    private String password;
    
    private int enterValue=2;

    private boolean activeOrPassive=true;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))


    private Collection<Role> roles;


    public User(String firstName, String lastName, String email, String password,int enterValue,boolean activeOrPassive, Collection<Role> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enterValue=enterValue;
        this.activeOrPassive=activeOrPassive;
        this.roles = roles;


    }


}