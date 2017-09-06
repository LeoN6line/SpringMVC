package com.wonder.Entity;

public class Excel {
int id;
String excelname;
String date;
String location;
String status;
public Excel(){
	
}
public void Excel(int id,String en,String date,String location,String status){
	this.id =id;
	this.excelname=en;
	this.location=location;
	this.status=status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getExcelname() {
	return excelname;
}
public void setExcelname(String excelname) {
	this.excelname = excelname;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
