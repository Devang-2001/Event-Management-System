package service;



import entity.Venue;
import exception.ResourceNotFoundException;
import repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Venue getVenueById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
    }

    public Venue updateVenue(Long id, Venue venueDetails) {
        Venue venue = getVenueById(id);

        venue.setName(venueDetails.getName());
        venue.setLocation(venueDetails.getLocation());
        venue.setCapacity(venueDetails.getCapacity());

        return venueRepository.save(venue);
    }

    public void deleteVenue(Long id) {
        Venue venue = getVenueById(id);
        venueRepository.delete(venue);
    }
}

