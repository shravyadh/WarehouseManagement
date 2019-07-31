package com.Shravya.Bean;

public class ItemInfo {
@Override
	public String toString() {
		return "ItemInfo [item_code=" + item_code + ", item_name=" + item_name + ", price=" + price + ", stock=" + stock
				+ "]";
	}
private String item_code;
private String item_name;
private String price;
private String stock;
public ItemInfo()
{
	
}
public String getItem_code() {
	return item_code;
}
public void setItem_code(String item_code) {
	this.item_code = item_code;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getStock() {
	return stock;
}
public void setStock(String stock) {
	this.stock = stock;
}

}
