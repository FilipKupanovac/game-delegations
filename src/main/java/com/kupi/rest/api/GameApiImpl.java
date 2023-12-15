/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.rest.api;

import com.kupi.rest.dto.GameDTO;
import com.kupi.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameApiImpl implements GameApi {

    private static final Logger log = LoggerFactory.getLogger(GameApiImpl.class);

    private final GameService gameService;

    public GameApiImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public GameDTO createGameDTO(GameDTO gameDTO) {
        log.info("GameApi.createGameDTO [{}]", gameDTO);
        return gameService.saveGame(gameDTO);
    }

    @Override
    public GameDTO getGameDTO(Long id) {
        log.info("GameApi.getGameDTO [{}]", id);
        return gameService.getGameById(id);
    }

    @Override
    public List<GameDTO> getAllGamesDTO() {
        log.info("GameApi.getAllGamesDTO");
        return gameService.getAllGames();
    }

    @Override
    public GameDTO updateGameDTO(Long id, GameDTO gameDTO) {
        log.info("GameApi.updateGameDTO [id: {}, gameDTO: {}]", id, gameDTO);
        return gameService.updateGame(id, gameDTO);
    }

    @Override
    public void deleteGameDTO(Long id) {
        log.info("GameApi.deleteGameDTO [{}]", id);
        gameService.deleteGame(id);
    }
}
