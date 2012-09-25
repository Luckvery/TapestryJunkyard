package com.example.junkyard.domain.reference;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Table(name = "zip_codes")
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ZipCode {
    private Integer id;
    private String zipCode;
    private Character zipType;
    private String cityName;
    private Character cityType;
    private String countyName;
    private Integer countyFips;
    private String stateName;
    private String stateAbbr;
    private Integer stateFips;
    private Integer msaCode;
    private String areaCode;
    private String timeZone;
    private Double utc;
    private Boolean dst;
    private Double latitude;
    private Double longitude;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "zip_codes_seq", allocationSize = 1, initialValue = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "zip_code", length = 5)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "zip_type")
    public Character getZipType() {
        return zipType;
    }

    public void setZipType(Character zipType) {
        this.zipType = zipType;
    }

    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "city_type")
    public Character getCityType() {
        return cityType;
    }

    public void setCityType(Character cityType) {
        this.cityType = cityType;
    }

    @Column(name = "county_name")
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Column(name = "county_fips")
    public Integer getCountyFips() {
        return countyFips;
    }

    public void setCountyFips(Integer countyFips) {
        this.countyFips = countyFips;
    }

    @Column(name = "state_name")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Column(name = "state_abbr", length = 2)
    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    @Column(name = "state_fips")
    public Integer getStateFips() {
        return stateFips;
    }

    public void setStateFips(Integer stateFips) {
        this.stateFips = stateFips;
    }

    @Column(name = "msa_code")
    public Integer getMsaCode() {
        return msaCode;
    }

    public void setMsaCode(Integer msaCode) {
        this.msaCode = msaCode;
    }

    @Column(name = "area_code")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Column(name = "time_zone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Double getUtc() {
        return utc;
    }

    public void setUtc(Double utc) {
        this.utc = utc;
    }

    @Type(type = "yes_no")
    public Boolean getDst() {
        return dst;
    }

    public void setDst(Boolean dst) {
        this.dst = dst;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static ZipCode createZipCodeFromCsv(String csv) {
        ZipCode zipCode = new ZipCode();

        String[] parts = csv.split(",");
        zipCode.setZipCode(parts[0]);
        zipCode.setZipType(parts[1].charAt(0));
        zipCode.setCityName(parts[2]);
        zipCode.setCityType(parts[3].charAt(0));
        zipCode.setCountyName(parts[4]);
        zipCode.setCountyFips(Integer.valueOf(parts[5]));
        zipCode.setStateName(parts[6]);
        zipCode.setStateAbbr(parts[7]);
        zipCode.setStateFips(Integer.valueOf(parts[8]));
        zipCode.setMsaCode(Integer.valueOf(parts[9]));
        zipCode.setAreaCode(parts[10]);
        zipCode.setTimeZone(parts[11]);
        zipCode.setUtc(Double.valueOf(parts[12]));
        zipCode.setDst("Y".equals(parts[13].trim()));
        zipCode.setLatitude(Double.valueOf(parts[14]));
        zipCode.setLongitude(Double.valueOf(parts[15]));
        return zipCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("id", id).
                append("zipCode", zipCode).
                append("zipType", zipType).
                append("cityName", cityName).
                append("cityType", cityType).
                append("countyName", countyName).
                append("countyFips", countyFips).
                append("stateName", stateName).
                append("stateAbbr", stateAbbr).
                append("stateFips", stateFips).
                append("msaCode", msaCode).
                append("areaCode", areaCode).
                append("timeZone", timeZone).
                append("utc", utc).
                append("dst", dst).
                append("latitude", latitude).
                append("longitude", longitude).
                toString();
    }
}
