package ru.anofriev.rent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {

    @Id
    @Column(name = "id_car")
    @SequenceGenerator(name = "carsIdSeq", sequenceName = "cars_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carsIdSeq")
    private Integer id_car;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_manufacturer")
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_style")
    private  Style style;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "statenumber")
    private String statenumber;

    //getters setters

    public Integer getId_car(){return id_car;}
    public void setId_car(Integer id_car){this.id_car = id_car;}

    public Manufacturer getId_manufacturer(){return manufacturer;}
    public void setId_manufacturer(Manufacturer manufacturer){this.manufacturer = manufacturer;}

    public Style getStyle(){return style;}
    public void setStyle(Style style){this.style =style;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

//    public CarOnHand getCarOnHand(){return carOnHand;}
//    public void setCarOnHand(CarOnHand carOnHand){this.carOnHand = carOnHand;}

    public String getStatenumber(){return statenumber;}
    public void setStatenumber(String statenumber){this.statenumber = statenumber;}

}
