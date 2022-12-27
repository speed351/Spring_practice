package com.gura.spring04.shop.dao;

import com.gura.spring04.shop.dto.OrderDto;

public interface OrderDao {
	//배송 정보 추가하는 메소드
	public void addOrder(OrderDto dto);
}
