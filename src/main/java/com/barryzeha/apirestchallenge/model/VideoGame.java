package com.barryzeha.apirestchallenge.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
// Para ordenar el resultado de nuestro objeto json al obtener la respuesta, en algunos casos puede devolver un objeto
// con los campos desordenados
@JsonPropertyOrder({
        "id",
        "title",
        "developer",
        "publisher",
        "genre",
        "platform",
        "releaseDate",
        "price",
        "rating",
        "coverImage",
        "description",
        "isMultiplayer",
        "createdAt",
        "updatedAt",
        "isDeleted"
})
//Debemos poner el nombre que nuestra colección tendrá en la base de datos (collection = "game")
//de lo contrario se usará el nombre de nuestra clase
@Document(collection = "game")
public class VideoGame {
    //@MongoId(FieldType.OBJECT_ID)
    @Id
    // Spring boot manejará el campo _id, no es necesario declararlo explícitamente
    //@Field("_id")
    private String id;

    private String title;
    private String developer;
    private String publisher;
    private String genre;
    private List<String> platform;
    private String releaseDate;
    private double price;
    private double rating;
    private String coverImage;
    private String description;
    private boolean isMultiplayer;
    private String createdAt;
    private String updatedAt;
    private boolean isDeleted;

    public VideoGame(String title, String developer, String publisher, String genre, List<String> platform, String releaseDate, double price, double rating, String coverImage, String description, boolean isMultiplayer, String createdAt, String updatedAt, boolean isDeleted) {
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.genre = genre;
        this.platform = platform;
        this.releaseDate = releaseDate;
        this.price = price;
        this.rating = rating;
        this.coverImage = coverImage;
        this.description = description;
        this.isMultiplayer = isMultiplayer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getPlatform() {
        return platform;
    }

    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        isMultiplayer = multiplayer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    private String getDateTime(){
        return LocalDateTime.now().toString();
    }

}
