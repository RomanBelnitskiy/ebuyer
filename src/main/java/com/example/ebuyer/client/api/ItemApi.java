package com.example.ebuyer.client.api;

import com.google.gson.reflect.TypeToken;
import com.example.ebuyer.client.*;
import com.example.ebuyer.client.model.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemApi {
    private ApiClient apiClient;

    public ItemApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ItemApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for checkCompatibility
     *
     * @param contentType             This header indicates the format of the request body provided by the client. Its value should be set to &lt;b&gt;application/json&lt;/b&gt;. &lt;br&gt;&lt;br&gt; For more information, refer to &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#HTTP\&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt;. (required)
     * @param itemId                  The eBay RESTful identifier of an item (such as a part you want to check). This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param body                    (optional)
     * @param X_EBAY_C_MARKETPLACE_ID The ID of the eBay marketplace you want to use. &lt;b&gt; Note: &lt;/b&gt; This value is case sensitive.&lt;br&gt;&lt;br&gt;For example: &lt;br&gt;&amp;nbsp;&amp;nbsp;&lt;code&gt;X-EBAY-C-MARKETPLACE-ID &#x3D; EBAY_US&lt;/code&gt;  &lt;br&gt;&lt;br&gt; For a list of supported sites see, &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;. (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call checkCompatibilityCall(String contentType, String itemId, CompatibilityPayload body, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/item/{item_id}/check_compatibility"
                .replaceAll("\\{" + "item_id" + "\\}", apiClient.escapeString(itemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (X_EBAY_C_MARKETPLACE_ID != null)
            localVarHeaderParams.put("X-EBAY-C-MARKETPLACE-ID", apiClient.parameterToString(X_EBAY_C_MARKETPLACE_ID));
        if (contentType != null)
            localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"api_auth"};
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call checkCompatibilityValidateBeforeCall(String contentType, String itemId, CompatibilityPayload body, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling checkCompatibility(Async)");
        }
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling checkCompatibility(Async)");
        }

        com.squareup.okhttp.Call call = checkCompatibilityCall(contentType, itemId, body, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        return call;


    }

    /**
     * This method checks if a product is compatible with the specified item. You can use this method to check the compatibility of cars, trucks, and motorcycles with a specific part listed on eBay. &lt;br&gt;&lt;br&gt;For example, to check the compatibility of a part, you pass in the item ID of the part as a URI parameter and specify all the attributes used to define a specific car in the &lt;b&gt; compatibilityProperties&lt;/b&gt; container. If the call is successful, the response will be &lt;b&gt; COMPATIBLE&lt;/b&gt;, &lt;b&gt; NOT_COMPATIBLE&lt;/b&gt;, or &lt;b&gt; UNDETERMINED&lt;/b&gt;. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#response.compatibilityStatus\&quot;&gt;compatibilityStatus&lt;/a&gt; for details.   &lt;br&gt;&lt;br&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt; Note: &lt;/b&gt; The only products supported are cars, trucks, and motorcycles. &lt;/span&gt;&lt;p&gt;  To find the attributes and values for a specific marketplace, you can use the compatibility methods in the &lt;a href&#x3D;\&quot;/api-docs/commerce/taxonomy/resources/methods\&quot;&gt;Taxonomy API&lt;/a&gt;. You can use this data to create menus to help buyers specify the product, such as their car.&lt;/p&gt; &lt;p&gt; For more details and a list of the required attributes for the US marketplace that describe motor vehicles, see &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Check\&quot;&gt;Check compatibility&lt;/a&gt; in the Buy Integration Guide&lt;/a&gt;.&lt;/p&gt;   &lt;p&gt;For an example, see the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#h2-samples\&quot;&gt;Samples&lt;/a&gt; section. &lt;/p&gt;&lt;p&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt; Note: &lt;/b&gt; This method is supported in Sandbox, but only when using the specific Item ID and compatibility name-value pairs called out in &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#s0-1-22-6-7-7-6-SandboxSample-1\&quot;&gt;Sample 2&lt;/a&gt;.&lt;/span&gt;&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt;
     *
     * @param contentType             This header indicates the format of the request body provided by the client. Its value should be set to &lt;b&gt;application/json&lt;/b&gt;. &lt;br&gt;&lt;br&gt; For more information, refer to &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#HTTP\&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt;. (required)
     * @param itemId                  The eBay RESTful identifier of an item (such as a part you want to check). This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param body                    (optional)
     * @param X_EBAY_C_MARKETPLACE_ID The ID of the eBay marketplace you want to use. &lt;b&gt; Note: &lt;/b&gt; This value is case sensitive.&lt;br&gt;&lt;br&gt;For example: &lt;br&gt;&amp;nbsp;&amp;nbsp;&lt;code&gt;X-EBAY-C-MARKETPLACE-ID &#x3D; EBAY_US&lt;/code&gt;  &lt;br&gt;&lt;br&gt; For a list of supported sites see, &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;. (optional)
     * @return CompatibilityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CompatibilityResponse checkCompatibility(String contentType, String itemId, CompatibilityPayload body, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        ApiResponse<CompatibilityResponse> resp = checkCompatibilityWithHttpInfo(contentType, itemId, body, X_EBAY_C_MARKETPLACE_ID);
        return resp.getData();
    }

    /**
     * This method checks if a product is compatible with the specified item. You can use this method to check the compatibility of cars, trucks, and motorcycles with a specific part listed on eBay. &lt;br&gt;&lt;br&gt;For example, to check the compatibility of a part, you pass in the item ID of the part as a URI parameter and specify all the attributes used to define a specific car in the &lt;b&gt; compatibilityProperties&lt;/b&gt; container. If the call is successful, the response will be &lt;b&gt; COMPATIBLE&lt;/b&gt;, &lt;b&gt; NOT_COMPATIBLE&lt;/b&gt;, or &lt;b&gt; UNDETERMINED&lt;/b&gt;. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#response.compatibilityStatus\&quot;&gt;compatibilityStatus&lt;/a&gt; for details.   &lt;br&gt;&lt;br&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt; Note: &lt;/b&gt; The only products supported are cars, trucks, and motorcycles. &lt;/span&gt;&lt;p&gt;  To find the attributes and values for a specific marketplace, you can use the compatibility methods in the &lt;a href&#x3D;\&quot;/api-docs/commerce/taxonomy/resources/methods\&quot;&gt;Taxonomy API&lt;/a&gt;. You can use this data to create menus to help buyers specify the product, such as their car.&lt;/p&gt; &lt;p&gt; For more details and a list of the required attributes for the US marketplace that describe motor vehicles, see &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Check\&quot;&gt;Check compatibility&lt;/a&gt; in the Buy Integration Guide&lt;/a&gt;.&lt;/p&gt;   &lt;p&gt;For an example, see the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#h2-samples\&quot;&gt;Samples&lt;/a&gt; section. &lt;/p&gt;&lt;p&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt; Note: &lt;/b&gt; This method is supported in Sandbox, but only when using the specific Item ID and compatibility name-value pairs called out in &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#s0-1-22-6-7-7-6-SandboxSample-1\&quot;&gt;Sample 2&lt;/a&gt;.&lt;/span&gt;&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt;
     *
     * @param contentType             This header indicates the format of the request body provided by the client. Its value should be set to &lt;b&gt;application/json&lt;/b&gt;. &lt;br&gt;&lt;br&gt; For more information, refer to &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#HTTP\&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt;. (required)
     * @param itemId                  The eBay RESTful identifier of an item (such as a part you want to check). This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param body                    (optional)
     * @param X_EBAY_C_MARKETPLACE_ID The ID of the eBay marketplace you want to use. &lt;b&gt; Note: &lt;/b&gt; This value is case sensitive.&lt;br&gt;&lt;br&gt;For example: &lt;br&gt;&amp;nbsp;&amp;nbsp;&lt;code&gt;X-EBAY-C-MARKETPLACE-ID &#x3D; EBAY_US&lt;/code&gt;  &lt;br&gt;&lt;br&gt; For a list of supported sites see, &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;. (optional)
     * @return ApiResponse&lt;CompatibilityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CompatibilityResponse> checkCompatibilityWithHttpInfo(String contentType, String itemId, CompatibilityPayload body, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        com.squareup.okhttp.Call call = checkCompatibilityValidateBeforeCall(contentType, itemId, body, X_EBAY_C_MARKETPLACE_ID, null, null);
        Type localVarReturnType = new TypeToken<CompatibilityResponse>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * This method checks if a product is compatible with the specified item. You can use this method to check the compatibility of cars, trucks, and motorcycles with a specific part listed on eBay. &lt;br&gt;&lt;br&gt;For example, to check the compatibility of a part, you pass in the item ID of the part as a URI parameter and specify all the attributes used to define a specific car in the &lt;b&gt; compatibilityProperties&lt;/b&gt; container. If the call is successful, the response will be &lt;b&gt; COMPATIBLE&lt;/b&gt;, &lt;b&gt; NOT_COMPATIBLE&lt;/b&gt;, or &lt;b&gt; UNDETERMINED&lt;/b&gt;. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#response.compatibilityStatus\&quot;&gt;compatibilityStatus&lt;/a&gt; for details.   &lt;br&gt;&lt;br&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt; Note: &lt;/b&gt; The only products supported are cars, trucks, and motorcycles. &lt;/span&gt;&lt;p&gt;  To find the attributes and values for a specific marketplace, you can use the compatibility methods in the &lt;a href&#x3D;\&quot;/api-docs/commerce/taxonomy/resources/methods\&quot;&gt;Taxonomy API&lt;/a&gt;. You can use this data to create menus to help buyers specify the product, such as their car.&lt;/p&gt; &lt;p&gt; For more details and a list of the required attributes for the US marketplace that describe motor vehicles, see &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Check\&quot;&gt;Check compatibility&lt;/a&gt; in the Buy Integration Guide&lt;/a&gt;.&lt;/p&gt;   &lt;p&gt;For an example, see the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#h2-samples\&quot;&gt;Samples&lt;/a&gt; section. &lt;/p&gt;&lt;p&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt; Note: &lt;/b&gt; This method is supported in Sandbox, but only when using the specific Item ID and compatibility name-value pairs called out in &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/checkCompatibility#s0-1-22-6-7-7-6-SandboxSample-1\&quot;&gt;Sample 2&lt;/a&gt;.&lt;/span&gt;&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt;
     *
     * @param contentType             This header indicates the format of the request body provided by the client. Its value should be set to &lt;b&gt;application/json&lt;/b&gt;. &lt;br&gt;&lt;br&gt; For more information, refer to &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#HTTP\&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt;. (required)
     * @param itemId                  The eBay RESTful identifier of an item (such as a part you want to check). This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param body                    (optional)
     * @param X_EBAY_C_MARKETPLACE_ID The ID of the eBay marketplace you want to use. &lt;b&gt; Note: &lt;/b&gt; This value is case sensitive.&lt;br&gt;&lt;br&gt;For example: &lt;br&gt;&amp;nbsp;&amp;nbsp;&lt;code&gt;X-EBAY-C-MARKETPLACE-ID &#x3D; EBAY_US&lt;/code&gt;  &lt;br&gt;&lt;br&gt; For a list of supported sites see, &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;. (optional)
     * @param callback                The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call checkCompatibilityAsync(String contentType, String itemId, CompatibilityPayload body, String X_EBAY_C_MARKETPLACE_ID, final ApiCallback<CompatibilityResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = checkCompatibilityValidateBeforeCall(contentType, itemId, body, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CompatibilityResponse>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for getItem
     *
     * @param itemId                  The eBay RESTful identifier of an item. This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param fieldgroups             This parameter lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set. However, &lt;code&gt;COMPACT&lt;/code&gt; &lt;b&gt;must&lt;/b&gt; be used alone. Otherwise, an error will occur.&lt;/span&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; product fields to the response, which describe the product associated with the item. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt; COMPACT&lt;/b&gt; - This returns only the following fields, which let you quickly check if the availability or price of the item has changed, if the item has been revised by the seller, or if an item&#x27;s top-rated plus status has changed for items you have stored.&lt;ul&gt;&lt;li&gt;&lt;b&gt;itemId&lt;/b&gt; - The identifier of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;bidCount&lt;/b&gt; - This integer value indicates the total number of bids that have been placed against an auction item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;currentBidPrice&lt;/b&gt; - This container shows the current highest bid for an auction item. This container will only be returned for auction items.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;eligibleForInlineCheckout&lt;/b&gt; - This parameter returns items based on whether or not the items can be purchased using the Buy &lt;a href&#x3D;\&quot;/api-docs/buy/order/resources/methods\&quot;&gt;Order API&lt;/a&gt;. &lt;ul&gt; &lt;li&gt;If the value of this field is &lt;code&gt;true&lt;/code&gt;, this indicates that the item can be purchased using the &lt;b&gt; Order API&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;If the value of this field is &lt;code&gt;false&lt;/code&gt;, this indicates that the item cannot be purchased using the &lt;b&gt; Order API&lt;/b&gt; and must be purchased on the eBay site.&lt;/li&gt; &lt;/ul&gt; &lt;li&gt;&lt;b&gt; estimatedAvailabilities&lt;/b&gt; -  Returns the item availability information, which is based on the item&#x27;s quantity. &lt;b&gt; Note:&lt;/b&gt; Changes in quantity are not tracked by &lt;b&gt;sellerItemRevision&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;&lt;b&gt;gtin&lt;/b&gt; - The unique Global Trade Item Number of an item as defined by &lt;a href&#x3D;\&quot;https://www.gtin.info \&quot; target&#x3D;\&quot;_blank\&quot;&gt;https://www.gtin.info&lt;/a&gt;.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemAffiliateWebURL&lt;/b&gt; - The URL of the View Item page of the item, which includes the affiliate tracking ID. This field is only returned if the eBay partner enables affiliate tracking for the item by including the &lt;code&gt;X-EBAY-C-ENDUSERCTX&lt;/code&gt; request header in the method.&lt;/li&gt;&lt;li&gt;&lt;b&gt;itemCreationDate&lt;/b&gt; - This is a timestamp that indicates the date and time an item listing was created.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemEndDate&lt;/b&gt; - This is the scheduled end time of the listing.&lt;/li&gt; &lt;li&gt;&lt;b&gt;ItemWebURL&lt;/b&gt; - The URL of the View Item page of the item. This enables you to include a \&quot;Report Item on eBay\&quot; link that takes the buyer to the View Item page on eBay. From there they can report any issues regarding this item to eBay.&lt;/li&gt; &lt;li&gt;&lt;b&gt;legacyItemId&lt;/b&gt; - The unique identifier of the eBay listing that contains the item. This is the traditional/legacy ID that is often seen in the URL of the listing View Item page.&lt;/li&gt; &lt;li&gt;&lt;b&gt;minimumPriceToBid&lt;/b&gt; - This container shows the minimum bid amount that would be accepted as a qualifying bid in an auction listing. This container will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt;price&lt;/b&gt; - This is tracked by the revision ID but is returned here to enable you to quickly verify the price of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;priorityListing&lt;/b&gt; - This field is returned as &lt;code&gt;true&lt;/code&gt; if the listing is part of a Promoted Listing campaign. Promoted Listings are available to Above Standard and Top Rated sellers with recent sales activity.&lt;/li&gt; &lt;li&gt;&lt;b&gt;reservePriceMet&lt;/b&gt; - This field indicates whether or not an auction&#x27;s reserve price (if set by the seller) has been met yet. This field will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt; sellerItemRevision&lt;/b&gt; - An identifier generated/incremented when a seller revises the item. The following are the two types of item revisions:   &lt;ul&gt;  &lt;li&gt;&lt;b&gt; Seller changes&lt;/b&gt;, such as changing the title&lt;/li&gt;  &lt;li&gt;  &lt;b&gt; eBay system changes&lt;/b&gt;, such as changing the quantity when an item is purchased.&lt;/li&gt;  &lt;/ul&gt; This ID is changed &lt;em&gt;only&lt;/em&gt; when the seller makes a change to the item. This means you cannot use this value to determine if the quantity has changed. To check if the quantity has changed, use &lt;b&gt; estimatedAvailabilities.&lt;/b&gt;&lt;/li&gt; &lt;li&gt;&lt;b&gt;shippingOptions&lt;/b&gt; - A container for the cost, carrier, and other details of shipping options.&lt;/li&gt; &lt;li&gt;&lt;b&gt;taxes&lt;/b&gt; - A container for the tax information for the item, such as the tax jurisdiction, the tax percentage, and the tax type.&lt;/li&gt; &lt;li&gt;&lt;b&gt; topRatedBuyingExperience&lt;/b&gt; - A boolean value indicating if this item is a top-rated plus item. A change in the item&#x27;s top rated plus standing is not tracked by the revision ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.topRatedBuyingExperience\&quot;&gt;topRatedBuyingExperience&lt;/a&gt; for more information.&lt;/li&gt; &lt;li&gt;&lt;b&gt;uniqueBidderCount&lt;/b&gt; - This integer value indicates the number of different eBay users who have placed one or more bids on an auction item. This field is only applicable to auction items.&lt;/li&gt;&lt;/ul&gt;    &lt;b&gt; For Example&lt;/b&gt; &lt;br&gt; &lt;br&gt;To check if a stored item&#x27;s information is current, do following.  &lt;ol&gt;    &lt;li&gt;Pass in the item ID and set &lt;b&gt; fieldgroups&lt;/b&gt; to COMPACT. &lt;br&gt; &lt;br&gt;&lt;code&gt;item/v1|4**********8|0?fieldgroups&#x3D;COMPACT&lt;/code&gt; &lt;/li&gt;     &lt;li&gt;Do one of the following:    &lt;ul&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is returned and you &lt;em&gt;haven&#x27;t&lt;/em&gt; stored a revision number for this item, record the number and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;   &lt;li&gt;If the revision number is different from the value you have stored, update the value and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is &lt;em&gt;not&lt;/em&gt; returned or has not changed, where needed, update the item information with the information returned in the response.&lt;/li&gt;&lt;/ul&gt;&lt;/li&gt;&lt;/ol&gt;&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. &lt;/li&gt; &lt;/ul&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getItemCall(String itemId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/item/{item_id}"
                .replaceAll("\\{" + "item_id" + "\\}", apiClient.escapeString(itemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fieldgroups != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("fieldgroups", fieldgroups));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (X_EBAY_C_ENDUSERCTX != null)
            localVarHeaderParams.put("X-EBAY-C-ENDUSERCTX", apiClient.parameterToString(X_EBAY_C_ENDUSERCTX));
        if (X_EBAY_C_MARKETPLACE_ID != null)
            localVarHeaderParams.put("X-EBAY-C-MARKETPLACE-ID", apiClient.parameterToString(X_EBAY_C_MARKETPLACE_ID));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"api_auth"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getItemValidateBeforeCall(String itemId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling getItem(Async)");
        }

        com.squareup.okhttp.Call call = getItemCall(itemId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        return call;


    }

    /**
     * &lt;p&gt;This method retrieves the details of a specific item, such as description, price, category, all item aspects, condition, return policies, seller feedback and score, shipping options, shipping costs, estimated delivery, and other information the buyer needs to make a purchasing decision.&lt;/p&gt;&lt;p&gt;The Buy APIs are designed to let you create an eBay shopping experience in your app or website. This means you will need to know when something, such as the availability, quantity, etc., has changed in any eBay item you are offering. You can do this easily by setting the &lt;b&gt;fieldgroups&lt;/b&gt; URI parameter. This parameter lets you control what is returned in the response.&lt;/p&gt;&lt;p&gt;Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;COMPACT&lt;/code&gt; reduces the response to only those fields that you need in order to check if any item detail has changed. Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;PRODUCT&lt;/code&gt; adds additional fields to the default response that return information about the product of the item. Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. The &lt;code&gt;COMPACT&lt;/code&gt; fieldgroup must be used alone. &lt;code&gt;PRODUCT&lt;/code&gt; and &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; can be used independently or at the same time. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt;&lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param itemId                  The eBay RESTful identifier of an item. This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param fieldgroups             This parameter lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set. However, &lt;code&gt;COMPACT&lt;/code&gt; &lt;b&gt;must&lt;/b&gt; be used alone. Otherwise, an error will occur.&lt;/span&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; product fields to the response, which describe the product associated with the item. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt; COMPACT&lt;/b&gt; - This returns only the following fields, which let you quickly check if the availability or price of the item has changed, if the item has been revised by the seller, or if an item&#x27;s top-rated plus status has changed for items you have stored.&lt;ul&gt;&lt;li&gt;&lt;b&gt;itemId&lt;/b&gt; - The identifier of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;bidCount&lt;/b&gt; - This integer value indicates the total number of bids that have been placed against an auction item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;currentBidPrice&lt;/b&gt; - This container shows the current highest bid for an auction item. This container will only be returned for auction items.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;eligibleForInlineCheckout&lt;/b&gt; - This parameter returns items based on whether or not the items can be purchased using the Buy &lt;a href&#x3D;\&quot;/api-docs/buy/order/resources/methods\&quot;&gt;Order API&lt;/a&gt;. &lt;ul&gt; &lt;li&gt;If the value of this field is &lt;code&gt;true&lt;/code&gt;, this indicates that the item can be purchased using the &lt;b&gt; Order API&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;If the value of this field is &lt;code&gt;false&lt;/code&gt;, this indicates that the item cannot be purchased using the &lt;b&gt; Order API&lt;/b&gt; and must be purchased on the eBay site.&lt;/li&gt; &lt;/ul&gt; &lt;li&gt;&lt;b&gt; estimatedAvailabilities&lt;/b&gt; -  Returns the item availability information, which is based on the item&#x27;s quantity. &lt;b&gt; Note:&lt;/b&gt; Changes in quantity are not tracked by &lt;b&gt;sellerItemRevision&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;&lt;b&gt;gtin&lt;/b&gt; - The unique Global Trade Item Number of an item as defined by &lt;a href&#x3D;\&quot;https://www.gtin.info \&quot; target&#x3D;\&quot;_blank\&quot;&gt;https://www.gtin.info&lt;/a&gt;.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemAffiliateWebURL&lt;/b&gt; - The URL of the View Item page of the item, which includes the affiliate tracking ID. This field is only returned if the eBay partner enables affiliate tracking for the item by including the &lt;code&gt;X-EBAY-C-ENDUSERCTX&lt;/code&gt; request header in the method.&lt;/li&gt;&lt;li&gt;&lt;b&gt;itemCreationDate&lt;/b&gt; - This is a timestamp that indicates the date and time an item listing was created.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemEndDate&lt;/b&gt; - This is the scheduled end time of the listing.&lt;/li&gt; &lt;li&gt;&lt;b&gt;ItemWebURL&lt;/b&gt; - The URL of the View Item page of the item. This enables you to include a \&quot;Report Item on eBay\&quot; link that takes the buyer to the View Item page on eBay. From there they can report any issues regarding this item to eBay.&lt;/li&gt; &lt;li&gt;&lt;b&gt;legacyItemId&lt;/b&gt; - The unique identifier of the eBay listing that contains the item. This is the traditional/legacy ID that is often seen in the URL of the listing View Item page.&lt;/li&gt; &lt;li&gt;&lt;b&gt;minimumPriceToBid&lt;/b&gt; - This container shows the minimum bid amount that would be accepted as a qualifying bid in an auction listing. This container will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt;price&lt;/b&gt; - This is tracked by the revision ID but is returned here to enable you to quickly verify the price of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;priorityListing&lt;/b&gt; - This field is returned as &lt;code&gt;true&lt;/code&gt; if the listing is part of a Promoted Listing campaign. Promoted Listings are available to Above Standard and Top Rated sellers with recent sales activity.&lt;/li&gt; &lt;li&gt;&lt;b&gt;reservePriceMet&lt;/b&gt; - This field indicates whether or not an auction&#x27;s reserve price (if set by the seller) has been met yet. This field will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt; sellerItemRevision&lt;/b&gt; - An identifier generated/incremented when a seller revises the item. The following are the two types of item revisions:   &lt;ul&gt;  &lt;li&gt;&lt;b&gt; Seller changes&lt;/b&gt;, such as changing the title&lt;/li&gt;  &lt;li&gt;  &lt;b&gt; eBay system changes&lt;/b&gt;, such as changing the quantity when an item is purchased.&lt;/li&gt;  &lt;/ul&gt; This ID is changed &lt;em&gt;only&lt;/em&gt; when the seller makes a change to the item. This means you cannot use this value to determine if the quantity has changed. To check if the quantity has changed, use &lt;b&gt; estimatedAvailabilities.&lt;/b&gt;&lt;/li&gt; &lt;li&gt;&lt;b&gt;shippingOptions&lt;/b&gt; - A container for the cost, carrier, and other details of shipping options.&lt;/li&gt; &lt;li&gt;&lt;b&gt;taxes&lt;/b&gt; - A container for the tax information for the item, such as the tax jurisdiction, the tax percentage, and the tax type.&lt;/li&gt; &lt;li&gt;&lt;b&gt; topRatedBuyingExperience&lt;/b&gt; - A boolean value indicating if this item is a top-rated plus item. A change in the item&#x27;s top rated plus standing is not tracked by the revision ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.topRatedBuyingExperience\&quot;&gt;topRatedBuyingExperience&lt;/a&gt; for more information.&lt;/li&gt; &lt;li&gt;&lt;b&gt;uniqueBidderCount&lt;/b&gt; - This integer value indicates the number of different eBay users who have placed one or more bids on an auction item. This field is only applicable to auction items.&lt;/li&gt;&lt;/ul&gt;    &lt;b&gt; For Example&lt;/b&gt; &lt;br&gt; &lt;br&gt;To check if a stored item&#x27;s information is current, do following.  &lt;ol&gt;    &lt;li&gt;Pass in the item ID and set &lt;b&gt; fieldgroups&lt;/b&gt; to COMPACT. &lt;br&gt; &lt;br&gt;&lt;code&gt;item/v1|4**********8|0?fieldgroups&#x3D;COMPACT&lt;/code&gt; &lt;/li&gt;     &lt;li&gt;Do one of the following:    &lt;ul&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is returned and you &lt;em&gt;haven&#x27;t&lt;/em&gt; stored a revision number for this item, record the number and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;   &lt;li&gt;If the revision number is different from the value you have stored, update the value and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is &lt;em&gt;not&lt;/em&gt; returned or has not changed, where needed, update the item information with the information returned in the response.&lt;/li&gt;&lt;/ul&gt;&lt;/li&gt;&lt;/ol&gt;&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. &lt;/li&gt; &lt;/ul&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return Item
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Item getItem(String itemId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        ApiResponse<Item> resp = getItemWithHttpInfo(itemId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID);
        return resp.getData();
    }

    /**
     * &lt;p&gt;This method retrieves the details of a specific item, such as description, price, category, all item aspects, condition, return policies, seller feedback and score, shipping options, shipping costs, estimated delivery, and other information the buyer needs to make a purchasing decision.&lt;/p&gt;&lt;p&gt;The Buy APIs are designed to let you create an eBay shopping experience in your app or website. This means you will need to know when something, such as the availability, quantity, etc., has changed in any eBay item you are offering. You can do this easily by setting the &lt;b&gt;fieldgroups&lt;/b&gt; URI parameter. This parameter lets you control what is returned in the response.&lt;/p&gt;&lt;p&gt;Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;COMPACT&lt;/code&gt; reduces the response to only those fields that you need in order to check if any item detail has changed. Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;PRODUCT&lt;/code&gt; adds additional fields to the default response that return information about the product of the item. Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. The &lt;code&gt;COMPACT&lt;/code&gt; fieldgroup must be used alone. &lt;code&gt;PRODUCT&lt;/code&gt; and &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; can be used independently or at the same time. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt;&lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param itemId                  The eBay RESTful identifier of an item. This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param fieldgroups             This parameter lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set. However, &lt;code&gt;COMPACT&lt;/code&gt; &lt;b&gt;must&lt;/b&gt; be used alone. Otherwise, an error will occur.&lt;/span&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; product fields to the response, which describe the product associated with the item. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt; COMPACT&lt;/b&gt; - This returns only the following fields, which let you quickly check if the availability or price of the item has changed, if the item has been revised by the seller, or if an item&#x27;s top-rated plus status has changed for items you have stored.&lt;ul&gt;&lt;li&gt;&lt;b&gt;itemId&lt;/b&gt; - The identifier of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;bidCount&lt;/b&gt; - This integer value indicates the total number of bids that have been placed against an auction item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;currentBidPrice&lt;/b&gt; - This container shows the current highest bid for an auction item. This container will only be returned for auction items.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;eligibleForInlineCheckout&lt;/b&gt; - This parameter returns items based on whether or not the items can be purchased using the Buy &lt;a href&#x3D;\&quot;/api-docs/buy/order/resources/methods\&quot;&gt;Order API&lt;/a&gt;. &lt;ul&gt; &lt;li&gt;If the value of this field is &lt;code&gt;true&lt;/code&gt;, this indicates that the item can be purchased using the &lt;b&gt; Order API&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;If the value of this field is &lt;code&gt;false&lt;/code&gt;, this indicates that the item cannot be purchased using the &lt;b&gt; Order API&lt;/b&gt; and must be purchased on the eBay site.&lt;/li&gt; &lt;/ul&gt; &lt;li&gt;&lt;b&gt; estimatedAvailabilities&lt;/b&gt; -  Returns the item availability information, which is based on the item&#x27;s quantity. &lt;b&gt; Note:&lt;/b&gt; Changes in quantity are not tracked by &lt;b&gt;sellerItemRevision&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;&lt;b&gt;gtin&lt;/b&gt; - The unique Global Trade Item Number of an item as defined by &lt;a href&#x3D;\&quot;https://www.gtin.info \&quot; target&#x3D;\&quot;_blank\&quot;&gt;https://www.gtin.info&lt;/a&gt;.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemAffiliateWebURL&lt;/b&gt; - The URL of the View Item page of the item, which includes the affiliate tracking ID. This field is only returned if the eBay partner enables affiliate tracking for the item by including the &lt;code&gt;X-EBAY-C-ENDUSERCTX&lt;/code&gt; request header in the method.&lt;/li&gt;&lt;li&gt;&lt;b&gt;itemCreationDate&lt;/b&gt; - This is a timestamp that indicates the date and time an item listing was created.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemEndDate&lt;/b&gt; - This is the scheduled end time of the listing.&lt;/li&gt; &lt;li&gt;&lt;b&gt;ItemWebURL&lt;/b&gt; - The URL of the View Item page of the item. This enables you to include a \&quot;Report Item on eBay\&quot; link that takes the buyer to the View Item page on eBay. From there they can report any issues regarding this item to eBay.&lt;/li&gt; &lt;li&gt;&lt;b&gt;legacyItemId&lt;/b&gt; - The unique identifier of the eBay listing that contains the item. This is the traditional/legacy ID that is often seen in the URL of the listing View Item page.&lt;/li&gt; &lt;li&gt;&lt;b&gt;minimumPriceToBid&lt;/b&gt; - This container shows the minimum bid amount that would be accepted as a qualifying bid in an auction listing. This container will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt;price&lt;/b&gt; - This is tracked by the revision ID but is returned here to enable you to quickly verify the price of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;priorityListing&lt;/b&gt; - This field is returned as &lt;code&gt;true&lt;/code&gt; if the listing is part of a Promoted Listing campaign. Promoted Listings are available to Above Standard and Top Rated sellers with recent sales activity.&lt;/li&gt; &lt;li&gt;&lt;b&gt;reservePriceMet&lt;/b&gt; - This field indicates whether or not an auction&#x27;s reserve price (if set by the seller) has been met yet. This field will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt; sellerItemRevision&lt;/b&gt; - An identifier generated/incremented when a seller revises the item. The following are the two types of item revisions:   &lt;ul&gt;  &lt;li&gt;&lt;b&gt; Seller changes&lt;/b&gt;, such as changing the title&lt;/li&gt;  &lt;li&gt;  &lt;b&gt; eBay system changes&lt;/b&gt;, such as changing the quantity when an item is purchased.&lt;/li&gt;  &lt;/ul&gt; This ID is changed &lt;em&gt;only&lt;/em&gt; when the seller makes a change to the item. This means you cannot use this value to determine if the quantity has changed. To check if the quantity has changed, use &lt;b&gt; estimatedAvailabilities.&lt;/b&gt;&lt;/li&gt; &lt;li&gt;&lt;b&gt;shippingOptions&lt;/b&gt; - A container for the cost, carrier, and other details of shipping options.&lt;/li&gt; &lt;li&gt;&lt;b&gt;taxes&lt;/b&gt; - A container for the tax information for the item, such as the tax jurisdiction, the tax percentage, and the tax type.&lt;/li&gt; &lt;li&gt;&lt;b&gt; topRatedBuyingExperience&lt;/b&gt; - A boolean value indicating if this item is a top-rated plus item. A change in the item&#x27;s top rated plus standing is not tracked by the revision ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.topRatedBuyingExperience\&quot;&gt;topRatedBuyingExperience&lt;/a&gt; for more information.&lt;/li&gt; &lt;li&gt;&lt;b&gt;uniqueBidderCount&lt;/b&gt; - This integer value indicates the number of different eBay users who have placed one or more bids on an auction item. This field is only applicable to auction items.&lt;/li&gt;&lt;/ul&gt;    &lt;b&gt; For Example&lt;/b&gt; &lt;br&gt; &lt;br&gt;To check if a stored item&#x27;s information is current, do following.  &lt;ol&gt;    &lt;li&gt;Pass in the item ID and set &lt;b&gt; fieldgroups&lt;/b&gt; to COMPACT. &lt;br&gt; &lt;br&gt;&lt;code&gt;item/v1|4**********8|0?fieldgroups&#x3D;COMPACT&lt;/code&gt; &lt;/li&gt;     &lt;li&gt;Do one of the following:    &lt;ul&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is returned and you &lt;em&gt;haven&#x27;t&lt;/em&gt; stored a revision number for this item, record the number and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;   &lt;li&gt;If the revision number is different from the value you have stored, update the value and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is &lt;em&gt;not&lt;/em&gt; returned or has not changed, where needed, update the item information with the information returned in the response.&lt;/li&gt;&lt;/ul&gt;&lt;/li&gt;&lt;/ol&gt;&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. &lt;/li&gt; &lt;/ul&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return ApiResponse&lt;Item&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Item> getItemWithHttpInfo(String itemId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        com.squareup.okhttp.Call call = getItemValidateBeforeCall(itemId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, null, null);
        Type localVarReturnType = new TypeToken<Item>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * &lt;p&gt;This method retrieves the details of a specific item, such as description, price, category, all item aspects, condition, return policies, seller feedback and score, shipping options, shipping costs, estimated delivery, and other information the buyer needs to make a purchasing decision.&lt;/p&gt;&lt;p&gt;The Buy APIs are designed to let you create an eBay shopping experience in your app or website. This means you will need to know when something, such as the availability, quantity, etc., has changed in any eBay item you are offering. You can do this easily by setting the &lt;b&gt;fieldgroups&lt;/b&gt; URI parameter. This parameter lets you control what is returned in the response.&lt;/p&gt;&lt;p&gt;Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;COMPACT&lt;/code&gt; reduces the response to only those fields that you need in order to check if any item detail has changed. Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;PRODUCT&lt;/code&gt; adds additional fields to the default response that return information about the product of the item. Setting &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. The &lt;code&gt;COMPACT&lt;/code&gt; fieldgroup must be used alone. &lt;code&gt;PRODUCT&lt;/code&gt; and &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; can be used independently or at the same time. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt;&lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param itemId                  The eBay RESTful identifier of an item. This ID is returned by the &lt;b&gt; Browse&lt;/b&gt; and &lt;b&gt; Feed&lt;/b&gt; API methods.  &lt;br&gt;&lt;br&gt; &lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt; &lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;For more information about item ID for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (required)
     * @param fieldgroups             This parameter lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set. However, &lt;code&gt;COMPACT&lt;/code&gt; &lt;b&gt;must&lt;/b&gt; be used alone. Otherwise, an error will occur.&lt;/span&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; product fields to the response, which describe the product associated with the item. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt; COMPACT&lt;/b&gt; - This returns only the following fields, which let you quickly check if the availability or price of the item has changed, if the item has been revised by the seller, or if an item&#x27;s top-rated plus status has changed for items you have stored.&lt;ul&gt;&lt;li&gt;&lt;b&gt;itemId&lt;/b&gt; - The identifier of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;bidCount&lt;/b&gt; - This integer value indicates the total number of bids that have been placed against an auction item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;currentBidPrice&lt;/b&gt; - This container shows the current highest bid for an auction item. This container will only be returned for auction items.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;eligibleForInlineCheckout&lt;/b&gt; - This parameter returns items based on whether or not the items can be purchased using the Buy &lt;a href&#x3D;\&quot;/api-docs/buy/order/resources/methods\&quot;&gt;Order API&lt;/a&gt;. &lt;ul&gt; &lt;li&gt;If the value of this field is &lt;code&gt;true&lt;/code&gt;, this indicates that the item can be purchased using the &lt;b&gt; Order API&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;If the value of this field is &lt;code&gt;false&lt;/code&gt;, this indicates that the item cannot be purchased using the &lt;b&gt; Order API&lt;/b&gt; and must be purchased on the eBay site.&lt;/li&gt; &lt;/ul&gt; &lt;li&gt;&lt;b&gt; estimatedAvailabilities&lt;/b&gt; -  Returns the item availability information, which is based on the item&#x27;s quantity. &lt;b&gt; Note:&lt;/b&gt; Changes in quantity are not tracked by &lt;b&gt;sellerItemRevision&lt;/b&gt;.&lt;/li&gt;&lt;li&gt;&lt;b&gt;gtin&lt;/b&gt; - The unique Global Trade Item Number of an item as defined by &lt;a href&#x3D;\&quot;https://www.gtin.info \&quot; target&#x3D;\&quot;_blank\&quot;&gt;https://www.gtin.info&lt;/a&gt;.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemAffiliateWebURL&lt;/b&gt; - The URL of the View Item page of the item, which includes the affiliate tracking ID. This field is only returned if the eBay partner enables affiliate tracking for the item by including the &lt;code&gt;X-EBAY-C-ENDUSERCTX&lt;/code&gt; request header in the method.&lt;/li&gt;&lt;li&gt;&lt;b&gt;itemCreationDate&lt;/b&gt; - This is a timestamp that indicates the date and time an item listing was created.&lt;/li&gt; &lt;li&gt;&lt;b&gt;itemEndDate&lt;/b&gt; - This is the scheduled end time of the listing.&lt;/li&gt; &lt;li&gt;&lt;b&gt;ItemWebURL&lt;/b&gt; - The URL of the View Item page of the item. This enables you to include a \&quot;Report Item on eBay\&quot; link that takes the buyer to the View Item page on eBay. From there they can report any issues regarding this item to eBay.&lt;/li&gt; &lt;li&gt;&lt;b&gt;legacyItemId&lt;/b&gt; - The unique identifier of the eBay listing that contains the item. This is the traditional/legacy ID that is often seen in the URL of the listing View Item page.&lt;/li&gt; &lt;li&gt;&lt;b&gt;minimumPriceToBid&lt;/b&gt; - This container shows the minimum bid amount that would be accepted as a qualifying bid in an auction listing. This container will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt;price&lt;/b&gt; - This is tracked by the revision ID but is returned here to enable you to quickly verify the price of the item.&lt;/li&gt; &lt;li&gt;&lt;b&gt;priorityListing&lt;/b&gt; - This field is returned as &lt;code&gt;true&lt;/code&gt; if the listing is part of a Promoted Listing campaign. Promoted Listings are available to Above Standard and Top Rated sellers with recent sales activity.&lt;/li&gt; &lt;li&gt;&lt;b&gt;reservePriceMet&lt;/b&gt; - This field indicates whether or not an auction&#x27;s reserve price (if set by the seller) has been met yet. This field will only be returned for auction items.&lt;/li&gt; &lt;li&gt;&lt;b&gt; sellerItemRevision&lt;/b&gt; - An identifier generated/incremented when a seller revises the item. The following are the two types of item revisions:   &lt;ul&gt;  &lt;li&gt;&lt;b&gt; Seller changes&lt;/b&gt;, such as changing the title&lt;/li&gt;  &lt;li&gt;  &lt;b&gt; eBay system changes&lt;/b&gt;, such as changing the quantity when an item is purchased.&lt;/li&gt;  &lt;/ul&gt; This ID is changed &lt;em&gt;only&lt;/em&gt; when the seller makes a change to the item. This means you cannot use this value to determine if the quantity has changed. To check if the quantity has changed, use &lt;b&gt; estimatedAvailabilities.&lt;/b&gt;&lt;/li&gt; &lt;li&gt;&lt;b&gt;shippingOptions&lt;/b&gt; - A container for the cost, carrier, and other details of shipping options.&lt;/li&gt; &lt;li&gt;&lt;b&gt;taxes&lt;/b&gt; - A container for the tax information for the item, such as the tax jurisdiction, the tax percentage, and the tax type.&lt;/li&gt; &lt;li&gt;&lt;b&gt; topRatedBuyingExperience&lt;/b&gt; - A boolean value indicating if this item is a top-rated plus item. A change in the item&#x27;s top rated plus standing is not tracked by the revision ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.topRatedBuyingExperience\&quot;&gt;topRatedBuyingExperience&lt;/a&gt; for more information.&lt;/li&gt; &lt;li&gt;&lt;b&gt;uniqueBidderCount&lt;/b&gt; - This integer value indicates the number of different eBay users who have placed one or more bids on an auction item. This field is only applicable to auction items.&lt;/li&gt;&lt;/ul&gt;    &lt;b&gt; For Example&lt;/b&gt; &lt;br&gt; &lt;br&gt;To check if a stored item&#x27;s information is current, do following.  &lt;ol&gt;    &lt;li&gt;Pass in the item ID and set &lt;b&gt; fieldgroups&lt;/b&gt; to COMPACT. &lt;br&gt; &lt;br&gt;&lt;code&gt;item/v1|4**********8|0?fieldgroups&#x3D;COMPACT&lt;/code&gt; &lt;/li&gt;     &lt;li&gt;Do one of the following:    &lt;ul&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is returned and you &lt;em&gt;haven&#x27;t&lt;/em&gt; stored a revision number for this item, record the number and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;   &lt;li&gt;If the revision number is different from the value you have stored, update the value and pass in the item ID in the &lt;b&gt; getItem&lt;/b&gt; method to get the latest information.&lt;/li&gt;     &lt;li&gt;If the &lt;b&gt; sellerItemRevision&lt;/b&gt; field is &lt;em&gt;not&lt;/em&gt; returned or has not changed, where needed, update the item information with the information returned in the response.&lt;/li&gt;&lt;/ul&gt;&lt;/li&gt;&lt;/ol&gt;&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. &lt;/li&gt; &lt;/ul&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param callback                The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getItemAsync(String itemId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ApiCallback<Item> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getItemValidateBeforeCall(itemId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Item>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for getItemByLegacyId
     *
     * @param legacyItemId            Specifies either: &lt;ul&gt; &lt;li&gt;The legacy item ID of an item that is &lt;em&gt;not&lt;/em&gt; part of a group. &lt;/li&gt; &lt;li&gt;The legacy item ID of a group, which is the ID of the \&quot;parent\&quot; of the group of items. &lt;br&gt; &lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt; Note: &lt;/b&gt; If you pass in a group ID, you must also use the &lt;b&gt; legacy_variation_id&lt;/b&gt; field and pass in the legacy ID of the specific item variation (child ID).&lt;/span&gt;&lt;/li&gt;&lt;/ul&gt;  Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.  &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; field for a specific item from Finding to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9  &lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item. Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set.&lt;br&gt;&lt;br&gt;&lt;b&gt; Valid Values: &lt;/b&gt;&lt;ul&gt;&lt;li&gt; &lt;b&gt; PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; fields to the response, which describe the item&#x27;s product.  See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field.&lt;/li&gt;&lt;/ul&gt; (optional)
     * @param legacyVariationId       Specifies the legacy item ID of a specific item in an item group, such as the red shirt size L. &lt;br&gt;&lt;br&gt;Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.     &lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_id&lt;/b&gt; (optional)
     * @param legacyVariationSku      Specifics the legacy SKU of the item. SKU are item ids created by the seller. &lt;br&gt;&lt;br&gt;Legacy SKUs are returned by eBay the  &lt;a href&#x3D;\&quot;https://developer.ebay.com/Devzone/shopping/docs/CallRef/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Shopping API&lt;/a&gt;. &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; and &lt;b&gt; SKU&lt;/b&gt; fields to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9&amp;amp;legacy_variation_sku&#x3D;V**********M&lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_sku&lt;/b&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getItemByLegacyIdCall(String legacyItemId, String fieldgroups, String legacyVariationId, String legacyVariationSku, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/item/get_item_by_legacy_id";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fieldgroups != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("fieldgroups", fieldgroups));
        if (legacyItemId != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("legacy_item_id", legacyItemId));
        if (legacyVariationId != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("legacy_variation_id", legacyVariationId));
        if (legacyVariationSku != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("legacy_variation_sku", legacyVariationSku));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (X_EBAY_C_ENDUSERCTX != null)
            localVarHeaderParams.put("X-EBAY-C-ENDUSERCTX", apiClient.parameterToString(X_EBAY_C_ENDUSERCTX));
        if (X_EBAY_C_MARKETPLACE_ID != null)
            localVarHeaderParams.put("X-EBAY-C-MARKETPLACE-ID", apiClient.parameterToString(X_EBAY_C_MARKETPLACE_ID));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"api_auth"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getItemByLegacyIdValidateBeforeCall(String legacyItemId, String fieldgroups, String legacyVariationId, String legacyVariationSku, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'legacyItemId' is set
        if (legacyItemId == null) {
            throw new ApiException("Missing the required parameter 'legacyItemId' when calling getItemByLegacyId(Async)");
        }

        com.squareup.okhttp.Call call = getItemByLegacyIdCall(legacyItemId, fieldgroups, legacyVariationId, legacyVariationSku, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        return call;


    }

    /**
     * &lt;p&gt;This method is a bridge between the eBay legacy APIs, such as  &lt;b&gt; Shopping&lt;/b&gt;, and &lt;b&gt; Finding&lt;/b&gt; and the eBay Buy APIs. There are differences between how legacy APIs and RESTful APIs return the identifier of an \&quot;item\&quot; and what the item ID represents. This method lets you use the legacy item ids retrieve the details of a specific item, such as description, price, and other information the buyer needs to make a purchasing decision. It also returns the RESTful item ID, which you can use with all the Buy API  methods.&lt;/p&gt;  &lt;p&gt;For more information about how to use legacy ids with the Buy APIs, see &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; in the Buying Integration guide.&lt;/p&gt;  &lt;p&gt;This method returns the item details and requires you to pass in either the item ID of a non-variation item or the item ids of both the parent and child of an item group. An item group is an item that has various aspect differences, such as color, size, storage capacity, etc.&lt;/p&gt; &lt;p&gt;When an item group is created, one of the item variations, such as the red shirt size L, is chosen as the \&quot;parent\&quot;. All the other items in the group are the children, such as the blue shirt size L, red shirt size M, etc.&lt;/p&gt;    &lt;p&gt;The &lt;b&gt; fieldgroups&lt;/b&gt; URI parameter lets you control what is returned in the response. Setting &lt;b&gt; fieldgroups&lt;/b&gt; to &lt;code&gt;PRODUCT&lt;/code&gt; adds additional fields to the default response that return information about the product of the item. Setting the &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. These &lt;b&gt;fieldgroups&lt;/b&gt; can be used independently or at the same time. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param legacyItemId            Specifies either: &lt;ul&gt; &lt;li&gt;The legacy item ID of an item that is &lt;em&gt;not&lt;/em&gt; part of a group. &lt;/li&gt; &lt;li&gt;The legacy item ID of a group, which is the ID of the \&quot;parent\&quot; of the group of items. &lt;br&gt; &lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt; Note: &lt;/b&gt; If you pass in a group ID, you must also use the &lt;b&gt; legacy_variation_id&lt;/b&gt; field and pass in the legacy ID of the specific item variation (child ID).&lt;/span&gt;&lt;/li&gt;&lt;/ul&gt;  Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.  &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; field for a specific item from Finding to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9  &lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item. Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set.&lt;br&gt;&lt;br&gt;&lt;b&gt; Valid Values: &lt;/b&gt;&lt;ul&gt;&lt;li&gt; &lt;b&gt; PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; fields to the response, which describe the item&#x27;s product.  See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field.&lt;/li&gt;&lt;/ul&gt; (optional)
     * @param legacyVariationId       Specifies the legacy item ID of a specific item in an item group, such as the red shirt size L. &lt;br&gt;&lt;br&gt;Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.     &lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_id&lt;/b&gt; (optional)
     * @param legacyVariationSku      Specifics the legacy SKU of the item. SKU are item ids created by the seller. &lt;br&gt;&lt;br&gt;Legacy SKUs are returned by eBay the  &lt;a href&#x3D;\&quot;https://developer.ebay.com/Devzone/shopping/docs/CallRef/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Shopping API&lt;/a&gt;. &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; and &lt;b&gt; SKU&lt;/b&gt; fields to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9&amp;amp;legacy_variation_sku&#x3D;V**********M&lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_sku&lt;/b&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return Item
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Item getItemByLegacyId(String legacyItemId, String fieldgroups, String legacyVariationId, String legacyVariationSku, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        ApiResponse<Item> resp = getItemByLegacyIdWithHttpInfo(legacyItemId, fieldgroups, legacyVariationId, legacyVariationSku, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID);
        return resp.getData();
    }

    /**
     * &lt;p&gt;This method is a bridge between the eBay legacy APIs, such as  &lt;b&gt; Shopping&lt;/b&gt;, and &lt;b&gt; Finding&lt;/b&gt; and the eBay Buy APIs. There are differences between how legacy APIs and RESTful APIs return the identifier of an \&quot;item\&quot; and what the item ID represents. This method lets you use the legacy item ids retrieve the details of a specific item, such as description, price, and other information the buyer needs to make a purchasing decision. It also returns the RESTful item ID, which you can use with all the Buy API  methods.&lt;/p&gt;  &lt;p&gt;For more information about how to use legacy ids with the Buy APIs, see &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; in the Buying Integration guide.&lt;/p&gt;  &lt;p&gt;This method returns the item details and requires you to pass in either the item ID of a non-variation item or the item ids of both the parent and child of an item group. An item group is an item that has various aspect differences, such as color, size, storage capacity, etc.&lt;/p&gt; &lt;p&gt;When an item group is created, one of the item variations, such as the red shirt size L, is chosen as the \&quot;parent\&quot;. All the other items in the group are the children, such as the blue shirt size L, red shirt size M, etc.&lt;/p&gt;    &lt;p&gt;The &lt;b&gt; fieldgroups&lt;/b&gt; URI parameter lets you control what is returned in the response. Setting &lt;b&gt; fieldgroups&lt;/b&gt; to &lt;code&gt;PRODUCT&lt;/code&gt; adds additional fields to the default response that return information about the product of the item. Setting the &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. These &lt;b&gt;fieldgroups&lt;/b&gt; can be used independently or at the same time. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param legacyItemId            Specifies either: &lt;ul&gt; &lt;li&gt;The legacy item ID of an item that is &lt;em&gt;not&lt;/em&gt; part of a group. &lt;/li&gt; &lt;li&gt;The legacy item ID of a group, which is the ID of the \&quot;parent\&quot; of the group of items. &lt;br&gt; &lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt; Note: &lt;/b&gt; If you pass in a group ID, you must also use the &lt;b&gt; legacy_variation_id&lt;/b&gt; field and pass in the legacy ID of the specific item variation (child ID).&lt;/span&gt;&lt;/li&gt;&lt;/ul&gt;  Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.  &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; field for a specific item from Finding to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9  &lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item. Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set.&lt;br&gt;&lt;br&gt;&lt;b&gt; Valid Values: &lt;/b&gt;&lt;ul&gt;&lt;li&gt; &lt;b&gt; PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; fields to the response, which describe the item&#x27;s product.  See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field.&lt;/li&gt;&lt;/ul&gt; (optional)
     * @param legacyVariationId       Specifies the legacy item ID of a specific item in an item group, such as the red shirt size L. &lt;br&gt;&lt;br&gt;Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.     &lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_id&lt;/b&gt; (optional)
     * @param legacyVariationSku      Specifics the legacy SKU of the item. SKU are item ids created by the seller. &lt;br&gt;&lt;br&gt;Legacy SKUs are returned by eBay the  &lt;a href&#x3D;\&quot;https://developer.ebay.com/Devzone/shopping/docs/CallRef/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Shopping API&lt;/a&gt;. &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; and &lt;b&gt; SKU&lt;/b&gt; fields to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9&amp;amp;legacy_variation_sku&#x3D;V**********M&lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_sku&lt;/b&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return ApiResponse&lt;Item&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Item> getItemByLegacyIdWithHttpInfo(String legacyItemId, String fieldgroups, String legacyVariationId, String legacyVariationSku, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        com.squareup.okhttp.Call call = getItemByLegacyIdValidateBeforeCall(legacyItemId, fieldgroups, legacyVariationId, legacyVariationSku, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, null, null);
        Type localVarReturnType = new TypeToken<Item>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * &lt;p&gt;This method is a bridge between the eBay legacy APIs, such as  &lt;b&gt; Shopping&lt;/b&gt;, and &lt;b&gt; Finding&lt;/b&gt; and the eBay Buy APIs. There are differences between how legacy APIs and RESTful APIs return the identifier of an \&quot;item\&quot; and what the item ID represents. This method lets you use the legacy item ids retrieve the details of a specific item, such as description, price, and other information the buyer needs to make a purchasing decision. It also returns the RESTful item ID, which you can use with all the Buy API  methods.&lt;/p&gt;  &lt;p&gt;For more information about how to use legacy ids with the Buy APIs, see &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; in the Buying Integration guide.&lt;/p&gt;  &lt;p&gt;This method returns the item details and requires you to pass in either the item ID of a non-variation item or the item ids of both the parent and child of an item group. An item group is an item that has various aspect differences, such as color, size, storage capacity, etc.&lt;/p&gt; &lt;p&gt;When an item group is created, one of the item variations, such as the red shirt size L, is chosen as the \&quot;parent\&quot;. All the other items in the group are the children, such as the blue shirt size L, red shirt size M, etc.&lt;/p&gt;    &lt;p&gt;The &lt;b&gt; fieldgroups&lt;/b&gt; URI parameter lets you control what is returned in the response. Setting &lt;b&gt; fieldgroups&lt;/b&gt; to &lt;code&gt;PRODUCT&lt;/code&gt; adds additional fields to the default response that return information about the product of the item. Setting the &lt;b&gt;fieldgroups&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. These &lt;b&gt;fieldgroups&lt;/b&gt; can be used independently or at the same time. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param legacyItemId            Specifies either: &lt;ul&gt; &lt;li&gt;The legacy item ID of an item that is &lt;em&gt;not&lt;/em&gt; part of a group. &lt;/li&gt; &lt;li&gt;The legacy item ID of a group, which is the ID of the \&quot;parent\&quot; of the group of items. &lt;br&gt; &lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt; Note: &lt;/b&gt; If you pass in a group ID, you must also use the &lt;b&gt; legacy_variation_id&lt;/b&gt; field and pass in the legacy ID of the specific item variation (child ID).&lt;/span&gt;&lt;/li&gt;&lt;/ul&gt;  Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.  &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; field for a specific item from Finding to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9  &lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item. Multiple &lt;b&gt;fieldgroups&lt;/b&gt; can be set.&lt;br&gt;&lt;br&gt;&lt;b&gt; Valid Values: &lt;/b&gt;&lt;ul&gt;&lt;li&gt; &lt;b&gt; PRODUCT&lt;/b&gt; - This adds the &lt;code&gt;additionalImages&lt;/code&gt;, &lt;code&gt;additionalProductIdentities&lt;/code&gt;, &lt;code&gt;aspectGroups&lt;/code&gt;, &lt;code&gt;description&lt;/code&gt;, &lt;code&gt;gtins&lt;/code&gt;, &lt;code&gt;image&lt;/code&gt;, and &lt;code&gt;title&lt;/code&gt; fields to the response, which describe the item&#x27;s product.  See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyItem#response.product\&quot;&gt;Product&lt;/a&gt; for more information about these fields.&lt;/li&gt;&lt;li&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemByLegacyId#response.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field.&lt;/li&gt;&lt;/ul&gt; (optional)
     * @param legacyVariationId       Specifies the legacy item ID of a specific item in an item group, such as the red shirt size L. &lt;br&gt;&lt;br&gt;Legacy ids are returned by APIs, such as the &lt;a href&#x3D;\&quot;https://developer.ebay.com/devzone/finding/callref/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Finding API&lt;/a&gt;.     &lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_id&lt;/b&gt; (optional)
     * @param legacyVariationSku      Specifics the legacy SKU of the item. SKU are item ids created by the seller. &lt;br&gt;&lt;br&gt;Legacy SKUs are returned by eBay the  &lt;a href&#x3D;\&quot;https://developer.ebay.com/Devzone/shopping/docs/CallRef/index.html \&quot; target&#x3D;\&quot;_blank\&quot;&gt;Shopping API&lt;/a&gt;. &lt;br&gt;&lt;br&gt;The following is an example of using the value of the &lt;b&gt; ItemID&lt;/b&gt; and &lt;b&gt; SKU&lt;/b&gt; fields to get the RESTful &lt;b&gt; itemId&lt;/b&gt; value. &lt;br&gt; &lt;br&gt;&amp;nbsp;&amp;nbsp;&amp;nbsp;&lt;code&gt; browse/v1/item/get_item_by_legacy_id?legacy_item_id&#x3D;1**********9&amp;amp;legacy_variation_sku&#x3D;V**********M&lt;/code&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum: &lt;/b&gt; 1 &lt;br&gt;&lt;b&gt; Requirement: &lt;/b&gt; You must &lt;b&gt; always&lt;/b&gt; pass in the &lt;b&gt; legacy_item_id &lt;/b&gt; with the &lt;b&gt; legacy_variation_sku&lt;/b&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param callback                The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getItemByLegacyIdAsync(String legacyItemId, String fieldgroups, String legacyVariationId, String legacyVariationSku, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ApiCallback<Item> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getItemByLegacyIdValidateBeforeCall(legacyItemId, fieldgroups, legacyVariationId, legacyVariationSku, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Item>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for getItems
     *
     * @param itemIds                 A list of item IDs. Item IDs are the eBay RESTful identifier of items. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error. &lt;br&gt;&lt;br&gt; In a request, multiple item_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemIDs: &lt;/b&gt; 20 &lt;br&gt;&lt;br&gt;For more information about item IDs for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (optional)
     * @param itemGroupIds            A list of item group IDs. Item group IDs are the eBay RESTful identifier of item groups. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Group Item ID Format: &lt;/b&gt;&lt;code&gt;############&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;3**********9&lt;/code&gt;&lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error.&lt;br&gt;&lt;br&gt;In a request, multiple item_group_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemGroupIDs: &lt;/b&gt; 10 &lt;br&gt;&lt;br&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getItemsCall(String itemIds, String itemGroupIds, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/item/";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (itemIds != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("item_ids", itemIds));
        if (itemGroupIds != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("item_group_ids", itemGroupIds));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (X_EBAY_C_ENDUSERCTX != null)
            localVarHeaderParams.put("X-EBAY-C-ENDUSERCTX", apiClient.parameterToString(X_EBAY_C_ENDUSERCTX));
        if (X_EBAY_C_MARKETPLACE_ID != null)
            localVarHeaderParams.put("X-EBAY-C-MARKETPLACE-ID", apiClient.parameterToString(X_EBAY_C_MARKETPLACE_ID));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"api_auth"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getItemsValidateBeforeCall(String itemIds, String itemGroupIds, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        com.squareup.okhttp.Call call = getItemsCall(itemIds, itemGroupIds, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        return call;


    }

    /**
     * This method retrieves the details of specific items that the buyer needs to make a purchasing decision.  &lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt;Note:&lt;/b&gt; This is a &lt;a href&#x3D;\&quot;https://developer.ebay.com/api-docs/static/versioning.html#limited \&quot; target&#x3D;\&quot;_blank\&quot;&gt; &lt;img src&#x3D;\&quot;/cms/img/docs/partners-api.svg\&quot; class&#x3D;\&quot;legend-icon partners-icon\&quot; title&#x3D;\&quot;Limited Release\&quot;  alt&#x3D;\&quot;Limited Release\&quot; /&gt;(Limited Release)&lt;/a&gt; available only to select Partners. &lt;br&gt;&lt;br&gt;For this method, only the following fields are returned: &lt;code&gt;bidCount&lt;/code&gt;, &lt;code&gt;currentBidPrice&lt;/code&gt;, &lt;code&gt;eligibleForInlineCheckout&lt;/code&gt;, &lt;code&gt;enabledForGuestCheckout&lt;/code&gt;, &lt;code&gt;estimatedAvailabilities&lt;/code&gt;, &lt;code&gt;gtin&lt;/code&gt;, &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt;, &lt;code&gt;itemCreationDate&lt;/code&gt;, &lt;code&gt;itemId&lt;/code&gt;, &lt;code&gt;itemWebUrl&lt;/code&gt;, &lt;code&gt;legacyItemId&lt;/code&gt;, &lt;code&gt;minimumPriceToBid&lt;/code&gt;, &lt;code&gt;price&lt;/code&gt;, &lt;code&gt;priorityListing&lt;/code&gt;, &lt;code&gt;reservePriceMet&lt;/code&gt;, &lt;code&gt;sellerItemRevision&lt;/code&gt;, &lt;code&gt;taxes&lt;/code&gt;, &lt;code&gt;topRatedBuyingExperience&lt;/code&gt;, and &lt;code&gt;uniqueBidderCount&lt;/code&gt;.&lt;br&gt;&lt;br&gt;The array &lt;code&gt;shippingOptions&lt;/code&gt;, which comprises multiple fields, is also returned.&lt;/span&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network:&lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the itemAffiliateWebUrl field to forward your buyer to the ebay.com site.
     *
     * @param itemIds                 A list of item IDs. Item IDs are the eBay RESTful identifier of items. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error. &lt;br&gt;&lt;br&gt; In a request, multiple item_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemIDs: &lt;/b&gt; 20 &lt;br&gt;&lt;br&gt;For more information about item IDs for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (optional)
     * @param itemGroupIds            A list of item group IDs. Item group IDs are the eBay RESTful identifier of item groups. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Group Item ID Format: &lt;/b&gt;&lt;code&gt;############&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;3**********9&lt;/code&gt;&lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error.&lt;br&gt;&lt;br&gt;In a request, multiple item_group_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemGroupIDs: &lt;/b&gt; 10 &lt;br&gt;&lt;br&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return Items
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Items getItems(String itemIds, String itemGroupIds, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        ApiResponse<Items> resp = getItemsWithHttpInfo(itemIds, itemGroupIds, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID);
        return resp.getData();
    }

    /**
     * This method retrieves the details of specific items that the buyer needs to make a purchasing decision.  &lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt;Note:&lt;/b&gt; This is a &lt;a href&#x3D;\&quot;https://developer.ebay.com/api-docs/static/versioning.html#limited \&quot; target&#x3D;\&quot;_blank\&quot;&gt; &lt;img src&#x3D;\&quot;/cms/img/docs/partners-api.svg\&quot; class&#x3D;\&quot;legend-icon partners-icon\&quot; title&#x3D;\&quot;Limited Release\&quot;  alt&#x3D;\&quot;Limited Release\&quot; /&gt;(Limited Release)&lt;/a&gt; available only to select Partners. &lt;br&gt;&lt;br&gt;For this method, only the following fields are returned: &lt;code&gt;bidCount&lt;/code&gt;, &lt;code&gt;currentBidPrice&lt;/code&gt;, &lt;code&gt;eligibleForInlineCheckout&lt;/code&gt;, &lt;code&gt;enabledForGuestCheckout&lt;/code&gt;, &lt;code&gt;estimatedAvailabilities&lt;/code&gt;, &lt;code&gt;gtin&lt;/code&gt;, &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt;, &lt;code&gt;itemCreationDate&lt;/code&gt;, &lt;code&gt;itemId&lt;/code&gt;, &lt;code&gt;itemWebUrl&lt;/code&gt;, &lt;code&gt;legacyItemId&lt;/code&gt;, &lt;code&gt;minimumPriceToBid&lt;/code&gt;, &lt;code&gt;price&lt;/code&gt;, &lt;code&gt;priorityListing&lt;/code&gt;, &lt;code&gt;reservePriceMet&lt;/code&gt;, &lt;code&gt;sellerItemRevision&lt;/code&gt;, &lt;code&gt;taxes&lt;/code&gt;, &lt;code&gt;topRatedBuyingExperience&lt;/code&gt;, and &lt;code&gt;uniqueBidderCount&lt;/code&gt;.&lt;br&gt;&lt;br&gt;The array &lt;code&gt;shippingOptions&lt;/code&gt;, which comprises multiple fields, is also returned.&lt;/span&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network:&lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the itemAffiliateWebUrl field to forward your buyer to the ebay.com site.
     *
     * @param itemIds                 A list of item IDs. Item IDs are the eBay RESTful identifier of items. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error. &lt;br&gt;&lt;br&gt; In a request, multiple item_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemIDs: &lt;/b&gt; 20 &lt;br&gt;&lt;br&gt;For more information about item IDs for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (optional)
     * @param itemGroupIds            A list of item group IDs. Item group IDs are the eBay RESTful identifier of item groups. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Group Item ID Format: &lt;/b&gt;&lt;code&gt;############&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;3**********9&lt;/code&gt;&lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error.&lt;br&gt;&lt;br&gt;In a request, multiple item_group_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemGroupIDs: &lt;/b&gt; 10 &lt;br&gt;&lt;br&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return ApiResponse&lt;Items&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Items> getItemsWithHttpInfo(String itemIds, String itemGroupIds, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        com.squareup.okhttp.Call call = getItemsValidateBeforeCall(itemIds, itemGroupIds, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, null, null);
        Type localVarReturnType = new TypeToken<Items>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * This method retrieves the details of specific items that the buyer needs to make a purchasing decision.  &lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt; &lt;b&gt;Note:&lt;/b&gt; This is a &lt;a href&#x3D;\&quot;https://developer.ebay.com/api-docs/static/versioning.html#limited \&quot; target&#x3D;\&quot;_blank\&quot;&gt; &lt;img src&#x3D;\&quot;/cms/img/docs/partners-api.svg\&quot; class&#x3D;\&quot;legend-icon partners-icon\&quot; title&#x3D;\&quot;Limited Release\&quot;  alt&#x3D;\&quot;Limited Release\&quot; /&gt;(Limited Release)&lt;/a&gt; available only to select Partners. &lt;br&gt;&lt;br&gt;For this method, only the following fields are returned: &lt;code&gt;bidCount&lt;/code&gt;, &lt;code&gt;currentBidPrice&lt;/code&gt;, &lt;code&gt;eligibleForInlineCheckout&lt;/code&gt;, &lt;code&gt;enabledForGuestCheckout&lt;/code&gt;, &lt;code&gt;estimatedAvailabilities&lt;/code&gt;, &lt;code&gt;gtin&lt;/code&gt;, &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt;, &lt;code&gt;itemCreationDate&lt;/code&gt;, &lt;code&gt;itemId&lt;/code&gt;, &lt;code&gt;itemWebUrl&lt;/code&gt;, &lt;code&gt;legacyItemId&lt;/code&gt;, &lt;code&gt;minimumPriceToBid&lt;/code&gt;, &lt;code&gt;price&lt;/code&gt;, &lt;code&gt;priorityListing&lt;/code&gt;, &lt;code&gt;reservePriceMet&lt;/code&gt;, &lt;code&gt;sellerItemRevision&lt;/code&gt;, &lt;code&gt;taxes&lt;/code&gt;, &lt;code&gt;topRatedBuyingExperience&lt;/code&gt;, and &lt;code&gt;uniqueBidderCount&lt;/code&gt;.&lt;br&gt;&lt;br&gt;The array &lt;code&gt;shippingOptions&lt;/code&gt;, which comprises multiple fields, is also returned.&lt;/span&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network:&lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the itemAffiliateWebUrl field to forward your buyer to the ebay.com site.
     *
     * @param itemIds                 A list of item IDs. Item IDs are the eBay RESTful identifier of items. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Item ID Format: &lt;/b&gt;&lt;code&gt;v1&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;|&lt;code&gt;&lt;i&gt;#&lt;/i&gt;&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;v1|2**********2|0&lt;/code&gt; or &lt;code&gt;v1|1**********2|4**********2&lt;/code&gt; &lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error. &lt;br&gt;&lt;br&gt; In a request, multiple item_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemIDs: &lt;/b&gt; 20 &lt;br&gt;&lt;br&gt;For more information about item IDs for RESTful APIs, see the &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Legacy\&quot;&gt;Legacy API compatibility&lt;/a&gt; section of the &lt;i&gt;Buy APIs Overview&lt;/i&gt;. (optional)
     * @param itemGroupIds            A list of item group IDs. Item group IDs are the eBay RESTful identifier of item groups. &lt;br&gt;&lt;br&gt;&lt;b&gt; RESTful Group Item ID Format: &lt;/b&gt;&lt;code&gt;############&lt;/code&gt;&lt;br&gt;For example: &lt;code&gt;3**********9&lt;/code&gt;&lt;br&gt;&lt;br&gt;In any given request, either item_ids or item_group_ids can be retrieved. Attempting to retrieve both will result in an error.&lt;br&gt;&lt;br&gt;In a request, multiple item_group_ids can be passed as comma separated values.&lt;br&gt;&lt;br&gt;&lt;b&gt; Maximum allowed itemGroupIDs: &lt;/b&gt; 10 &lt;br&gt;&lt;br&gt; (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param callback                The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getItemsAsync(String itemIds, String itemGroupIds, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ApiCallback<Items> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = callback::onDownloadProgress;

            progressRequestListener = callback::onUploadProgress;
        }

        com.squareup.okhttp.Call call = getItemsValidateBeforeCall(itemIds, itemGroupIds, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Items>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for getItemsByItemGroup
     *
     * @param itemGroupId             Identifier of the item group to return.  An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt; &lt;p&gt;This ID is returned in the &lt;b&gt; itemGroupHref&lt;/b&gt; field of the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item_summary/methods/search\&quot;&gt;search&lt;/a&gt; and &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem\&quot;&gt;getItem&lt;/a&gt; methods. &lt;br&gt;&lt;br&gt;&lt;b&gt; For Example: &lt;/b&gt;&lt;code&gt; https://api.ebay.com/buy/browse/v1/item/get_items_by_item_group?item_group_id&#x3D;3**********6&lt;/code&gt; (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#response.items.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param progressListener        Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getItemsByItemGroupCall(String itemGroupId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/item/get_items_by_item_group";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fieldgroups != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("fieldgroups", fieldgroups));
        if (itemGroupId != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("item_group_id", itemGroupId));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (X_EBAY_C_ENDUSERCTX != null)
            localVarHeaderParams.put("X-EBAY-C-ENDUSERCTX", apiClient.parameterToString(X_EBAY_C_ENDUSERCTX));
        if (X_EBAY_C_MARKETPLACE_ID != null)
            localVarHeaderParams.put("X-EBAY-C-MARKETPLACE-ID", apiClient.parameterToString(X_EBAY_C_MARKETPLACE_ID));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }

        String[] localVarAuthNames = new String[]{"api_auth"};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getItemsByItemGroupValidateBeforeCall(String itemGroupId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'itemGroupId' is set
        if (itemGroupId == null) {
            throw new ApiException("Missing the required parameter 'itemGroupId' when calling getItemsByItemGroup(Async)");
        }

        com.squareup.okhttp.Call call = getItemsByItemGroupCall(itemGroupId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        return call;


    }

    /**
     * &lt;p&gt;This method retrieves the details of the individual items in an item group. An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt;  &lt;p&gt;You pass in the item group ID as a URI parameter. You use this method to show the item details of items with multiple aspects, such as color, size, storage capacity, etc.  &lt;/p&gt;  &lt;p&gt;This method returns two main containers; &lt;b&gt; items&lt;/b&gt; and &lt;b&gt; commonDescriptions&lt;/b&gt;. The &lt;b&gt; items&lt;/b&gt; container has an array of  containers with the details of each item in the group. The &lt;b&gt; commonDescriptions&lt;/b&gt; container has an array of containers for a description and the item ids of all the items that have this exact description. Because items within an item group often have the same description, this decreases the size of the response. &lt;/p&gt;&lt;p&gt;Setting the &lt;b&gt;fieldgroup&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param itemGroupId             Identifier of the item group to return.  An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt; &lt;p&gt;This ID is returned in the &lt;b&gt; itemGroupHref&lt;/b&gt; field of the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item_summary/methods/search\&quot;&gt;search&lt;/a&gt; and &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem\&quot;&gt;getItem&lt;/a&gt; methods. &lt;br&gt;&lt;br&gt;&lt;b&gt; For Example: &lt;/b&gt;&lt;code&gt; https://api.ebay.com/buy/browse/v1/item/get_items_by_item_group?item_group_id&#x3D;3**********6&lt;/code&gt; (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#response.items.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return ItemGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemGroup getItemsByItemGroup(String itemGroupId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        ApiResponse<ItemGroup> resp = getItemsByItemGroupWithHttpInfo(itemGroupId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID);
        return resp.getData();
    }

    /**
     * &lt;p&gt;This method retrieves the details of the individual items in an item group. An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt;  &lt;p&gt;You pass in the item group ID as a URI parameter. You use this method to show the item details of items with multiple aspects, such as color, size, storage capacity, etc.  &lt;/p&gt;  &lt;p&gt;This method returns two main containers; &lt;b&gt; items&lt;/b&gt; and &lt;b&gt; commonDescriptions&lt;/b&gt;. The &lt;b&gt; items&lt;/b&gt; container has an array of  containers with the details of each item in the group. The &lt;b&gt; commonDescriptions&lt;/b&gt; container has an array of containers for a description and the item ids of all the items that have this exact description. Because items within an item group often have the same description, this decreases the size of the response. &lt;/p&gt;&lt;p&gt;Setting the &lt;b&gt;fieldgroup&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param itemGroupId             Identifier of the item group to return.  An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt; &lt;p&gt;This ID is returned in the &lt;b&gt; itemGroupHref&lt;/b&gt; field of the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item_summary/methods/search\&quot;&gt;search&lt;/a&gt; and &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem\&quot;&gt;getItem&lt;/a&gt; methods. &lt;br&gt;&lt;br&gt;&lt;b&gt; For Example: &lt;/b&gt;&lt;code&gt; https://api.ebay.com/buy/browse/v1/item/get_items_by_item_group?item_group_id&#x3D;3**********6&lt;/code&gt; (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#response.items.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @return ApiResponse&lt;ItemGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ItemGroup> getItemsByItemGroupWithHttpInfo(String itemGroupId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID) throws ApiException {
        com.squareup.okhttp.Call call = getItemsByItemGroupValidateBeforeCall(itemGroupId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, null, null);
        Type localVarReturnType = new TypeToken<ItemGroup>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * (asynchronously)
     * &lt;p&gt;This method retrieves the details of the individual items in an item group. An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt;  &lt;p&gt;You pass in the item group ID as a URI parameter. You use this method to show the item details of items with multiple aspects, such as color, size, storage capacity, etc.  &lt;/p&gt;  &lt;p&gt;This method returns two main containers; &lt;b&gt; items&lt;/b&gt; and &lt;b&gt; commonDescriptions&lt;/b&gt;. The &lt;b&gt; items&lt;/b&gt; container has an array of  containers with the details of each item in the group. The &lt;b&gt; commonDescriptions&lt;/b&gt; container has an array of containers for a description and the item ids of all the items that have this exact description. Because items within an item group often have the same description, this decreases the size of the response. &lt;/p&gt;&lt;p&gt;Setting the &lt;b&gt;fieldgroup&lt;/b&gt; to &lt;code&gt;ADDITIONAL_SELLER_DETAILS&lt;/code&gt; adds an additional field to the response that returns the seller&#x27;s user ID. For more information, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#uri.fieldgroups\&quot;&gt;fieldgroups&lt;/a&gt;.&lt;/p&gt;&lt;h3&gt;&lt;b&gt; Restrictions &lt;/b&gt;&lt;/h3&gt; &lt;p&gt;For a list of supported sites and other restrictions, see &lt;a href&#x3D;\&quot;/api-docs/buy/browse/overview.html#API\&quot;&gt;API Restrictions&lt;/a&gt;.&lt;/p&gt; &lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;eBay Partner Network: &lt;/b&gt; In order to be commissioned for your sales, you must use the URL returned in the &lt;code&gt;itemAffiliateWebUrl&lt;/code&gt; field to forward your buyer to the ebay.com site. &lt;/span&gt;
     *
     * @param itemGroupId             Identifier of the item group to return.  An item group is an item that has various aspect differences, such as color, size, storage capacity, etc. &lt;/p&gt; &lt;p&gt;This ID is returned in the &lt;b&gt; itemGroupHref&lt;/b&gt; field of the &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item_summary/methods/search\&quot;&gt;search&lt;/a&gt; and &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItem\&quot;&gt;getItem&lt;/a&gt; methods. &lt;br&gt;&lt;br&gt;&lt;b&gt; For Example: &lt;/b&gt;&lt;code&gt; https://api.ebay.com/buy/browse/v1/item/get_items_by_item_group?item_group_id&#x3D;3**********6&lt;/code&gt; (required)
     * @param fieldgroups             This field lets you control what is returned in the response. If you do not set this field, the method returns all the details of the item.&lt;br&gt;&lt;br&gt;&lt;b&gt;Valid Values:&lt;/b&gt;&lt;br&gt;&lt;br&gt;&lt;b&gt;ADDITIONAL_SELLER_DETAILS&lt;/b&gt; - This adds the &lt;code&gt;userId&lt;/code&gt; field to the response. This field provides the seller&#x27;s user ID. See &lt;a href&#x3D;\&quot;/api-docs/buy/browse/resources/item/methods/getItemsByItemGroup#response.items.seller.userId\&quot;&gt;userId&lt;/a&gt; for more information about this field. (optional)
     * @param X_EBAY_C_ENDUSERCTX     This header is required to support revenue sharing for eBay Partner Network and to improve the accuracy of shipping and delivery time estimations.&lt;br&gt;For additional information, refer to &lt;a href&#x3D;\&quot;/api-docs/buy/static/api-browse.html#Headers\&quot; target&#x3D;\&quot;_blank \&quot;&gt;Use request headers&lt;/a&gt;. (optional)
     * @param X_EBAY_C_MARKETPLACE_ID This header identifies the seller&#x27;s eBay marketplace. It is required for all marketplaces outside of the US.&lt;br&gt;&lt;br&gt;&lt;span class&#x3D;\&quot;tablenote\&quot;&gt;&lt;b&gt;Note:&lt;/b&gt; If a marketplace ID value is not provided, the default value of &lt;code&gt;EBAY_US&lt;/code&gt; is used.&lt;/span&gt;&lt;br&gt;See &lt;a href&#x3D;\&quot;/api-docs/static/rest-request-components.html#marketpl \&quot; target&#x3D;\&quot;_blank \&quot;&gt;HTTP request headers&lt;/a&gt; for the marketplace ID values. (optional)
     * @param callback                The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getItemsByItemGroupAsync(String itemGroupId, String fieldgroups, String X_EBAY_C_ENDUSERCTX, String X_EBAY_C_MARKETPLACE_ID, final ApiCallback<ItemGroup> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getItemsByItemGroupValidateBeforeCall(itemGroupId, fieldgroups, X_EBAY_C_ENDUSERCTX, X_EBAY_C_MARKETPLACE_ID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ItemGroup>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
