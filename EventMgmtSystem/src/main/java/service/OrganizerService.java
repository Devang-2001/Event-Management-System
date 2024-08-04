package service;



import entity.Organizer;
import exception.ResourceNotFoundException;
import repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
    }

    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Organizer organizer = getOrganizerById(id);

        organizer.setName(organizerDetails.getName());
        organizer.setContactInfo(organizerDetails.getContactInfo());

        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        Organizer organizer = getOrganizerById(id);
        organizerRepository.delete(organizer);
    }
}

