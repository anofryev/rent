package ru.anofriev.rent.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//Стили (тип кузова)
@Entity
@Table(name = "styles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Style {

    @Id
    @Column(name="id_style")
    @SequenceGenerator(name = "styleIdSeq", sequenceName = "style_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "styleIdSeq")
    private Integer idStyle;

    @Column(name="name_style")
    private String nameStyle;

    //Getter / Setters

    public Integer getIdStyle(){return idStyle;}
    public void setIdStyle(Integer id_style){this.idStyle = id_style;}

    public String getNameStyle(){return nameStyle;}
    public void setNameStyle(String name_style){this.nameStyle = name_style;}
}
