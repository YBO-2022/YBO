package ybo.backend.domain.players.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;
import ybo.backend.domain.players.repository.HitterRepository;
import ybo.backend.domain.players.repository.PitcherRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class PlayerService {
    private final PitcherRepository pitcherRepository;
    private final HitterRepository hitterRepository;

    // 전체 투수 ERA 순
    public List<Pitcher> findAllPitchersERA(){
        return pitcherRepository.findAll(Sort.by(Sort.Direction.ASC, "era"));
    }

    // 다승(내림)
    public List<Pitcher> findTop3Win() {return pitcherRepository.findTop3ByOrderByWinDesc();}

    // 방어율(오름)
    public List<Pitcher> findTop3Era() {
        return pitcherRepository.findTop3ByOrderByEraAsc();
    }

    // 자책(오름)
    public List<Pitcher> findTop3EarnedRun() { return pitcherRepository.findTop3ByOrderByEarnedRunAsc(); }

    // 세이브(내림)
    public List<Pitcher> findTop3Save() {
        return pitcherRepository.findTop3ByOrderBySaveDesc();
    }

    // 홀드(내림)
    public List<Pitcher> findTop3Hold() {
        return pitcherRepository.findTop3ByOrderByHoldDesc();
    }

    // 삼진(내림)
    public List<Pitcher> findTop3Strikeout() {
        return pitcherRepository.findTop3ByOrderByStrikeoutDesc();
    }

    // 전체 타자 OPS 순
    public List<Hitter> findAllHittersOPS(){return hitterRepository.findAll(Sort.by(Sort.Direction.DESC, "ops"));}

    // 타율순(내림)
    public List<Hitter> findTop3Ba() {
        return hitterRepository.findTop3ByOrderByBaDesc();
    }

    // 출루율(내림)
    public List<Hitter> findTop3Obp() {
        return hitterRepository.findTop3ByOrderByObpDesc();
    }

    // 장타율(내림)
    public List<Hitter> findTop3Slg() {
        return hitterRepository.findTop3ByOrderBySlgDesc();
    }

    // 타점(내림)
    public List<Hitter> findTop3Rbi() {
        return hitterRepository.findTop3ByOrderByRbiDesc();
    }

    // 홈런(내림)
    public List<Hitter> findTop3Homerun() {
        return hitterRepository.findTop3ByOrderByHomerunDesc();
    }

    // 도루(내림)
    public List<Hitter> findTop3Steal() {
        return hitterRepository.findTop3ByOrderByStealDesc();
    }
}