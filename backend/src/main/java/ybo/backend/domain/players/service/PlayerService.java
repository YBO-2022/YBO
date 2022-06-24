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

    @Transactional
    public List<Pitcher> findAllPitchersERA(){
        return pitcherRepository.findAll(Sort.by(Sort.Direction.ASC, "era"));
    }

    @Transactional
    public List<Hitter> findAllHittersOPS(){

        return hitterRepository.findAll(Sort.by(Sort.Direction.DESC, "ops"));
    }
}