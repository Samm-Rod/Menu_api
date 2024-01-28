package com.menu.options.entities.enums;

public enum TypeOrder {
	
	DRINKS(1),
	FOODS(2),
	DESSERT(3),
	DOSE(4),
	BURGERS(5),
	VEGETABLES(6),
	PIZZAS(7);
	
	private int code;
	
	private TypeOrder(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TypeOrder valueOf(int code) {
		for(TypeOrder value : TypeOrder.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
