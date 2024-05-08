package com.kupi.delegations.service;

import com.kupi.delegations.persistence.entity.GameEntity;
import com.kupi.delegations.persistence.repository.GameRepository;
import com.kupi.delegations.rest.api.request.GameRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.GameDTO;
import com.kupi.delegations.service.mapper.GameMapper;
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
    public GameDTO createGame(GameRequest gameRequest) {
        GameEntity gameEntity = gameMapper.toEntity(gameRequest);
        gameEntity.setUuid(idGenerator.generateId().toString());
        return gameMapper.toDTO(gameRepository.save(gameEntity));
    }

    @Override
    public GameDTO getGame(String uuid) {
        return gameMapper.toDTO(getByUuid(uuid));
    }

    @Override
    public PagedResponse<GameDTO> getGames(BasicPageQueryParams params) {
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
    public GameDTO updateGame(String uuid, GameRequest gameRequest) {
        GameEntity gameEntity = getByUuid(uuid);
        gameMapper.update(gameEntity, gameRequest);
        return gameMapper.toDTO(gameRepository.save(gameEntity));
    }

    @Override
    public void deleteGame(String uuid) {
        gameRepository.delete(getByUuid(uuid));
    }

    private GameEntity getByUuid(String uuid) {
        return gameRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Game with uuid " + uuid + " not found"));
    }
}
