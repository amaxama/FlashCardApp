/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
public class Role {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int roleId;
    
    @NotEmpty(message = "Please enter a name.")
    @Length(max = 50, message = "Name must be no more than 30 characters in length.")
    @Column(nullable = false)
    private String roleName;
    
    @NotEmpty(message = "Please enter a description for the Role.")
    @Length(max = 100, message = "Role description must be no more than 100 characters in length.")
    @Column(nullable = false)
    private String roleDesc;
    

  public Role() {
    
  }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.roleId;
        hash = 19 * hash + Objects.hashCode(this.roleName);
        hash = 19 * hash + Objects.hashCode(this.roleDesc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (!Objects.equals(this.roleName, other.roleName)) {
            return false;
        }
        if (!Objects.equals(this.roleDesc, other.roleDesc)) {
            return false;
        }
        return true;
    }
  
  
    
 
}
