package ybo.backend.domain.realtime.dto;

import lombok.Builder;
import lombok.Getter;
import ybo.backend.domain.realtime.domain.RealtimeGame;
import ybo.backend.domain.realtime.domain.RealtimeRanking;

@Builder
@Getter
public class RealtimeGameDto {
    private String gameState;
    private String leftTeam;
    private String rightTeam;
    private String leftScore;
    private String rightScore;
    private String state;
    private String leftPitcher;
    private String rightPitcher;

    public static RealtimeGameDto createDto(RealtimeGame game){
        return RealtimeGameDto.builder()
                .gameState(game.getGameState())
                .leftTeam(game.getLeftTeam())
                .rightTeam(game.getRightTeam())
                .leftScore(game.getLeftScore())
                .rightScore(game.getRightScore())
                .state(game.getState())
                .leftPitcher(game.getLeftPitcher())
                .rightPitcher(game.getRightPitcher()).build();
    }
}


