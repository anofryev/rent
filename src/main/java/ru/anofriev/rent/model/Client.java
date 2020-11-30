package ru.anofriev.rent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {

    @Id
    @Column(name="client_id")
    @SequenceGenerator(name = "clientIdSeq", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdSeq")
    private Integer client_id;

    @Column(name="first_name_client")
    private String first_name_client;

    @Column(name="last_name_client")
    private String last_name_client;

    @Column(name="middle_name_client")
    private String middle_name_client;

    @Column(name="phone_client")
    private String phone_client;

    //Getter / Setters

    public Integer getClient_id(){return client_id;}
    public void setClient_id(Integer id_client){this.client_id = id_client;}

    public String getFirst_name_client(){return first_name_client;}
    public void setFirst_name_client(String first_name_client){this.first_name_client = first_name_client;}

    public String getLast_name_client(){return last_name_client;}
    public void setLast_name_client(String last_name_client){this.last_name_client = last_name_client;}

    public String getMiddle_name_client(){return middle_name_client;}
    public void setMiddle_name_client(String middle_name_client){this.middle_name_client = middle_name_client;}

    public String getPhone_client(){return phone_client;}
    public void setPhone_client(String phone_client){this.phone_client = phone_client;}
}
