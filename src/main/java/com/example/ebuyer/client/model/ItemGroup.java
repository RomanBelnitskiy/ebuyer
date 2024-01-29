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
 * The type that defines the fields for the item details.
 */
@Schema(description = "The type that defines the fields for the item details.")
@Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-01-25T17:50:03.851347329Z[GMT]")

public class ItemGroup {
  @SerializedName("commonDescriptions")
  private List<CommonDescriptions> commonDescriptions = null;

  @SerializedName("items")
  private List<Item> items = null;

  @SerializedName("warnings")
  private List<Error> warnings = null;

  public ItemGroup commonDescriptions(List<CommonDescriptions> commonDescriptions) {
    this.commonDescriptions = commonDescriptions;
    return this;
  }

  public ItemGroup addCommonDescriptionsItem(CommonDescriptions commonDescriptionsItem) {
    if (this.commonDescriptions == null) {
      this.commonDescriptions = new ArrayList<CommonDescriptions>();
    }
    this.commonDescriptions.add(commonDescriptionsItem);
    return this;
  }

   /**
   * An array of containers for a description and the item IDs of all the items that have this exact description. Often the item variations within an item group all have the same description. Instead of repeating this description in the item details of each item, a description that is shared by at least one other item is returned in this container. If the description is unique, it is returned in the &lt;b&gt; items.description&lt;/b&gt; field.
   * @return commonDescriptions
  **/
  @Schema(description = "An array of containers for a description and the item IDs of all the items that have this exact description. Often the item variations within an item group all have the same description. Instead of repeating this description in the item details of each item, a description that is shared by at least one other item is returned in this container. If the description is unique, it is returned in the <b> items.description</b> field.")
  public List<CommonDescriptions> getCommonDescriptions() {
    return commonDescriptions;
  }

  public void setCommonDescriptions(List<CommonDescriptions> commonDescriptions) {
    this.commonDescriptions = commonDescriptions;
  }

  public ItemGroup items(List<Item> items) {
    this.items = items;
    return this;
  }

  public ItemGroup addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<Item>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * An array of containers for all the item variation details, excluding the description.
   * @return items
  **/
  @Schema(description = "An array of containers for all the item variation details, excluding the description.")
  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public ItemGroup warnings(List<Error> warnings) {
    this.warnings = warnings;
    return this;
  }

  public ItemGroup addWarningsItem(Error warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<Error>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

   /**
   * An array of warning messages. These types of errors do not prevent the method from executing but should be checked.
   * @return warnings
  **/
  @Schema(description = "An array of warning messages. These types of errors do not prevent the method from executing but should be checked.")
  public List<Error> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<Error> warnings) {
    this.warnings = warnings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemGroup itemGroup = (ItemGroup) o;
    return Objects.equals(this.commonDescriptions, itemGroup.commonDescriptions) &&
        Objects.equals(this.items, itemGroup.items) &&
        Objects.equals(this.warnings, itemGroup.warnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonDescriptions, items, warnings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemGroup {\n");
    
    sb.append("    commonDescriptions: ").append(toIndentedString(commonDescriptions)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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
