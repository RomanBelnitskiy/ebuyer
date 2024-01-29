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
 * The type that defines the fields that describe a seller discount.
 */
@Schema(description = "The type that defines the fields that describe a seller discount.")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-01-25T17:50:03.851347329Z[GMT]")

public class MarketingPrice {
  @SerializedName("discountAmount")
  private ConvertedAmount discountAmount = null;

  @SerializedName("discountPercentage")
  private String discountPercentage = null;

  @SerializedName("originalPrice")
  private ConvertedAmount originalPrice = null;

  @SerializedName("priceTreatment")
  private String priceTreatment = null;

  public MarketingPrice discountAmount(ConvertedAmount discountAmount) {
    this.discountAmount = discountAmount;
    return this;
  }

   /**
   * Get discountAmount
   * @return discountAmount
  **/
  @Schema(description = "")
  public ConvertedAmount getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(ConvertedAmount discountAmount) {
    this.discountAmount = discountAmount;
  }

  public MarketingPrice discountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
    return this;
  }

   /**
   * This field expresses the percentage of the seller discount based on the value in the &lt;b&gt;  originalPrice&lt;/b&gt; container.
   * @return discountPercentage
  **/
  @Schema(description = "This field expresses the percentage of the seller discount based on the value in the <b>  originalPrice</b> container.")
  public String getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public MarketingPrice originalPrice(ConvertedAmount originalPrice) {
    this.originalPrice = originalPrice;
    return this;
  }

   /**
   * Get originalPrice
   * @return originalPrice
  **/
  @Schema(description = "")
  public ConvertedAmount getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(ConvertedAmount originalPrice) {
    this.originalPrice = originalPrice;
  }

  public MarketingPrice priceTreatment(String priceTreatment) {
    this.priceTreatment = priceTreatment;
    return this;
  }

   /**
   * Indicates the pricing treatment (discount) that was applied to the price of the item. &lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note: &lt;/b&gt; The pricing treatment affects the way and where the discounted price can be displayed.&lt;/span&gt; For implementation help, refer to &lt;a href&#x3D;&#x27;https://developer.ebay.com/api-docs/buy/browse/types/gct:PriceTreatmentEnum&#x27;&gt;eBay API documentation&lt;/a&gt;
   * @return priceTreatment
  **/
  @Schema(description = "Indicates the pricing treatment (discount) that was applied to the price of the item. <br><br><span class=\"tablenote\"><b>Note: </b> The pricing treatment affects the way and where the discounted price can be displayed.</span> For implementation help, refer to <a href='https://developer.ebay.com/api-docs/buy/browse/types/gct:PriceTreatmentEnum'>eBay API documentation</a>")
  public String getPriceTreatment() {
    return priceTreatment;
  }

  public void setPriceTreatment(String priceTreatment) {
    this.priceTreatment = priceTreatment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarketingPrice marketingPrice = (MarketingPrice) o;
    return Objects.equals(this.discountAmount, marketingPrice.discountAmount) &&
        Objects.equals(this.discountPercentage, marketingPrice.discountPercentage) &&
        Objects.equals(this.originalPrice, marketingPrice.originalPrice) &&
        Objects.equals(this.priceTreatment, marketingPrice.priceTreatment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discountAmount, discountPercentage, originalPrice, priceTreatment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarketingPrice {\n");
    
    sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
    sb.append("    discountPercentage: ").append(toIndentedString(discountPercentage)).append("\n");
    sb.append("    originalPrice: ").append(toIndentedString(originalPrice)).append("\n");
    sb.append("    priceTreatment: ").append(toIndentedString(priceTreatment)).append("\n");
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
