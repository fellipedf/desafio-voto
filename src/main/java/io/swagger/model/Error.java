package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.ErrorErrors;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")


public class Error   {
  @JsonProperty("timestamp")
  private String timestamp = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("errors")
  @Valid
  private List<ErrorErrors> errors = null;

  public Error timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Timestamp
   * @return timestamp
   **/
  @Schema(description = "Timestamp")
  
    public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP Status code
   * @return status
   **/
  @Schema(description = "HTTP Status code")
  
    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Error errors(List<ErrorErrors> errors) {
    this.errors = errors;
    return this;
  }

  public Error addErrorsItem(ErrorErrors errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<ErrorErrors>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
   **/
  @Schema(description = "")
      @Valid
    public List<ErrorErrors> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorErrors> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.timestamp, error.timestamp) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.errors, error.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, status, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
