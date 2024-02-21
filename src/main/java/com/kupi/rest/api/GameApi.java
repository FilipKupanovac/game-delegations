package com.kupi.rest.api;

import com.kupi.rest.api.request.GameRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.GameDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v1/games")
public interface GameApi {

    @PostMapping
    GameDTO createGame(@RequestParam("params") GameRequest gameRequest);

    @GetMapping("/{uuid}")
    GameDTO getGame(@PathVariable String uuid);

    @GetMapping
    PagedResponse<GameDTO> getGames(@RequestParam("params") BasicPageQueryParams params);

    @PutMapping("/{uuid}")
    GameDTO updateGame(@PathVariable String uuid, @RequestBody GameRequest gameRequest);

    @DeleteMapping("/{uuid}")
    void deleteGame(@PathVariable String uuid);
}
