package org.tkit.event.overview.rs.internal.mappers;

import javax.enterprise.context.ApplicationScoped;
import org.tkit.event.overview.domain.models.Topic;
import org.tkit.event.overview.rs.internal.dtos.TopicDTO;

@ApplicationScoped
public class TopicMapper {

  public TopicDTO map(Topic topic) {
    return new TopicDTO(
        topic.getEventId(),
        topic.getName(),
        topic.getSpeaker(),
        topic.getStart(),
        topic.getDuration()
    );
  }
  public Topic map(TopicDTO dto) {
    Topic topic = new Topic();
    topic.setEventId(dto.getEventId());
    topic.setName(dto.getName());
    topic.setDuration(dto.getDuration());
    topic.setSpeaker(dto.getSpeaker());
    topic.setStart(dto.getStart());
    return topic;
  }
}
