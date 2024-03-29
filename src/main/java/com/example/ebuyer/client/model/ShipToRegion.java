package com.example.ebuyer.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;

import java.util.Objects;

import static com.example.ebuyer.client.StringUtil.toIndentedString;

/**
 * This type is used provide details about included and excluded shipping regions.
 */
@Setter
@Schema(description = "This type is used provide details about included and excluded shipping regions.")
public class ShipToRegion {
    @SerializedName("regionId")
    private String regionId = null;

    @SerializedName("regionName")
    private String regionName = null;

    @SerializedName("regionType")
    private String regionType = null;

    public ShipToRegion regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    /**
     * The unique identifier of the shipping region. The value returned here is dependent on
     * the corresponding <b>regionType</b> value. The <b>regionId</b> value for a region does
     * not vary based on the eBay marketplace. However, the corresponding <b>regionName</b> value
     * for a region is a localized, text-based description of the shipping region. <br><br> If
     * the <b>regionType</b> value is <code>WORLDWIDE</code>, the <b>regionId</b> value will also
     * be <code>WORLDWIDE</code>.<br><br> If the <b>regionType</b> value is <code>WORLD_REGION</code>,
     * the <b>regionId</b> value will be one of the following: <code>AFRICA</code>, <code>AMERICAS</code>,
     * <code>ASIA</code>, <code>AUSTRALIA</code>, <code>CENTRAL_AMERICA_AND_CARIBBEAN</code>,
     * <code>EUROPE</code>, <code>EUROPEAN_UNION</code>, <code>GREATER_CHINA</code>,
     * <code>MIDDLE_EAST</code>, <code>NORTH_AMERICA</code>, <code>OCEANIA</code>,
     * <code>SOUTH_AMERICA</code>, <code>SOUTHEAST_ASIA</code> or <code>CHANNEL_ISLANDS</code>.
     * <br><br>If the <b>regionType</b> value is <code>COUNTRY</code>, the <b>regionId</b>
     * value will be the two-letter code for the country, as defined in the
     * <a href="https://www.iso.org/iso-3166-country-codes.html " target="_blank">ISO 3166</a>
     * standard.<br><br>If the <b>regionType</b> value is <code>STATE_OR_PROVINCE</code>,
     * the <b>regionId</b> value will either be the two-letter code for US states and DC
     * (as defined on this <a href="https://www.ssa.gov/international/coc-docs/states.html " target="_blank">
     * Social Security Administration</a> page), or the two-letter code for Canadian provinces
     * (as defined by this
     * <a href="https://www.canadapost.ca/tools/pg/manual/PGaddress-e.asp?ecid=murl10006450#1442131 " target="_blank">
     * Canada Post</a> page).<br><br>If the <b>regionType</b> value is <code>COUNTRY_REGION</code>,
     * the <b>regionId</b> value may be one of following: <code>_AH</code> (if a seller is not
     * willing to ship to Alaska/Hawaii), <code>_PR</code> (if the seller is not willing to ship
     * to US Protectorates), <code>_AP</code> (if seller is not willing to ship to a US Army or
     * Fleet Post Office), and <code>PO_BOX</code> (if the seller is not willing to ship to a Post Office Box).
     *
     * @return regionId
     **/
    @Schema(description = "The unique identifier of the shipping region. The value returned here is " +
            "dependent on the corresponding <b>regionType</b> value. The <b>regionId</b> value for " +
            "a region does not vary based on the eBay marketplace. However, the corresponding <b>regionName</b> " +
            "value for a region is a localized, text-based description of the shipping region. <br><br> " +
            "If the <b>regionType</b> value is <code>WORLDWIDE</code>, the <b>regionId</b> value will also " +
            "be <code>WORLDWIDE</code>.<br><br> If the <b>regionType</b> value is <code>WORLD_REGION</code>, " +
            "the <b>regionId</b> value will be one of the following: <code>AFRICA</code>, <code>AMERICAS</code>, " +
            "<code>ASIA</code>, <code>AUSTRALIA</code>, <code>CENTRAL_AMERICA_AND_CARIBBEAN</code>, " +
            "<code>EUROPE</code>, <code>EUROPEAN_UNION</code>, <code>GREATER_CHINA</code>, " +
            "<code>MIDDLE_EAST</code>, <code>NORTH_AMERICA</code>, <code>OCEANIA</code>, " +
            "<code>SOUTH_AMERICA</code>, <code>SOUTHEAST_ASIA</code> or <code>CHANNEL_ISLANDS</code>." +
            "<br><br>If the <b>regionType</b> value is <code>COUNTRY</code>, the <b>regionId</b> value " +
            "will be the two-letter code for the country, as defined in the " +
            "<a href=\"https://www.iso.org/iso-3166-country-codes.html \" target=\"_blank\">ISO 3166</a> " +
            "standard.<br><br>If the <b>regionType</b> value is <code>STATE_OR_PROVINCE</code>, " +
            "the <b>regionId</b> value will either be the two-letter code for US states and DC " +
            "(as defined on this " +
            "<a href=\"https://www.ssa.gov/international/coc-docs/states.html \" target=\"_blank\">" +
            "Social Security Administration</a> page), or the two-letter code for Canadian provinces " +
            "(as defined by this " +
            "<a href=\"https://www.canadapost.ca/tools/pg/manual/PGaddress-e.asp?ecid=murl10006450#1442131 \" target=\"_blank\">" +
            "Canada Post</a> page).<br><br>If the <b>regionType</b> value is <code>COUNTRY_REGION</code>, " +
            "the <b>regionId</b> value may be one of following: <code>_AH</code> (if a seller is not willing " +
            "to ship to Alaska/Hawaii), <code>_PR</code> (if the seller is not willing to ship to US Protectorates), " +
            "<code>_AP</code> (if seller is not willing to ship to a US Army or Fleet Post Office), " +
            "and <code>PO_BOX</code> (if the seller is not willing to ship to a Post Office Box).")
    public String getRegionId() {
        return regionId;
    }

    public ShipToRegion regionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    /**
     * A localized text string that indicates the name of the shipping region. The value returned
     * here is dependent on the corresponding <b>regionType</b> value. <br><br> If the <b>regionType</b>
     * value is <code>WORLDWIDE</code>, the <b>regionName</b> value will show <code>Worldwide</code>.
     * <br><br> If the <b>regionType</b> value is <code>WORLD_REGION</code>, the <b>regionName</b>
     * value will be a localized text string for one of the following large geographical regions:
     * Africa, Americas, Asia, Australia, Central America and Caribbean, Europe, European Union,
     * Greater China, Middle East, North America, Oceania, South America, Southeast Asia, or
     * Channel Islands.<br><br>If the <b>regionType</b> value is <code>COUNTRY</code>,
     * the <b>regionName</b> value will be a localized text string for any country in the world.
     * <br><br>If the <b>regionType</b> value is <code>STATE_OR_PROVINCE</code>, the <b>regionName</b>
     * value will be a localized text string for any US state or Canadian province.
     * <br><br>If the <b>regionType</b> value is <code>COUNTRY_REGION</code>, the <b>regionName</b>
     * value may be a localized version of one of the following: Alaska/Hawaii, US Protectorates,
     * APO/FPO (Army or Fleet Post Office), or PO BOX.
     *
     * @return regionName
     **/
    @Schema(description = "A localized text string that indicates the name of the shipping region. " +
            "The value returned here is dependent on the corresponding <b>regionType</b> value. " +
            "<br><br> If the <b>regionType</b> value is <code>WORLDWIDE</code>, the <b>regionName</b> " +
            "value will show <code>Worldwide</code>.<br><br> If the <b>regionType</b> value is " +
            "<code>WORLD_REGION</code>, the <b>regionName</b> value will be a localized text string " +
            "for one of the following large geographical regions: Africa, Americas, Asia, Australia, " +
            "Central America and Caribbean, Europe, European Union, Greater China, Middle East, " +
            "North America, Oceania, South America, Southeast Asia, or Channel Islands." +
            "<br><br>If the <b>regionType</b> value is <code>COUNTRY</code>, the <b>regionName</b> " +
            "value will be a localized text string for any country in the world." +
            "<br><br>If the <b>regionType</b> value is <code>STATE_OR_PROVINCE</code>, " +
            "the <b>regionName</b> value will be a localized text string for any US state or " +
            "Canadian province. <br><br>If the <b>regionType</b> value is <code>COUNTRY_REGION</code>, " +
            "the <b>regionName</b> value may be a localized version of one of the following: Alaska/Hawaii, " +
            "US Protectorates, APO/FPO (Army or Fleet Post Office), or PO BOX.")
    public String getRegionName() {
        return regionName;
    }

    public ShipToRegion regionType(String regionType) {
        this.regionType = regionType;
        return this;
    }

    /**
     * An enumeration value that indicates the level or type of shipping region.
     * <br><br><b> Valid Values: </b> <ul><li><b> COUNTRY_REGION </b> - Indicates the region
     * is a domestic region or special location within a country.</li>
     * <li><b> STATE_OR_PROVINCE </b> - Indicates the region is a state or province within a country,
     * such as California or New York in the US, or Ontario or Alberta in Canada.</li>
     * <li><b> COUNTRY </b> - Indicates the region is a single country.</li>
     * <li><b> WORLD_REGION </b> - Indicates the region is a world region, such as Africa, the Middle
     * East, or Southeast Asia.</li><li><b> WORLDWIDE </b> - Indicates the region is the entire world.
     * This value is only applicable for included shiping regions, and not excluded shipping regions.</li></ul>
     * For more detail on the actual <b>regionName</b>/<b>regionId</b> values that will be returned based on
     * the <b>regionType</b> value, see the
     * <a href="/api-docs/buy/browse/resources/item/methods/getItem#response.shipToLocations.regionExcluded.regionId">
     * regionId</a> and/or
     * <a href="/api-docs/buy/browse/resources/item/methods/getItem#response.shipToLocations.regionExcluded.regionName">
     * regionName</a> field descriptions.
     * <br><br> Code so that your app gracefully handles any future changes to this list.
     * For implementation help, refer to
     * <a href='https://developer.ebay.com/api-docs/buy/browse/types/ba:RegionTypeEnum'>eBay API documentation</a>
     *
     * @return regionType
     **/
    @Schema(description = "An enumeration value that indicates the level or type of shipping region. " +
            "<br><br><b> Valid Values: </b> <ul><li><b> COUNTRY_REGION </b> - Indicates the region is " +
            "a domestic region or special location within a country.</li>" +
            "<li><b> STATE_OR_PROVINCE </b> - Indicates the region is a state or province within " +
            "a country, such as California or New York in the US, or Ontario or Alberta in Canada.</li>" +
            "<li><b> COUNTRY </b> - Indicates the region is a single country.</li>" +
            "<li><b> WORLD_REGION </b> - Indicates the region is a world region, such as Africa, " +
            "the Middle East, or Southeast Asia.</li><li><b> WORLDWIDE </b> - Indicates the region is " +
            "the entire world. This value is only applicable for included shiping regions, and not " +
            "excluded shipping regions.</li></ul> For more detail on the actual " +
            "<b>regionName</b>/<b>regionId</b> values that will be returned based on the " +
            "<b>regionType</b> value, see the " +
            "<a href=\"/api-docs/buy/browse/resources/item/methods/getItem#response.shipToLocations.regionExcluded.regionId\">" +
            "regionId</a> and/or " +
            "<a href=\"/api-docs/buy/browse/resources/item/methods/getItem#response.shipToLocations.regionExcluded.regionName\">" +
            "regionName</a> field descriptions." +
            "<br><br> Code so that your app gracefully handles any future changes to this list. " +
            "For implementation help, refer to " +
            "<a href='https://developer.ebay.com/api-docs/buy/browse/types/ba:RegionTypeEnum'>eBay API documentation</a>")
    public String getRegionType() {
        return regionType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShipToRegion shipToRegion = (ShipToRegion) o;
        return Objects.equals(this.regionId, shipToRegion.regionId) &&
                Objects.equals(this.regionName, shipToRegion.regionName) &&
                Objects.equals(this.regionType, shipToRegion.regionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, regionName, regionType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShipToRegion {\n");
        sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
        sb.append("    regionName: ").append(toIndentedString(regionName)).append("\n");
        sb.append("    regionType: ").append(toIndentedString(regionType)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
