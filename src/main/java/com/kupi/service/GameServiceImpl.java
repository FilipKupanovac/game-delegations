package com.kupi.service;

import com.kupi.persistence.entity.GameEntity;
import com.kupi.persistence.repository.GameRepository;
import com.kupi.rest.api.request.GameRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.GameDTO;
import com.kupi.service.mapper.GameMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

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
    public GameDTO saveGame(GameRequest gameRequest) {
        GameEntity gameEntity = gameMapper.toEntity(gameRequest);
        gameEntity.setUuid(idGenerator.generateId().toString());
        return gameMapper.toDTO(gameRepository.save(gameEntity));
    }

    @Override
    public GameDTO getGameById(Long id) {
        return gameMapper.toDTO(getById(id));
    }

    @Override
    public PagedResponse<GameDTO> getAllGames(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (gameRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<GameEntity> pageSlice = gameRepository.findAll(pageRequest);
        Page<GameDTO> pageSliceDTO = pageSlice.map(gameMapper::toDTO);
        PagedResponse<GameDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public GameDTO updateGame(Long id, GameRequest gameRequest) {
        GameEntity gameEntity = getById(id);
        gameMapper.update(gameEntity, gameRequest);
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
