package ybo.backend.global.support;


import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.goldenglove.domain.EraPredict;
import ybo.backend.domain.goldenglove.domain.OpsPredict;
import ybo.backend.domain.goldenglove.domain.SquadPredict;
import ybo.backend.domain.goldenglove.repository.EraPredictRepository;
import ybo.backend.domain.goldenglove.repository.OpsPredictRepository;
import ybo.backend.domain.goldenglove.repository.SquadPredictRepository;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;
import ybo.backend.domain.players.repository.HitterRepository;
import ybo.backend.domain.players.repository.PitcherRepository;
import ybo.backend.domain.realtime.domain.RealtimeGame;
import ybo.backend.domain.realtime.domain.RealtimeRanking;
import ybo.backend.domain.realtime.repository.RealtimeGameRepository;
import ybo.backend.domain.realtime.repository.RealtimeRankingRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@Profile({"test", "local"})
@Slf4j
public class MockDataCreator implements CommandLineRunner {

    @Autowired HitterRepository hitterRepository;
    @Autowired PitcherRepository pitcherRepository;
    @Autowired EraPredictRepository eraPredictRepository;
    @Autowired OpsPredictRepository opsPredictRepository;
    @Autowired SquadPredictRepository squadPredictRepository;
    @Autowired RealtimeGameRepository realtimeGameRepository;
    @Autowired RealtimeRankingRepository realtimeRankingRepository;

    @Override
    public void run(String... args) throws Exception {
        createMockGoldenGloves();
        createMockPlayers();
        createMockRealtimes();
    }

    private void createMockGoldenGloves() {
        List<EraPredict> eraPredicts = new ArrayList<>();
        eraPredicts.add(EraPredict.createEraPredict("고우석", "LG", 1.55f, 1.64383f));
        eraPredicts.add(EraPredict.createEraPredict("김광현", "SSG", 1.99f, 1.94614f));
        eraPredicts.add(EraPredict.createEraPredict("김재웅", "키움", 1.94f, 1.9635f));
        eraPredicts.add(EraPredict.createEraPredict("구창모", "NC", 1.96f, 2.08838f));
        eraPredicts.add(EraPredict.createEraPredict("김민수", "KT", 1.93f, 2.09459f));
        eraPredicts.add(EraPredict.createEraPredict("모리만도", "SSG", 1.84f, 2.11614f));
        eraPredicts.add(EraPredict.createEraPredict("이용찬", "NC", 2.06f, 2.22305f));
        eraPredicts.add(EraPredict.createEraPredict("이채호", "KT", 2.34f, 2.32576f));
        eraPredicts.add(EraPredict.createEraPredict("파노니", "KIA", 2.11f, 2.35971f));
        eraPredicts.add(EraPredict.createEraPredict("이우찬", "LG", 2.08f, 2.37001f));
        eraPredictRepository.saveAll(eraPredicts);

        List<OpsPredict> opsPredicts = new ArrayList<>();
        opsPredicts.add(OpsPredict.createOpsPredict("이정후", "키움", 1.003f, 1.018f));
        opsPredicts.add(OpsPredict.createOpsPredict("피렐라", "삼성", 0.972f, 0.975127f));
        opsPredicts.add(OpsPredict.createOpsPredict("김민혁", "두산", 0.917f, 0.933632f));
        opsPredicts.add(OpsPredict.createOpsPredict("렉스", "롯데", 0.927f, 0.92405f));
        opsPredicts.add(OpsPredict.createOpsPredict("나성범", "KIA", 0.92f, 0.92214f));
        opsPredicts.add(OpsPredict.createOpsPredict("최정", "SSG", 0.915f, 0.920978f));
        opsPredicts.add(OpsPredict.createOpsPredict("박병호", "KT", 0.894f, 0.905984f));
        opsPredicts.add(OpsPredict.createOpsPredict("박건우", "NC", 0.881f, 0.885446f));
        opsPredicts.add(OpsPredict.createOpsPredict("양의지", "NC", 0.873f, 0.876812f));
        opsPredicts.add(OpsPredict.createOpsPredict("이대호", "롯데", 0.876f, 0.873079f));
        opsPredictRepository.saveAll(opsPredicts);

        List<SquadPredict> squadPredicts = new ArrayList<>();
        squadPredicts.add(SquadPredict.createSquadPredict("박병호", "KT", "1B"));
        squadPredicts.add(SquadPredict.createSquadPredict("김혜성", "키움", "2B"));
        squadPredicts.add(SquadPredict.createSquadPredict("최정", "SSG", "3B"));
        squadPredicts.add(SquadPredict.createSquadPredict("양의지", "NC", "C"));
        squadPredicts.add(SquadPredict.createSquadPredict("이정후", "키움", "CF"));
        squadPredicts.add(SquadPredict.createSquadPredict("이대호", "롯데", "DH"));
        squadPredicts.add(SquadPredict.createSquadPredict("피렐라", "삼성", "LF"));
        squadPredicts.add(SquadPredict.createSquadPredict("안우진", "키움", "P"));
        squadPredicts.add(SquadPredict.createSquadPredict("나성범", "KIA", "RF"));
        squadPredicts.add(SquadPredict.createSquadPredict("오지환", "LG", "SS"));
        squadPredicts.add(SquadPredict.createSquadPredict("배재준", "LG", "P"));
        squadPredictRepository.saveAll(squadPredicts);
    }

    private void createMockPlayers(){
        List<Hitter> hitters = new ArrayList<>();
        hitters.add(Hitter.createHitter("이정후", "키움", 1.003f, 139, 611, 0.351f, 189, 23,
                113, 3, 31, 10, 9.08f, 0.422f, 0.581f));
        hitters.add(Hitter.createHitter("피렐라", "삼성", 0.972f, 134, 599, 0.341f, 181, 27,
                104, 15, 77, 18, 6.96f, 0.412f, 0.559f));
        hitters.add(Hitter.createHitter("나성범", "KIA", 0.92f, 137, 620, 0.318f, 170, 21,
                96, 6, 132, 6, 6.35f, 0.405f, 0.515f));
        hitters.add(Hitter.createHitter("최정", "SSG", 0.915f, 117, 487, 0.275f, 110, 26,
                87, 12, 92, 6, 5.34f, 0.392f, 0.523f));
        hitters.add(Hitter.createHitter("오지환", "LG", 0.816f, 134, 543, 0.261f, 120, 25,
                84, 20, 103, 11, 5.27f, 0.348f, 0.468f));
        hitters.add(Hitter.createHitter("소크라테스", "KIA", 0.866f, 121, 527, 0.318f, 155, 16,
                71, 13, 79, 10, 5.04f, 0.362f, 0.503f));
        hitters.add(Hitter.createHitter("김혜성", "키움", 0.78f, 126, 551, 0.319f, 160, 4,
                47, 34, 83, 9, 4.79f, 0.374f, 0.406f));
        hitters.add(Hitter.createHitter("최지훈", "SSG", 0.792f, 138, 620, 0.304f, 168, 10,
                61, 29, 75, 7, 4.75f, 0.363f, 0.429f));
        hitters.add(Hitter.createHitter("김현수", "LG", 0.851f, 133, 577, 0.282f, 141, 23,
                104, 2, 60, 5, 4.7f, 0.373f, 0.478f));
        hitters.add(Hitter.createHitter("터크먼", "한화", 0.794f, 139, 624, 0.29f, 162, 12,
                41, 18, 102, 12, 4.67f, 0.362f, 0.432f));
        hitterRepository.saveAll(hitters);

        List<Pitcher> pitchers = new ArrayList<>();
        pitchers.add(Pitcher.createPitcher("안우진", "키움", 2.26f, 6.82f, 14, 8,
                0, 0, 183f, 51, 46, 124, 4, 54, 212));
        pitchers.add(Pitcher.createPitcher("김광현", "SSG", 1.99f, 6.19f, 13, 2,
                0, 0, 167.1f, 44, 37, 135, 9, 44, 145));
        pitchers.add(Pitcher.createPitcher("요키시", "키움", 2.56f,5.52f, 10, 8,
                0, 0, 179.1f, 59, 51, 165, 8, 31, 151));
        pitchers.add(Pitcher.createPitcher("고영표", "KT", 2.94f, 5.04f, 13, 7,
                0, 0, 174.1f, 60, 57, 177, 7, 23, 148));
        pitchers.add(Pitcher.createPitcher("폰트", "SSG", 2.8f, 4.88f, 13, 6,
                0, 0, 177f, 62, 55, 138, 18, 32, 162));
        pitchers.add(Pitcher.createPitcher("켈리", "LG", 2.59f, 4.86f, 15, 4,
                0, 0, 159.2f, 49, 46, 138, 10, 32, 148));
        pitchers.add(Pitcher.createPitcher("플럿코", "LG", 2.39f, 4.72f, 15, 5,
                0, 0, 162f, 53, 43, 125, 13, 38, 149));
        pitchers.add(Pitcher.createPitcher("수아레즈", "삼성", 2.62f, 4.55f, 5, 8,
                0, 0, 161.1f, 60, 47, 142, 7, 49, 149));
        pitchers.add(Pitcher.createPitcher("소형준", "KT", 3.08f, 4.39f, 13, 5,
                0, 0, 166.1f, 64, 57, 151, 7, 38, 114));
        pitchers.add(Pitcher.createPitcher("루친스키", "NC", 3.07f, 3.89f, 9, 12,
                0, 0, 187.2f, 77, 64, 179, 14, 33, 186));

        pitcherRepository.saveAll(pitchers);
    }

    private void createMockRealtimes() {
        List<RealtimeGame> realtimeGames = new ArrayList<>();
        realtimeGames.add(RealtimeGame.createRealTimeGame("시작 전", "SSG", "KIA",
                0, 0, "17:00", "모리만도", "양현종"));
        realtimeGames.add(RealtimeGame.createRealTimeGame("시작 전", "두산", "심성",
                0, 0, "17:00", "곽빈", "수아레즈"));
        realtimeGames.add(RealtimeGame.createRealTimeGame("시작 전", "NC", "LG",
                0, 0, "17:00", "더모디", "배재준"));
        realtimeGames.add(RealtimeGame.createRealTimeGame("시작 전", "KT", "롯데",
                0, 0, "17:00", "소형준", "반즈"));
        realtimeGames.add(RealtimeGame.createRealTimeGame("시작 전", "키움", "한화",
                0, 0, "17:00", "안우진", "장민재"));
        realtimeGameRepository.saveAll(realtimeGames);

        List<RealtimeRanking> realtimeRankings = new ArrayList<>();
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("SSG", 1, 139,
                87, 48, 4, 0.644f, 0f, "1승"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("LG", 2, 136,
                84, 50, 2, 0.627f, 2.5f, "1승"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("KT", 3, 138,
                77, 59, 2, 0.566f, 10.5f, "4승"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("키움", 4, 142,
                79, 61, 2, 0.564f, 10.5f, "1패"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("KIA", 5, 137,
                66, 70, 1, 0.485f, 21.5f, "3승"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("NC", 6, 137,
                62, 72, 3, 0.463f, 24.5f, "2패"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("삼성", 7, 138,
                62, 74, 4, 0.456f, 25.5f, "2승"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("롯데", 7, 140,
                62, 74, 4, 0.456f, 25.5f, "1승"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("두산", 9, 137,
                57, 78, 2, 0.422f, 30f, "1패"));
        realtimeRankings.add(RealtimeRanking.createRealtimeRanking("한화", 10, 140,
                44, 94, 2, 0.319f, 44.5f, "5패"));
        realtimeRankingRepository.saveAll(realtimeRankings);
    }

}