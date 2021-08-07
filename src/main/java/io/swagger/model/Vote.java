package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Associate;
import io.swagger.model.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the Vote
 */
@Schema(description = "Represents the Vote")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")


public class Vote   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("associate")
  private Associate associate = null;

  @JsonProperty("items")
  @Valid
  private List<Item> items = null;

  public Vote id(Long id) {
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

  public Vote associate(Associate associate) {
    this.associate = associate;
    return this;
  }

  /**
   * Get associate
   * @return associate
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Associate getAssociate() {
    return associate;
  }

  public void setAssociate(Associate associate) {
    this.associate = associate;
  }

  public Vote items(List<Item> items) {
    this.items = items;
    return this;
  }

  public Vote addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<Item>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Meeting Agenda Items
   * @return items
   **/
  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Meeting Agenda Items")
      @Valid
    public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vote vote = (Vote) o;
    return Objects.equals(this.id, vote.id) &&
        Objects.equals(this.associate, vote.associate) &&
        Objects.equals(this.items, vote.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, associate, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vote {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    associate: ").append(toIndentedString(associate)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
