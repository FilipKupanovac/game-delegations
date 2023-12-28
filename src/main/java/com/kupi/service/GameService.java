package com.kupi.service;

import com.kupi.rest.dto.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO saveGame(GameDTO gameDTO);

    GameDTO getGameById(Long id);

    List<GameDTO> getAllGames();

    GameDTO updateGame(Long id, GameDTO gameDTO);

    void deleteGame(Long id);
}

