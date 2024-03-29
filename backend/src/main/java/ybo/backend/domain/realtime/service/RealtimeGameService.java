package ybo.backend.domain.realtime.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.realtime.domain.RealtimeGame;
import ybo.backend.domain.realtime.repository.RealtimeGameRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class RealtimeGameService {
    private final RealtimeGameRepository realtimeGameRepository;

    public List<RealtimeGame> findAll(){
        return realtimeGameRepository.findAll();
    }

}
