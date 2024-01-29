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
 * The container that defines the fields for the conditions refinements. This container is returned when &lt;b&gt; fieldgroups&lt;/b&gt; is set to &lt;code&gt;CONDITION_REFINEMENTS&lt;/code&gt; or &lt;code&gt;FULL&lt;/code&gt; in the request.
 */
@Schema(description = "The container that defines the fields for the conditions refinements. This container is returned when <b> fieldgroups</b> is set to <code>CONDITION_REFINEMENTS</code> or <code>FULL</code> in the request.")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-01-25T17:50:03.851347329Z[GMT]")

public class ConditionDistribution {
  @SerializedName("condition")
  private String condition = null;

  @SerializedName("conditionId")
  private String conditionId = null;

  @SerializedName("matchCount")
  private Integer matchCount = null;

  @SerializedName("refinementHref")
  private String refinementHref = null;

  public ConditionDistribution condition(String condition) {
    this.condition = condition;
    return this;
  }

   /**
   * The text describing the condition of the item, such as New or Used. For a list of condition names, see &lt;a href&#x3D;\&quot;/devzone/finding/callref/enums/conditionIdList.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Item Condition IDs and Names&lt;/a&gt;.  &lt;br&gt;&lt;br&gt;Code so that your app gracefully handles any future changes to this list.
   * @return condition
  **/
  @Schema(description = "The text describing the condition of the item, such as New or Used. For a list of condition names, see <a href=\"/devzone/finding/callref/enums/conditionIdList.html \" target=\"_blank\">Item Condition IDs and Names</a>.  <br><br>Code so that your app gracefully handles any future changes to this list.")
  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public ConditionDistribution conditionId(String conditionId) {
    this.conditionId = conditionId;
    return this;
  }

   /**
   * The identifier of the condition. For example, 1000 is the identifier for NEW.
   * @return conditionId
  **/
  @Schema(description = "The identifier of the condition. For example, 1000 is the identifier for NEW.")
  public String getConditionId() {
    return conditionId;
  }

  public void setConditionId(String conditionId) {
    this.conditionId = conditionId;
  }

  public ConditionDistribution matchCount(Integer matchCount) {
    this.matchCount = matchCount;
    return this;
  }

   /**
   * The number of items having the condition.
   * @return matchCount
  **/
  @Schema(description = "The number of items having the condition.")
  public Integer getMatchCount() {
    return matchCount;
  }

  public void setMatchCount(Integer matchCount) {
    this.matchCount = matchCount;
  }

  public ConditionDistribution refinementHref(String refinementHref) {
    this.refinementHref = refinementHref;
    return this;
  }

   /**
   * The HATEOAS reference of this condition.
   * @return refinementHref
  **/
  @Schema(description = "The HATEOAS reference of this condition.")
  public String getRefinementHref() {
    return refinementHref;
  }

  public void setRefinementHref(String refinementHref) {
    this.refinementHref = refinementHref;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConditionDistribution conditionDistribution = (ConditionDistribution) o;
    return Objects.equals(this.condition, conditionDistribution.condition) &&
        Objects.equals(this.conditionId, conditionDistribution.conditionId) &&
        Objects.equals(this.matchCount, conditionDistribution.matchCount) &&
        Objects.equals(this.refinementHref, conditionDistribution.refinementHref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(condition, conditionId, matchCount, refinementHref);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConditionDistribution {\n");
    
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    conditionId: ").append(toIndentedString(conditionId)).append("\n");
    sb.append("    matchCount: ").append(toIndentedString(matchCount)).append("\n");
    sb.append("    refinementHref: ").append(toIndentedString(refinementHref)).append("\n");
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
