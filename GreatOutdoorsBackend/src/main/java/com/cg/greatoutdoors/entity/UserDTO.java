package com.cg.greatoutdoors.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="USER_GO")
public class UserDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_ID_GENERATOR")
	@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_SEQENCE",initialValue=10001)
	@Column(name="USER_ID")
	private Long userId;
	
	@NotEmpty(message="username must not be empty")
	@Column(name="USERNAME")
	private String username;
	
	@NotEmpty(message="password must not be empty")
	@Column(name="PASSWORD")
	private String password;
	
	@NotEmpty(message="role must not be empty")
	@Column(name="ROLE")
	private String role;
	
	@NotEmpty(message="phone number must not be empty")
	@Column(name="PHONE_NO")
	private String phoneNumber;
	
	@NotEmpty(message="email must not be empty")
	@Email(message="email should be a valid email")
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<AddressDTO> addressList=new ArrayList<>();
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String username, String password, String role, String phoneNumber, String email) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<AddressDTO> getAddresses() {
		return addressList;
	}

	public void setAddresses(List<AddressDTO> addressList) {
		this.addressList = addressList;
	}

	

}
