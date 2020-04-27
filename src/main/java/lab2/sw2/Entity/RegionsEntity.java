package lab2.sw2.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class RegionsEntity {
    @Id
    private
    Double region_id;
    private String region_name;

    public Double getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Double region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
