/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.persistence.repository.GameRepository;
import com.kupi.rest.dto.GameDTO;
import com.kupi.service.mapper.GameMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    @Override
    public GameDTO saveGame(GameDTO gameDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public GameDTO getGameById(Long id) {
        // Stub implementation
        return null;
    }

    @Override
    public List<GameDTO> getAllGames() {
        // Stub implementation
        return null;
    }

    @Override
    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public void deleteGame(Long id) {
        // Stub implementation
    }
}
