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
 * A type that identifies whether the item is from a verified seller.
 */
@Schema(description = "A type that identifies whether the item is from a verified seller.")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-01-25T17:50:03.851347329Z[GMT]")

public class AuthenticityVerificationProgram {
  @SerializedName("description")
  private String description = null;

  @SerializedName("termsWebUrl")
  private String termsWebUrl = null;

  public AuthenticityVerificationProgram description(String description) {
    this.description = description;
    return this;
  }

   /**
   * An indication that the item is from a verified seller.
   * @return description
  **/
  @Schema(description = "An indication that the item is from a verified seller.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AuthenticityVerificationProgram termsWebUrl(String termsWebUrl) {
    this.termsWebUrl = termsWebUrl;
    return this;
  }

   /**
   * The URL to the Authenticity Verification program terms of use.
   * @return termsWebUrl
  **/
  @Schema(description = "The URL to the Authenticity Verification program terms of use.")
  public String getTermsWebUrl() {
    return termsWebUrl;
  }

  public void setTermsWebUrl(String termsWebUrl) {
    this.termsWebUrl = termsWebUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticityVerificationProgram authenticityVerificationProgram = (AuthenticityVerificationProgram) o;
    return Objects.equals(this.description, authenticityVerificationProgram.description) &&
        Objects.equals(this.termsWebUrl, authenticityVerificationProgram.termsWebUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, termsWebUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticityVerificationProgram {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    termsWebUrl: ").append(toIndentedString(termsWebUrl)).append("\n");
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
