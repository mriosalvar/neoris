package com.pruebatecnica.neorisapi;

import com.pruebatecnica.neorisapi.model.Error;
import com.pruebatecnica.neorisapi.model.PriceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link PriceCheckingApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-12T10:37:34.548952200-05:00[America/Lima]")
public interface PriceCheckingApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /price-checking/{applicationDate}/{productId}/{brandId} : applied price list
     *
     * @param applicationDate application date field (required)
     * @param productId product Identifier field (required)
     * @param brandId BRAND Identifier field (required)
     * @return applied price list (status code 200)
     *         or unexpected error (status code 200)
     * @see PriceCheckingApi#listPrice
     */
    default ResponseEntity<PriceResponse> listPrice(String applicationDate,
        Integer productId,
        Integer brandId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"productIdentifier\" : \"35455\", \"endDate\" : \"2020-12-31 23:59:59\", \"price\" : 38.5, \"brandId\" : 1, \"startDate\" : \"2020-12-31 23:59:59\", \"priceList\" : 4 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
