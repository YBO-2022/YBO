package ybo.backend.domain.realtime.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.realtime.domain.RealtimeRanking;
import ybo.backend.domain.realtime.repository.RealtimeRankingRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class RealtimeRankingService {
    private final RealtimeRankingRepository realtimeRankingRepository;

    public List<RealtimeRanking> findAll(){
        return realtimeRankingRepository.findAll();
    }
}
