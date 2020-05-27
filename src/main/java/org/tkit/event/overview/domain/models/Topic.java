package org.tkit.event.overview.domain.models;

import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topic")
public class Topic {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;
  @Column(name = "event_id")
  private Integer eventId;
  @Column(name = "name")
  private String name;
  @Column(name = "speaker")
  private String speaker;
  @Column(name = "start")
  private Timestamp start;
  @Column(name = "duration")
  private Time duration;
}
