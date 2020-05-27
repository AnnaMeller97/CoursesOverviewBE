package org.tkit.event.overview.domain.models;

import java.sql.Timestamp;
import lombok.Value;

@Value
//@Entity
//@Table(name = "event")
public class Event {

  private Integer id;
  private String subject;
  private Timestamp date;

}
