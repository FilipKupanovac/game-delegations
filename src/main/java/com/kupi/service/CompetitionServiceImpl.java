/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.persistence.repository.CompetitionRepository;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.service.mapper.CompetitionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, CompetitionMapper competitionMapper) {
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
    }

    @Override
    public CompetitionDTO saveCompetition(CompetitionDTO competitionDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public CompetitionDTO getCompetitionById(Long id) {
        // Stub implementation
        return null;
    }

    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        // Stub implementation
        return null;
    }

    @Override
    public CompetitionDTO updateCompetition(Long id, CompetitionDTO competitionDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public void deleteCompetition(Long id) {
        // Stub implementation
    }
}
