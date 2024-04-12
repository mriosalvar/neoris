package com.pruebatecnica.neorisapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PriceResponse
 */
@lombok.Data
@lombok.Builder

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-12T10:37:34.548952200-05:00[America/Lima]")
public class PriceResponse {

  private String productIdentifier;

  private Integer brandId;

  private Integer priceList;

  private String startDate;

  private String endDate;

  private BigDecimal price;

  public PriceResponse productIdentifier(String productIdentifier) {
    this.productIdentifier = productIdentifier;
    return this;
  }

  /**
   * product Identifier field
   * @return productIdentifier
  */
  
  @Schema(name = "productIdentifier", example = "35455", description = "product Identifier field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productIdentifier")
  public String getProductIdentifier() {
    return productIdentifier;
  }

  public void setProductIdentifier(String productIdentifier) {
    this.productIdentifier = productIdentifier;
  }

  public PriceResponse brandId(Integer brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * string Identifier field
   * @return brandId
  */
  
  @Schema(name = "brandId", example = "1", description = "string Identifier field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("brandId")
  public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  public PriceResponse priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * price List field
   * @return priceList
  */
  
  @Schema(name = "priceList", example = "4", description = "price List field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priceList")
  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public PriceResponse startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * start date field
   * @return startDate
  */
  
  @Schema(name = "startDate", example = "2020-12-31 23:59:59", description = "start date field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startDate")
  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public PriceResponse endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * start date field
   * @return endDate
  */
  
  @Schema(name = "endDate", example = "2020-12-31 23:59:59", description = "start date field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endDate")
  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public PriceResponse price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * price apply field
   * @return price
  */
  @Valid 
  @Schema(name = "price", example = "38.5", description = "price apply field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceResponse priceResponse = (PriceResponse) o;
    return Objects.equals(this.productIdentifier, priceResponse.productIdentifier) &&
        Objects.equals(this.brandId, priceResponse.brandId) &&
        Objects.equals(this.priceList, priceResponse.priceList) &&
        Objects.equals(this.startDate, priceResponse.startDate) &&
        Objects.equals(this.endDate, priceResponse.endDate) &&
        Objects.equals(this.price, priceResponse.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productIdentifier, brandId, priceList, startDate, endDate, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceResponse {\n");
    sb.append("    productIdentifier: ").append(toIndentedString(productIdentifier)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

