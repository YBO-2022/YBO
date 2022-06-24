package ybo.backend.domain.teams.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.teams.domain.*;
import ybo.backend.domain.teams.repository.*;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class TeamsService {

    private final FirstTeamRepository firstTeamRepository;
    private final RankingHistoryRepository rankingHistoryRepository;
    private final WarRepository warRepository;
    private final RankPredictRepository rankPredictRepository;
    private final VictoryNumRepository victoryNum;
    private final SeasonHighLowRepository seasonHighLowRepository;

    @Transactional
    public List<RankPredict> findRankPredict() {
        return rankPredictRepository.findAll();
    }

    @Transactional
    public VictoryNum findVictoryNum(String team) {
        return victoryNum.findByTeam(team);
    }

    @Transactional
    public SeasonHighLow findSeasonHighLow(String team) {
        return seasonHighLowRepository.findByTeam(team);
    }

    @Transactional
    public FirstTeam findFirstTeam(String team) {
        return firstTeamRepository.findByTeam(team);
    }

    @Transactional
    public List<WarList> findTop5War(String team) {
        return warRepository.findTop5War(team);
    }

    @Transactional
    public List<WarList> findLow5War(String team) {
        return warRepository.findLow5War(team);
    }

    @Transactional
    public List<RankingHistory> findRankingHistory(String team) {
        return rankingHistoryRepository.findByTeam(team);
    }

    public String findTeamName(Integer teamId) {
        if(teamId==0) {
            return "KIA";
        } else if(teamId==1) {
            return "롯데";
        } else if(teamId==2) {
            return "삼성";
        } else if(teamId==3) {
            return "두산";
        } else if(teamId==4) {
            return "LG";
        } else if(teamId==5) {
            return "SSG";
        } else if(teamId==6) {
            return "한화";
        } else if(teamId==7) {
            return "키움";
        } else if(teamId==8) {
            return "NC";
        } else if(teamId==9) {
            return "KT";
        } else {
            return "error";
        }
    }
}
