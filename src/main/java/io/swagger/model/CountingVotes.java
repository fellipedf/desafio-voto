package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.VotesTotal;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Votes Result
 */
@Schema(description = "Votes Result")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-10T15:22:07.277Z[GMT]")


public class CountingVotes   {
  @JsonProperty("votes")
  @Valid
  private List<VotesTotal> votes = new ArrayList<>();

  public CountingVotes votes(List<VotesTotal> votes) {
    this.votes = votes;
    return this;
  }

  public CountingVotes addVotesItem(VotesTotal votesItem) {
    if (this.votes == null) {
      this.votes = new ArrayList<VotesTotal>();
    }
    this.votes.add(votesItem);
    return this;
  }

  /**
   * Counting Votes
   * @return votes
   **/
  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Counting Votes")
      @Valid
    public List<VotesTotal> getVotes() {
    return votes;
  }

  public void setVotes(List<VotesTotal> votes) {
    this.votes = votes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountingVotes countingVotes = (CountingVotes) o;
    return Objects.equals(this.votes, countingVotes.votes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(votes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CountingVotes {\n");
    
    sb.append("    votes: ").append(toIndentedString(votes)).append("\n");
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
