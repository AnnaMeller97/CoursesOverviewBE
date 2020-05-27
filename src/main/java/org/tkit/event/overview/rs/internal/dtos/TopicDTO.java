package org.tkit.event.overview.rs.internal.dtos;

import java.sql.Time;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicDTO {

  private Integer eventId;
  private String name;
  private String speaker;
  private Timestamp start;
  private Time duration;
}
