package com.corhuila.app_explora_neiva.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "sitio_turistico", uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }) })
public class SitioTuristico extends ABaseEntity {

    @Column(name = "code", nullable = false, length = 20, unique = true)
    private String code;

    @Column(name = "title", nullable = false, length = 100, unique = true)
    private String title;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "imageUrl", nullable = false, length = 500)
    private String imageUrl;

    @Column(name = "location", nullable = false, length = 150)
    private String location;

    @Column(name = "schedule", nullable = false, length = 50)
    private String schedule;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "contact", nullable = false, length = 50)
    private String contact;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}