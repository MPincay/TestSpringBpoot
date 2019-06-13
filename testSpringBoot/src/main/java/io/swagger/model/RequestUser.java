package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RequestUser
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-29T15:16:47.707Z")

public class RequestUser   {
  @JsonProperty("identificationId")
  private String identificationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("cellphone")
  private String cellphone = null;

  @JsonProperty("age")
  private String age = null;

  public RequestUser identificationId(String identificationId) {
    this.identificationId = identificationId;
    return this;
  }

  /**
   * Get identificationId
   * @return identificationId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIdentificationId() {
    return identificationId;
  }

  public void setIdentificationId(String identificationId) {
    this.identificationId = identificationId;
  }

  public RequestUser name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RequestUser cellphone(String cellphone) {
    this.cellphone = cellphone;
    return this;
  }

  /**
   * Get cellphone
   * @return cellphone
  **/
  @ApiModelProperty(value = "")


  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public RequestUser age(String age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")


  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestUser requestUser = (RequestUser) o;
    return Objects.equals(this.identificationId, requestUser.identificationId) &&
        Objects.equals(this.name, requestUser.name) &&
        Objects.equals(this.cellphone, requestUser.cellphone) &&
        Objects.equals(this.age, requestUser.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identificationId, name, cellphone, age);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestUser {\n");
    
    sb.append("    identificationId: ").append(toIndentedString(identificationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cellphone: ").append(toIndentedString(cellphone)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

