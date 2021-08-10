package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.VoteItem;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the Vote
 */
@Schema(description = "Represents the Vote")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-10T13:36:40.962Z[GMT]")

@Builder
public class Vote   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("associateId")
  private Long associateId = null;

  @JsonProperty("meetingAgendaId")
  private Long meetingAgendaId = null;

  @JsonProperty("items")
  @Valid
  private List<VoteItem> items = new ArrayList<VoteItem>();

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

  public Vote associateId(Long associateId) {
    this.associateId = associateId;
    return this;
  }

  /**
   * Get associateId
   * @return associateId
   **/
  @Schema(required = true, accessMode = Schema.AccessMode.READ_ONLY, description = "")
      @NotNull

    public Long getAssociateId() {
    return associateId;
  }

  public void setAssociateId(Long associateId) {
    this.associateId = associateId;
  }

  public Vote meetingAgendaId(Long meetingAgendaId) {
    this.meetingAgendaId = meetingAgendaId;
    return this;
  }

  /**
   * Get meetingAgendaId
   * @return meetingAgendaId
   **/
  @Schema(required = true, accessMode = Schema.AccessMode.READ_ONLY, description = "")
      @NotNull

    public Long getMeetingAgendaId() {
    return meetingAgendaId;
  }

  public void setMeetingAgendaId(Long meetingAgendaId) {
    this.meetingAgendaId = meetingAgendaId;
  }

  public Vote items(List<VoteItem> items) {
    this.items = items;
    return this;
  }

  public Vote addItemsItem(VoteItem itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Meeting Agenda Items
   * @return items
   **/
  @Schema(required = true, accessMode = Schema.AccessMode.READ_ONLY, description = "Meeting Agenda Items")
      @NotNull
    @Valid
    public List<VoteItem> getItems() {
    return items;
  }

  public void setItems(List<VoteItem> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vote vote = (Vote) o;
    return Objects.equals(this.id, vote.id) &&
        Objects.equals(this.associateId, vote.associateId) &&
        Objects.equals(this.meetingAgendaId, vote.meetingAgendaId) &&
        Objects.equals(this.items, vote.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, associateId, meetingAgendaId, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vote {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    associateId: ").append(toIndentedString(associateId)).append("\n");
    sb.append("    meetingAgendaId: ").append(toIndentedString(meetingAgendaId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
