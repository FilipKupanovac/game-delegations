/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.persistence.entity.GameEntity;
import com.kupi.persistence.repository.GameRepository;
import com.kupi.rest.dto.GameDTO;
import com.kupi.service.mapper.GameMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final IdGenerator idGenerator;

    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper, IdGenerator idGenerator) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public GameDTO saveGame(GameDTO gameDTO) {
        GameEntity gameEntity = gameMapper.toEntity(gameDTO);
        gameEntity.setUuid(idGenerator.generateId().toString());
        return gameMapper.toDTO(gameRepository.save(gameEntity));
    }

    @Override
    public GameDTO getGameById(Long id) {
        return gameMapper.toDTO(getById(id));
    }

    @Override
    public List<GameDTO> getAllGames() {
        // TODO - change to paging return with filters
        return gameRepository.findAll().stream().map(gameMapper::toDTO).toList();
    }

    @Override
    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        GameEntity gameEntity = getById(id);
        gameMapper.update(gameEntity, gameDTO);
        return gameMapper.toDTO(gameRepository.save(gameEntity));
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.delete(getById(id));
    }

    private GameEntity getById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game with id " + id + " not found"));
    }
}
