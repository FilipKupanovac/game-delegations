package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.api.request.GameRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.GameDTO;
import com.kupi.delegations.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameApiImpl implements GameApi {

    private static final Logger log = LoggerFactory.getLogger(GameApiImpl.class);

    private final GameService gameService;

    public GameApiImpl(GameService gameService) {
        this.gameService = gameService;
        log.info(this.getClass().getName() + " successfully initialized");
    }

    @Override
    public GameDTO createGame(GameRequest gameRequest) {
        log.info("GameApi.createGame [{}]", gameRequest);
        return gameService.createGame(gameRequest);
    }

    @Override
    public GameDTO getGame(String uuid) {
        log.info("GameApi.getGame [{}]", uuid);
        return gameService.getGame(uuid);
    }

    @Override
    public PagedResponse<GameDTO> getGames(BasicPageQueryParams params) {
        log.info("GameApi.getGames [{}]", params);
        return gameService.getGames(params);
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
