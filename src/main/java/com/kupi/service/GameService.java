package com.kupi.service;

import com.kupi.rest.api.request.GameRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.GameDTO;

/**
 * Service interface for managing games in the system.
 */
public interface GameService {

    /**
     * Saves game to the system.
     *
     * @param gameRequest request to create game
     * @return created game representation
     */
    GameDTO saveGame(GameRequest gameRequest);

    /**
     * Return game with provided identifier.
     *
     * @param uuid identifier of competition
     * @return game representation
     */
    GameDTO getGame(String uuid);

    /**
     * Page games.
     *
     * @param params query params
     * @return page response
     */
    PagedResponse<GameDTO> getAllGames(BasicPageQueryParams params);

    /**
     * Update game with provided identifier.
     *
     * @param uuid        game identifier
     * @param gameRequest request to update game
     * @return updated game representation
     */
    GameDTO updateGame(String uuid, GameRequest gameRequest);

    /**
     * Delete game with provided representation.
     *
     * @param uuid game identifier
     */
    void deleteGame(String uuid);
}
