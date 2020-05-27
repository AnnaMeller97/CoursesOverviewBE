//package org.tkit.event.overview.rs.internal.mappers;
//
//import java.util.stream.Stream;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.tkit.event.overview.domain.models.Event;
//import org.tkit.event.overview.rs.internal.dtos.EventDTO;
//
//@Mapper
//public interface EventMapper {
//  EventDTO map(Event model);
//
//  Stream<EventDTO> map(Stream<Event> model);
//
//  @Mapping(target = "id", ignore = true)
//  Event create(EventDTO dto);
//}
