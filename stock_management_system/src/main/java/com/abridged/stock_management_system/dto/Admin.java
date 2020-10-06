package com.abridged.stock_management_system.dto;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

/**
 * This is Admin Entity Class
 * 
 * @author 
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "admin")
@JsonRootName("Admin")
@JsonInclude(content = Include.NON_NULL)
public class Admin implements Serializable {

	@Id
	@Column
	private String username;

	@Column
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
