package com.Shravya.Bean;

public class PurchaseDetails {
	private String transaction_id;
	private String customer_code;
	private String item_code;
    private String	date_of_purchase;
	private String quantity_purchased ;
	public PurchaseDetails() {}
	public String getQuantity_purchased() {
		return quantity_purchased;
	}
	public void setQuantity_purchased(String quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getDate_of_purchase() {
		return date_of_purchase;
	}
	public void setDate_of_purchase(String date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}
}
