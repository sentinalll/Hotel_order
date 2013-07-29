
package Utility;

/**
 *
 * @author Roman
 */
public class Apartment {

    private String name;
    private String beds;
    private String star;
    private String price;
    private String booked_untill;
    private String id;

    public void setRoomStar(String star) {
        this.star = star;
    }

    public String getRoomStar() {
        return this.star;

    }

    public void setRoomBeds(String beds) {
        this.beds = beds;
    }

    public String getRoomBeds() {
        return this.beds;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;

    }

    public void setBookedUntill(String booked_until) {
        this.booked_untill = booked_until;
    }

    public String getBookedUntil() {
        return this.booked_untill;

    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return this.price;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;

    }
}
