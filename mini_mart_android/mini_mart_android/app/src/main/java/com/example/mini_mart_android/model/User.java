package com.example.mini_mart_android.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String _id;
    private String name;
    private String phone;
    private List<Order> orders;

    public User(String _id, String name, String phone, String password, boolean admin, List<Order> orders) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.orders = orders;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}




