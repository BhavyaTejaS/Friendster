package com.app.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Friend-S180396")
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int Id;
private User fromId;
private User toId;
private char Status;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public User getFromId() {
	return fromId;
}
public void setFromId(User fromId) {
	this.fromId = fromId;
}
public User getToId() {
	return toId;
}
public void setToId(User toId) {
	this.toId = toId;
}
public char getStatus() {
	return Status;
}
public void setStatus(char status) {
	Status = status;
}

}
