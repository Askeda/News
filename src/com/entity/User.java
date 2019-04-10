package com.entity;

public class User {
private String name;//–’√˚
private int id;//id
private String pwd;//√‹¬Î
public User(){}
public User(String name,String pwd,int id){
	this.id=id;
	this.name=name;
	this.pwd=pwd;
}

public User(String pwd){
	this.pwd=pwd;
}
public User(String name,String pwd){
	this.name=name;
	this.pwd=pwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public String toString() {
	return "User [name=" + name + ", id=" + id + ", pwd=" + pwd + "]";
}

}
