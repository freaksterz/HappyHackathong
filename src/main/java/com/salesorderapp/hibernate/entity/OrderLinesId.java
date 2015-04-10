package com.salesorderapp.hibernate.entity;


// Created 28 Dec, 2014

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author freakster
 */
@Embeddable
public class OrderLinesId implements java.io.Serializable {

	private String productCode;
	private String orderNumber;

	public OrderLinesId() {
	}

	public OrderLinesId(String productCode, String orderNumber) {
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}

	@Column(name = "Product_Code", nullable = false, length = 30)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "OrderNumber", nullable = false, length = 30)
	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderLinesId))
			return false;
		OrderLinesId castOther = (OrderLinesId) other;

		return ((this.getProductCode() == castOther.getProductCode()) || (this
				.getProductCode() != null && castOther.getProductCode() != null && this
				.getProductCode().equals(castOther.getProductCode())))
				&& ((this.getOrderNumber() == castOther.getOrderNumber()) || (this
						.getOrderNumber() != null
						&& castOther.getOrderNumber() != null && this
						.getOrderNumber().equals(castOther.getOrderNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProductCode() == null ? 0 : this.getProductCode()
						.hashCode());
		result = 37
				* result
				+ (getOrderNumber() == null ? 0 : this.getOrderNumber()
						.hashCode());
		return result;
	}

}
