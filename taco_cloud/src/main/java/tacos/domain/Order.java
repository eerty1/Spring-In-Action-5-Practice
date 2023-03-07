package tacos.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.CreditCardNumber;
import tacos.security.users_domain.User;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Taco_Order")
@JsonDeserialize()
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "deliveryname")
    @NotBlank(message = "Name is required")
    private String name;
    @Column(name = "deliverystreet")
    @NotBlank(message = "Street is required")
    private String street;
    @Column(name = "deliverycity")
    @NotBlank(message = "City is required")
    private String city;
    @Column(name = "deliverystate")
    @NotBlank(message = "State is required")
    private String state;
    @Column(name = "deliveryzip")
    @NotBlank(message = "Zip is required")
    private String zip;
    @Column(name = "ccnumber")
    @CreditCardNumber(message = "Not valid credit card number")
    private String ccNumber;
    @Column(name = "ccexpiration")
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Column(name = "cccvv")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
    @Column(name = "placedat")
    private Date placedAt;
    @ManyToOne
    private User user;
    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public Order() {
    }

    public Order(Long id, String name, String street, String city, String state, String zip, String ccNumber, String ccExpiration, String ccCVV, Date placedAt, User user, List<Taco> tacos) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;
        this.placedAt = placedAt;
        this.user = user;
        this.tacos = tacos;
    }

    @PrePersist
    void placedAt() {
        placedAt = new Date();
    }

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public void setTacos(List<Taco> tacos) {
        this.tacos = tacos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(name, order.name) && Objects.equals(street, order.street) && Objects.equals(city, order.city) && Objects.equals(state, order.state) && Objects.equals(zip, order.zip) && Objects.equals(ccNumber, order.ccNumber) && Objects.equals(ccExpiration, order.ccExpiration) && Objects.equals(ccCVV, order.ccCVV) && Objects.equals(placedAt, order.placedAt) && Objects.equals(user, order.user) && Objects.equals(tacos, order.tacos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zip, ccNumber, ccExpiration, ccCVV, placedAt, user, tacos);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccExpiration='" + ccExpiration + '\'' +
                ", ccCVV='" + ccCVV + '\'' +
                ", placedAt=" + placedAt +
                ", user=" + user +
                ", tacos=" + tacos +
                '}';
    }
}
