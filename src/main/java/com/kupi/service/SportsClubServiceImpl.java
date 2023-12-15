/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.persistence.repository.SportsClubRepository;
import com.kupi.rest.dto.SportsClubDTO;
import com.kupi.service.mapper.SportsClubMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsClubServiceImpl implements SportsClubService {

    private final SportsClubRepository sportsClubRepository;
    private final SportsClubMapper sportsClubMapper;

    public SportsClubServiceImpl(SportsClubRepository sportsClubRepository, SportsClubMapper sportsClubMapper) {
        this.sportsClubRepository = sportsClubRepository;
        this.sportsClubMapper = sportsClubMapper;
    }

    @Override
    public SportsClubDTO saveSportsClub(SportsClubDTO sportsClubDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public SportsClubDTO getSportsClubById(Long id) {
        // Stub implementation
        return null;
    }

    @Override
    public List<SportsClubDTO> getAllSportsClubs() {
        // Stub implementation
        return null;
    }

    @Override
    public SportsClubDTO updateSportsClub(Long id, SportsClubDTO sportsClubDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public void deleteSportsClub(Long id) {
        // Stub implementation
    }
}
