package fon.silab.njt.spring.mvc.demomvcapplication.dto;

import java.io.Serializable;

public class CityDto implements Serializable {

    private static final long serialVersionUID = 2151959395889955260L;
    private Long number;
    private String name;
    private CountryDto country;

    public CityDto() {
        country = new CountryDto();
    }

    public CityDto(Long number, String name) {
        super();
        this.number = number;
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityDto [number=" + number + ", name=" + name + country + "]";
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }
}
