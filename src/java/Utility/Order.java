/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author Roman
 */
public class Order {

    private String name = "";
    private String surname = "";
    private String email = "";
    private String tel = "";
    private String room_star = "";
    private String room_beds = "";
    private String datefrom = "";
    private String dateto = "";
    private String clients_id = "";
    private String order_id = "";
    private String hotel_number = "";
    private String summary = "";
    private String status = "";
    private String show_user = "";
    private String apartment_id = "";
    private String paid = "";

    @Override
    public String toString() {
        return this.clients_id + "-" + this.datefrom + "-" + this.dateto + "-"
                + this.email + "-" + this.hotel_number + "-" + this.name + "-" + this.name
                + "-" + this.order_id + "-" + this.room_star + "-" + this.room_beds;
    }

    public void setApartmentId(String apartment_id) {
        this.apartment_id = apartment_id;
    }

    public String getApartmentId() {
        return this.apartment_id;
    }
    
     public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPaid() {
        return this.paid;
    }

    public void setShowUser(String show_user) {
        this.show_user = show_user;
    }

    public String getShowUser() {
        return this.show_user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;

    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;

    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return this.tel;

    }

    public void setRoomStar(String room_star) {
        this.room_star = room_star;
    }

    public String getRoomStar() {
        return this.room_star;

    }

    public void setRoomBeds(String room_beds) {
        this.room_beds = room_beds;
    }

    public String getRoomBeds() {
        return this.room_beds;

    }

    public void setDateFrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getDateFrom() {
        return this.datefrom;

    }

    public void setDateTo(String dateto) {
        this.dateto = dateto;
    }

    public String getDateTo() {
        return this.dateto;

    }

    public void setClientsId(String clients_id) {
        this.clients_id = clients_id;
    }

    public String getClientsId() {
        return this.clients_id;

    }

    public void setOrderId(String order_id) {
        this.order_id = order_id;
    }

    public String getOrderId() {
        return this.order_id;

    }

    public void setHotelNumber(String hotel_number) {
        this.hotel_number = hotel_number;
    }

    public String getHotelNumber() {
        return this.hotel_number;

    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return this.summary;

    }
}
