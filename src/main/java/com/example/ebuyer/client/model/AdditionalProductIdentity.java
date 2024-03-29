package com.example.ebuyer.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.ebuyer.client.StringUtil.toIndentedString;

/**
 * The type that defines the array of product identifiers associated with the item.
 * This container is returned if the seller has associated the eBay Product Identifier (ePID)
 * with the item and in the request <b>fieldgroups</b> is set to <code>PRODUCT</code>.
 */
@Setter
@Schema(description = "The type that defines the array of product identifiers associated with the item. " +
        "This container is returned if the seller has associated the eBay Product Identifier (ePID) with " +
        "the item and in the request <b> fieldgroups</b> is set to <code>PRODUCT</code>.")
public class AdditionalProductIdentity {
    @SerializedName("productIdentity")
    private List<ProductIdentity> productIdentity = null;

    public AdditionalProductIdentity productIdentity(List<ProductIdentity> productIdentity) {
        this.productIdentity = productIdentity;
        return this;
    }

    public AdditionalProductIdentity addProductIdentityItem(ProductIdentity productIdentityItem) {
        if (this.productIdentity == null) {
            this.productIdentity = new ArrayList<>();
        }
        this.productIdentity.add(productIdentityItem);
        return this;
    }

    /**
     * An array of the product identifier/value pairs for the product associated with the item.
     * This is returned if the seller has associated the eBay Product Identifier (ePID) with
     * the item and the request has <b>fieldgroups</b> set to <code>PRODUCT</code>.
     * The following table shows what is returned, based on the item information provided by
     * the seller, when the <b>fieldgroups</b> set to <code>PRODUCT</code>.
     *
     * @return productIdentity
     **/
    @Schema(description = "An array of the product identifier/value pairs for the product associated " +
            "with the item. This is returned if the seller has associated the eBay Product Identifier (ePID) " +
            "with the item and the request has <b> fieldgroups</b> set to <code>PRODUCT</code>. " +
            "<br><br>The following table shows what is returned, based on the item information provided by " +
            "the seller, when the <b> fieldgroups</b> set to <code>PRODUCT</code>.        " +
            "<br><br><div style=\"overflow-x:auto;\"> <table border=1> <tr> <th> ePID Provided </th>  " +
            "<th> Product&nbsp;ID(s) Provided</th> <th> Response</th> </tr> <tr> <td> No </td>  " +
            "<td> No </td> <td> The <b> AdditionalProductIdentity</b> container is <i> not</i> returned.</td></tr>   " +
            "<tr> <td> No </td>  <td> Yes </td>  <td> The <b> AdditionalProductIdentity</b> container is <i> not</i> " +
            "returned but the product identifiers specified by the seller are returned in the " +
            "<b> localizedAspects</b> container. </td>  </tr>   <tr> <td> Yes </td>  <td> No </td> <td>  " +
            "The <b> AdditionalProductIdentity</b> container is returned listing the product identifiers " +
            "of the product.</td></tr>   <tr> <td> Yes </td>  <td> Yes </td> <td> The " +
            "<b> AdditionalProductIdentity</b> container is returned listing all the product identifiers " +
            "of the product and the product identifiers specified by the seller are returned in the " +
            "<b> localizedAspects</b> container.</td> </tr>   </table> </div>")
    public List<ProductIdentity> getProductIdentity() {
        return productIdentity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdditionalProductIdentity additionalProductIdentity = (AdditionalProductIdentity) o;
        return Objects.equals(this.productIdentity, additionalProductIdentity.productIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productIdentity);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AdditionalProductIdentity {\n");
        sb.append("    productIdentity: ");
        sb.append(toIndentedString(productIdentity));
        sb.append("\n");
        sb.append("}");

        return sb.toString();
    }
}
