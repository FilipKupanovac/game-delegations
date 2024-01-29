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
    public GameDTO createGame(GameRequest gameRequest) {
        log.info("GameApi.createGame [{}]", gameRequest);
        return gameService.saveGame(gameRequest);
    }

    @Override
    public GameDTO getGame(String uuid) {
        log.info("GameApi.getGame [{}]", uuid);
        return gameService.getGame(uuid); // Assuming there is a method getGameById(String uuid) in GameService
    }

    @Override
    public PagedResponse<GameDTO> getAllGames(BasicPageQueryParams params) {
        log.info("GameApi.getAllGames [{}]", params);
        return gameService.getAllGames(params);
    }

    @Override
    public GameDTO updateGame(String uuid, GameRequest gameRequest) {
        log.info("GameApi.updateGame [uuid: {}, gameDTO: {}]", uuid, gameRequest);
        return gameService.updateGame(uuid, gameRequest);
    }

    @Override
    public void deleteGame(String uuid) {
        log.info("GameApi.deleteGame [{}]", uuid);
        gameService.deleteGame(uuid);
    }
}
