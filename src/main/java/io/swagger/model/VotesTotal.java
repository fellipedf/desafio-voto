package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the Item
 */
@Schema(description = "Represents the Item")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-10T15:22:07.277Z[GMT]")


public class VotesTotal   {
  @JsonProperty("itemId")
  private Long itemId = null;

  @JsonProperty("itemDescription")
  private String itemDescription = null;

  @JsonProperty("totalVoteYes")
  private Integer totalVoteYes = null;

  @JsonProperty("totalVoteNo")
  private Integer totalVoteNo = null;

  public VotesTotal itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
   **/
  @Schema(description = "")
  
    public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public VotesTotal itemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
    return this;
  }

  /**
   * Get itemDescription
   * @return itemDescription
   **/
  @Schema(description = "")
  
    public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public VotesTotal totalVoteYes(Integer totalVoteYes) {
    this.totalVoteYes = totalVoteYes;
    return this;
  }

  /**
   * Get totalVoteYes
   * @return totalVoteYes
   **/
  @Schema(description = "")
  
    public Integer getTotalVoteYes() {
    return totalVoteYes;
  }

  public void setTotalVoteYes(Integer totalVoteYes) {
    this.totalVoteYes = totalVoteYes;
  }

  public VotesTotal totalVoteNo(Integer totalVoteNo) {
    this.totalVoteNo = totalVoteNo;
    return this;
  }

  /**
   * Get totalVoteNo
   * @return totalVoteNo
   **/
  @Schema(description = "")
  
    public Integer getTotalVoteNo() {
    return totalVoteNo;
  }

  public void setTotalVoteNo(Integer totalVoteNo) {
    this.totalVoteNo = totalVoteNo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VotesTotal votesTotal = (VotesTotal) o;
    return Objects.equals(this.itemId, votesTotal.itemId) &&
        Objects.equals(this.itemDescription, votesTotal.itemDescription) &&
        Objects.equals(this.totalVoteYes, votesTotal.totalVoteYes) &&
        Objects.equals(this.totalVoteNo, votesTotal.totalVoteNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, itemDescription, totalVoteYes, totalVoteNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VotesTotal {\n");
    
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    itemDescription: ").append(toIndentedString(itemDescription)).append("\n");
    sb.append("    totalVoteYes: ").append(toIndentedString(totalVoteYes)).append("\n");
    sb.append("    totalVoteNo: ").append(toIndentedString(totalVoteNo)).append("\n");
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
