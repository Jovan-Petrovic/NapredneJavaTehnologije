package fon.silab.njt.spring.mvc.demomvcapplication.dto;

import java.io.Serializable;

public class CountryDto implements Serializable {
	private static final long serialVersionUID = 2151959395889955260L;
	private String shortName;
	private String name;
	
	public CountryDto() {
	}

    public CountryDto(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	
}
