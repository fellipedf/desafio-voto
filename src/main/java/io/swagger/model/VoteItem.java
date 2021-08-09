package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.VoteEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the Item
 */
@Schema(description = "Represents the Item")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-09T21:12:03.154Z[GMT]")

@Builder
public class VoteItem   {
  @JsonProperty("itemId")
  private Long itemId = null;

  @JsonProperty("vote")
  private VoteEnum vote = null;

  public VoteItem itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
   **/
  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "")
  
    public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public VoteItem vote(VoteEnum vote) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoteItem voteItem = (VoteItem) o;
    return Objects.equals(this.itemId, voteItem.itemId) &&
        Objects.equals(this.vote, voteItem.vote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, vote);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoteItem {\n");
    
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    vote: ").append(toIndentedString(vote)).append("\n");
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
