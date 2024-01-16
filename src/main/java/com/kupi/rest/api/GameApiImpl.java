package com.kupi.rest.api;

import com.kupi.rest.api.request.GameRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.GameDTO;
import com.kupi.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameApiImpl implements GameApi {

    private static final Logger log = LoggerFactory.getLogger(GameApiImpl.class);

    private final GameService gameService;

    public GameApiImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public GameDTO createGameDTO(GameRequest gameRequest) {
        log.info("GameApi.createGameDTO [{}]", gameRequest);
        return gameService.saveGame(gameRequest);
    }

    @Override
    public GameDTO getGameDTO(Long id) {
        log.info("GameApi.getGameDTO [{}]", id);
        return gameService.getGameById(id);
    }

    @Override
    public PagedResponse<GameDTO> getAllGamesDTO(BasicPageQueryParams params) {
        log.info("GameApi.getAllGamesDTO [{}]", params);
        return gameService.getAllGames(params);
    }

    @Override
    public GameDTO updateGameDTO(Long id, GameRequest gameRequest) {
        log.info("GameApi.updateGameDTO [id: {}, gameDTO: {}]", id, gameRequest);
        return gameService.updateGame(id, gameRequest);
    }

    @Override
    public void deleteGameDTO(Long id) {
        log.info("GameApi.deleteGameDTO [{}]", id);
        gameService.deleteGame(id);
    }
}
