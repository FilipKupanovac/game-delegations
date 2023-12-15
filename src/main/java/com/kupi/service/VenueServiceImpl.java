/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.persistence.repository.VenueRepository;
import com.kupi.rest.dto.VenueDTO;
import com.kupi.service.mapper.VenueMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    public VenueServiceImpl(VenueRepository venueRepository, VenueMapper venueMapper) {
        this.venueRepository = venueRepository;
        this.venueMapper = venueMapper;
    }

    @Override
    public VenueDTO saveVenue(VenueDTO venueDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public VenueDTO getVenueById(Long id) {
        // Stub implementation
        return null;
    }

    @Override
    public List<VenueDTO> getAllVenues() {
        // Stub implementation
        return null;
    }

    @Override
    public VenueDTO updateVenue(Long id, VenueDTO venueDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public void deleteVenue(Long id) {
        // Stub implementation
    }
}
