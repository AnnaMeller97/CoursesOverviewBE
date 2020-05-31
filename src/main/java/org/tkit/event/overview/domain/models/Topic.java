package org.tkit.event.overview.domain.models;

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
  @Column(name = "course_id")
  private Integer courseId;
  @Column(name = "name")
  private String name;
  @Column(name = "teacher")
  private String teacher;

  @Deprecated
  public Topic(Integer courseId, String name, String teacher) {
    this.courseId = courseId;
    this.name = name;
    this.teacher = teacher;
  }
}
