package lab2.sw2.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CountriesEntity {
    @Id
    private
    int country_id;
    private String country_name;
    private Double region_id;

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Double getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Double region_id) {
        this.region_id = region_id;
    }
}
