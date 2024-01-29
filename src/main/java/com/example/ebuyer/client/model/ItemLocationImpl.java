/*
 * Browse API
 * <p>The Browse API has the following resources:</p>   <ul> <li><b> item_summary: </b> Lets shoppers search for specific items by keyword, GTIN, category, charity, product, image </b><a href=\"/api-docs/static/versioning.html#experimental \" target=\"_blank\"><img src=\"/cms/img/docs/experimental-icon.svg\" class=\"legend-icon experimental-icon\" alt=\"Experimental Method\" title=\"Experimental Method\" />(Experimental Method)</a>, or item aspects and refine the results by using filters, such as aspects, compatibility, and fields values, or UI parameters.</li>   <li><b> item: </b> <ul><li>Lets you retrieve the details of a specific item or all the items in an item group, which is an item with variations such as color and size and check if a product is compatible with the specified item, such as if a specific car is compatible with a specific part.</li> <li>Provides a bridge between the eBay legacy APIs, such as <b> Finding</b>, and the RESTful APIs, which use different formats for the item IDs.</li>  </ul> </li>  </ul>       <p>The <b> item_summary</b>, <b> search_by_image</b>, and <b> item</b> resource calls require an <a href=\"/api-docs/static/oauth-client-credentials-grant.html\">Application access token</a>.</p>
 *
 * OpenAPI spec version: v1.19.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.example.ebuyer.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * The type that defines the fields for the location of an item, such as information typically used for an address, including postal code, county, state/province, street address, city, and country (2-digit ISO code).
 */
@Schema(description = "The type that defines the fields for the location of an item, such as information typically used for an address, including postal code, county, state/province, street address, city, and country (2-digit ISO code).")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-01-25T17:50:03.851347329Z[GMT]")

public class ItemLocationImpl {
  @SerializedName("addressLine1")
  private String addressLine1 = null;

  @SerializedName("addressLine2")
  private String addressLine2 = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("county")
  private String county = null;

  @SerializedName("postalCode")
  private String postalCode = null;

  @SerializedName("stateOrProvince")
  private String stateOrProvince = null;

  public ItemLocationImpl addressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

   /**
   * The first line of the street address.
   * @return addressLine1
  **/
  @Schema(description = "The first line of the street address.")
  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public ItemLocationImpl addressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

   /**
   * The second line of the street address. This field may contain such values as an apartment or suite number.
   * @return addressLine2
  **/
  @Schema(description = "The second line of the street address. This field may contain such values as an apartment or suite number.")
  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public ItemLocationImpl city(String city) {
    this.city = city;
    return this;
  }

   /**
   * The city in which the item is located. &lt;br&gt;&lt;br&gt;&lt;b&gt;Restriction:&lt;/b&gt; This field is populated in the &lt;b&gt; search&lt;/b&gt; method response &lt;i&gt; only&lt;/i&gt; when &lt;b&gt; fieldgroups&lt;/b&gt; &#x3D; &lt;code&gt;EXTENDED&lt;/code&gt;.
   * @return city
  **/
  @Schema(description = "The city in which the item is located. <br><br><b>Restriction:</b> This field is populated in the <b> search</b> method response <i> only</i> when <b> fieldgroups</b> = <code>EXTENDED</code>.")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ItemLocationImpl country(String country) {
    this.country = country;
    return this;
  }

   /**
   * The two-letter &lt;a href&#x3D;\&quot;https://www.iso.org/iso-3166-country-codes.html \&quot;&gt;ISO 3166&lt;/a&gt; standard code that indicates the country in which the item is located.  For implementation help, refer to &lt;a href&#x3D;&#x27;https://developer.ebay.com/api-docs/buy/browse/types/ba:CountryCodeEnum&#x27;&gt;eBay API documentation&lt;/a&gt;
   * @return country
  **/
  @Schema(description = "The two-letter <a href=\"https://www.iso.org/iso-3166-country-codes.html \">ISO 3166</a> standard code that indicates the country in which the item is located.  For implementation help, refer to <a href='https://developer.ebay.com/api-docs/buy/browse/types/ba:CountryCodeEnum'>eBay API documentation</a>")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ItemLocationImpl county(String county) {
    this.county = county;
    return this;
  }

   /**
   * The county in which the item is located.
   * @return county
  **/
  @Schema(description = "The county in which the item is located.")
  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public ItemLocationImpl postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   * The postal code (or zip code in US) where the item is located. Sellers set a postal code (or zip code in US) for items when they are listed. The postal code is used for calculating proximity searches. It is anonymized when returned in &lt;b&gt;itemLocation.postalCode&lt;/b&gt; via the API.
   * @return postalCode
  **/
  @Schema(description = "The postal code (or zip code in US) where the item is located. Sellers set a postal code (or zip code in US) for items when they are listed. The postal code is used for calculating proximity searches. It is anonymized when returned in <b>itemLocation.postalCode</b> via the API.")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public ItemLocationImpl stateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
    return this;
  }

   /**
   * The state or province in which the item is located.
   * @return stateOrProvince
  **/
  @Schema(description = "The state or province in which the item is located.")
  public String getStateOrProvince() {
    return stateOrProvince;
  }

  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemLocationImpl itemLocationImpl = (ItemLocationImpl) o;
    return Objects.equals(this.addressLine1, itemLocationImpl.addressLine1) &&
        Objects.equals(this.addressLine2, itemLocationImpl.addressLine2) &&
        Objects.equals(this.city, itemLocationImpl.city) &&
        Objects.equals(this.country, itemLocationImpl.country) &&
        Objects.equals(this.county, itemLocationImpl.county) &&
        Objects.equals(this.postalCode, itemLocationImpl.postalCode) &&
        Objects.equals(this.stateOrProvince, itemLocationImpl.stateOrProvince);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressLine1, addressLine2, city, country, county, postalCode, stateOrProvince);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemLocationImpl {\n");
    
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
