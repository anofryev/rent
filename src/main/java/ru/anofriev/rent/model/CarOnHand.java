package ru.anofriev.rent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "car_on_hands")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarOnHand {
    @Id
    @Column(name = "id_car_on_hand")
    @SequenceGenerator(name = "id_car_on_handSeq", sequenceName = "id_car_on_hand_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_car_on_handSeq")
    private Integer idCarOnHand;

    @ManyToOne//(cascade = {CascadeType.ALL}) //Убрал optional
    @JoinColumn (name="id_car")
    private Car car;

    @ManyToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name="client_id")
    private Client client;


    //Getters / setters


    public Integer getIdCarOnHand() {return idCarOnHand;}
    public void setIdCarOnHand(Integer id_car) {this.idCarOnHand = id_car;}

    public void setCar(Car car){this.car = car;}
   // @JsonIgnore
    public Car getCar(){return car;}

    public Client getClient(){return client;}
    public void setClient(Client client){this.client = client;}
}
