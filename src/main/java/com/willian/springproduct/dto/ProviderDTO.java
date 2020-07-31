package com.willian.springproduct.dto;

import java.io.Serializable;

import com.willian.springproduct.domain.Provider;

public class ProviderDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String phone;
	
	public ProviderDTO() {
	}
	
	public ProviderDTO(Provider obj) {
		id = obj.getId();
		name = obj.getName();
		phone = obj.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
