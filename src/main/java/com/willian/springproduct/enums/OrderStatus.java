package com.willian.springproduct.enums;

public enum OrderStatus {
	OPENED(1),
	CLOSED(2),
	CANCELED(3),
	WAITING_CONFIRMATION(4);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code!");
	}
}
