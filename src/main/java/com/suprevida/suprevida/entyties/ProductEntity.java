package com.suprevida.suprevida.entyties;

import jakarta.persistence.*;


@Entity(name = "products")
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private  String name;

    @Column(nullable = false)
    private  String description;


    @Column(nullable = false)
    private  float price;



    public ProductEntity(String name, String description,float price) {
        this.name =name;
        this.description = description;
        this.price =  price;
    }
    public ProductEntity(Long id,String name, String description,float price) {
        this.name =name;
        this.description = description;
        this.price =  price;
        this.id = id;
    }
    public   ProductEntity(Long id){
        this.id=id;
    }


    public   ProductEntity(){}


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
