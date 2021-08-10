package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents the Scheduler
 */
@Schema(description = "Represents the Scheduler")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-10T13:36:40.962Z[GMT]")

@Builder
public class MeetingAgendaItems   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("timer")
  private Long timer = null;

  @JsonProperty("items")
  @Valid
  private List<Long> items = new ArrayList<Long>();

  @JsonProperty("status")
  private Status status = null;

  public MeetingAgendaItems id(Long id) {
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

  public MeetingAgendaItems timer(Long timer) {
    this.timer = timer;
    return this;
  }

  /**
   * Timer to finish session
   * @return timer
   **/
  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Timer to finish session")
  
    public Long getTimer() {
    return timer;
  }

  public void setTimer(Long timer) {
    this.timer = timer;
  }

  public MeetingAgendaItems items(List<Long> items) {
    this.items = items;
    return this;
  }

  public MeetingAgendaItems addItemsItem(Long itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Meeting Agenda Items
   * @return items
   **/
  @Schema(required = true, accessMode = Schema.AccessMode.READ_ONLY, description = "Meeting Agenda Items")
      @NotNull

    public List<Long> getItems() {
    return items;
  }

  public void setItems(List<Long> items) {
    this.items = items;
  }

  public MeetingAgendaItems status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    @Valid
    public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingAgendaItems meetingAgendaItems = (MeetingAgendaItems) o;
    return Objects.equals(this.id, meetingAgendaItems.id) &&
        Objects.equals(this.timer, meetingAgendaItems.timer) &&
        Objects.equals(this.items, meetingAgendaItems.items) &&
        Objects.equals(this.status, meetingAgendaItems.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timer, items, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingAgendaItems {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    timer: ").append(toIndentedString(timer)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
