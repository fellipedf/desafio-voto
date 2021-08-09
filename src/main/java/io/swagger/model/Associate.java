package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents a associate
 */
@Schema(description = "Represents a associate")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")

@Builder
public class Associate   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("cpfCnpj")
  private String cpfCnpj = null;

  public Associate id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier
   * @return id
   **/
  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Unique identifier")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Associate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Associate name
   * @return name
   **/
  @Schema(required = true, description = "Associate name")
      @NotNull

  @Size(min=10,max=500)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Associate cpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
    return this;
  }

  /**
   * CPF or CNPJ
   * @return cpfCnpj
   **/
  @Schema(example = "30030030030", required = true, description = "CPF or CNPJ")
      @NotNull

  @Pattern(regexp="^\\d{11}$") @Size(min=11,max=14)   public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Associate associate = (Associate) o;
    return Objects.equals(this.id, associate.id) &&
        Objects.equals(this.name, associate.name) &&
        Objects.equals(this.cpfCnpj, associate.cpfCnpj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cpfCnpj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Associate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cpfCnpj: ").append(toIndentedString(cpfCnpj)).append("\n");
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
