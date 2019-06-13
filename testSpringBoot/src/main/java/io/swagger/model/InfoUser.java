package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


/**
 * InfoUser
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-29T15:16:47.707Z")

public class InfoUser   {
  @JsonProperty("identificationId")
  private String identificationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("cellphone")
  private String cellphone = null;

  @JsonProperty("age")
  private String age = null;

  @JsonProperty("registerDate")
  private String registerDate = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("registerUser")
  private String registerUser = null;

  public InfoUser identificationId(String identificationId) {
    this.identificationId = identificationId;
    return this;
  }

  /**
   * Get identificationId
   * @return identificationId
  **/
  @ApiModelProperty(value = "")


  public String getIdentificationId() {
    return identificationId;
  }

  public void setIdentificationId(String identificationId) {
    this.identificationId = identificationId;
  }

  public InfoUser name(String name) {
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

  public InfoUser cellphone(String cellphone) {
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

  public InfoUser age(String age) {
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

  public InfoUser registerDate(String registerDate) {
    this.registerDate = registerDate;
    return this;
  }

  /**
   * Get registerDate
   * @return registerDate
  **/
  @ApiModelProperty(value = "")


  public String getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(String registerDate) {
    this.registerDate = registerDate;
  }

  public InfoUser status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public InfoUser registerUser(String registerUser) {
    this.registerUser = registerUser;
    return this;
  }

  /**
   * Get registerUser
   * @return registerUser
  **/
  @ApiModelProperty(value = "")


  public String getRegisterUser() {
    return registerUser;
  }

  public void setRegisterUser(String registerUser) {
    this.registerUser = registerUser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfoUser infoUser = (InfoUser) o;
    return Objects.equals(this.identificationId, infoUser.identificationId) &&
        Objects.equals(this.name, infoUser.name) &&
        Objects.equals(this.cellphone, infoUser.cellphone) &&
        Objects.equals(this.age, infoUser.age) &&
        Objects.equals(this.registerDate, infoUser.registerDate) &&
        Objects.equals(this.status, infoUser.status) &&
        Objects.equals(this.registerUser, infoUser.registerUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identificationId, name, cellphone, age, registerDate, status, registerUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoUser {\n");
    
    sb.append("    identificationId: ").append(toIndentedString(identificationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cellphone: ").append(toIndentedString(cellphone)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    registerDate: ").append(toIndentedString(registerDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    registerUser: ").append(toIndentedString(registerUser)).append("\n");
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

