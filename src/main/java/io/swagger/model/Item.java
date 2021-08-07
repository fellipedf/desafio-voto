package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.VoteEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the Item
 */
@Schema(description = "Represents the Item")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")


public class Item   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("vote")
  private VoteEnum vote = null;

  public Item id(Long id) {
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

  public Item description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description
   * @return description
   **/
  @Schema(example = "Description name of item", required = true, description = "Description")
      @NotNull

  @Size(max=500)   public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Item vote(VoteEnum vote) {
    this.vote = vote;
    return this;
  }

  /**
   * Get vote
   * @return vote
   **/
  @Schema(description = "")
  
    @Valid
    public VoteEnum getVote() {
    return vote;
  }

  public void setVote(VoteEnum vote) {
    this.vote = vote;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.id, item.id) &&
        Objects.equals(this.description, item.description) &&
        Objects.equals(this.vote, item.vote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, vote);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    vote: ").append(toIndentedString(vote)).append("\n");
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
