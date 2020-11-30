package ru.anofriev.rent.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//Производитель
@Entity
@Table(name = "manufacturers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manufacturer {
    @Id
    @Column(name="id_manufacturer")
    @SequenceGenerator(name = "manufacturerIdSeq", sequenceName = "manufacturer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturerIdSeq")
    private Integer idManufacturer;

    @Column(name="name_manufacturer")
    private String nameManufacturer;

    //Getter / Setters

    public Integer getIdManufacturer(){return idManufacturer;}
    public void setIdManufacturer(Integer id_manufacturer){this.idManufacturer = id_manufacturer;}

    public String getNameManufacturer(){return nameManufacturer;}
    public void setNameManufacturer(String name_manufacturer){this.nameManufacturer = name_manufacturer;}

}
