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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * The type that defines the fields that include and exclude geographic regions affecting where the item can be shipped. The seller defines these regions when listing the item.
 */
@Schema(description = "The type that defines the fields that include and exclude geographic regions affecting where the item can be shipped. The seller defines these regions when listing the item.")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-01-25T17:50:03.851347329Z[GMT]")

public class ShipToLocations {
  @SerializedName("regionExcluded")
  private List<ShipToRegion> regionExcluded = null;

  @SerializedName("regionIncluded")
  private List<ShipToRegion> regionIncluded = null;

  public ShipToLocations regionExcluded(List<ShipToRegion> regionExcluded) {
    this.regionExcluded = regionExcluded;
    return this;
  }

  public ShipToLocations addRegionExcludedItem(ShipToRegion regionExcludedItem) {
    if (this.regionExcluded == null) {
      this.regionExcluded = new ArrayList<ShipToRegion>();
    }
    this.regionExcluded.add(regionExcludedItem);
    return this;
  }

   /**
   * An array of containers that express the large geographical regions, countries, state/provinces, or special locations within a country where the seller is not willing to ship to.
   * @return regionExcluded
  **/
  @Schema(description = "An array of containers that express the large geographical regions, countries, state/provinces, or special locations within a country where the seller is not willing to ship to.")
  public List<ShipToRegion> getRegionExcluded() {
    return regionExcluded;
  }

  public void setRegionExcluded(List<ShipToRegion> regionExcluded) {
    this.regionExcluded = regionExcluded;
  }

  public ShipToLocations regionIncluded(List<ShipToRegion> regionIncluded) {
    this.regionIncluded = regionIncluded;
    return this;
  }

  public ShipToLocations addRegionIncludedItem(ShipToRegion regionIncludedItem) {
    if (this.regionIncluded == null) {
      this.regionIncluded = new ArrayList<ShipToRegion>();
    }
    this.regionIncluded.add(regionIncludedItem);
    return this;
  }

   /**
   * An array of containers that express the large geographical regions, countries, or state/provinces within a country where the seller is willing to ship to. Prospective buyers must look at the shipping regions under this container, as well as the shipping regions that are under the &lt;b&gt;regionExcluded&lt;/b&gt; to see where the seller is willing to ship items. Sellers can specify that they ship &#x27;Worldwide&#x27;, but then add several large geographical regions (e.g. Asia, Oceania, Middle East) to the exclusion list, or sellers can specify that they ship to Europe and Africa, but then add several individual countries to the exclusion list.
   * @return regionIncluded
  **/
  @Schema(description = "An array of containers that express the large geographical regions, countries, or state/provinces within a country where the seller is willing to ship to. Prospective buyers must look at the shipping regions under this container, as well as the shipping regions that are under the <b>regionExcluded</b> to see where the seller is willing to ship items. Sellers can specify that they ship 'Worldwide', but then add several large geographical regions (e.g. Asia, Oceania, Middle East) to the exclusion list, or sellers can specify that they ship to Europe and Africa, but then add several individual countries to the exclusion list.")
  public List<ShipToRegion> getRegionIncluded() {
    return regionIncluded;
  }

  public void setRegionIncluded(List<ShipToRegion> regionIncluded) {
    this.regionIncluded = regionIncluded;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShipToLocations shipToLocations = (ShipToLocations) o;
    return Objects.equals(this.regionExcluded, shipToLocations.regionExcluded) &&
        Objects.equals(this.regionIncluded, shipToLocations.regionIncluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionExcluded, regionIncluded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShipToLocations {\n");
    
    sb.append("    regionExcluded: ").append(toIndentedString(regionExcluded)).append("\n");
    sb.append("    regionIncluded: ").append(toIndentedString(regionIncluded)).append("\n");
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
