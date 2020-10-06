package com.abridged.stock_management_system.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * This is LoginResponse Class
 * 
 * @author 
 */
@SuppressWarnings("serial")
@Data
public class LoginResponse implements Serializable {

	private int statusCode;
	private String message;
	private String usernameMessage;
	private String passwordMessage;
	private String idMessage;
	private String mobileNoMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsernameMessage() {
		return usernameMessage;
	}
	public void setUsernameMessage(String usernameMessage) {
		this.usernameMessage = usernameMessage;
	}
	public String getPasswordMessage() {
		return passwordMessage;
	}
	public void setPasswordMessage(String passwordMessage) {
		this.passwordMessage = passwordMessage;
	}
	public String getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}
	public String getMobileNoMessage() {
		return mobileNoMessage;
	}
	public void setMobileNoMessage(String mobileNoMessage) {
		this.mobileNoMessage = mobileNoMessage;
	}
	
	
	
}
