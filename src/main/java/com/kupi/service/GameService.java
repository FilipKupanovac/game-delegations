package com.kupi.service;

import com.kupi.rest.dto.GameDTO;

import java.util.List;
/**
 * Service interface for managing games in the system.
 */
public interface GameService {

    /**
     * Saves game to the system.
     *
     * @param gameDTO representation of game
     * @return created game representation
     */
    GameDTO saveGame(GameDTO gameDTO);

    /**
     * Return game with provided identifier.
     *
     * @param id identifier of competition
     * @return game representation
     */
    GameDTO getGameById(Long id);

    List<GameDTO> getAllGames();

    /**
     * Update game with provided identifier.
     *
     * @param id game identifier
     * @param gameDTO fields to update
     * @return updated game representation
     */
    GameDTO updateGame(Long id, GameDTO gameDTO);

    /**
     * Delete game with provided representation.
     *
     * @param id game identifier
     */
    void deleteGame(Long id);
}

