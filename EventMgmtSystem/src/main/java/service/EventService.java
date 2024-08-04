package service;



import entity.Event;
import exception.ResourceNotFoundException;
import repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);

        event.setEventName(eventDetails.getEventName());
        event.setEventDate(eventDetails.getEventDate());
        event.setDescription(eventDetails.getDescription());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    public List<Event> getEventsByVenue(Long venueId) {
        return eventRepository.findByVenueId(venueId);
    }

    public List<Event> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }
}

