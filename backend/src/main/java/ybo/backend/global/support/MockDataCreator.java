package ybo.backend.global.support;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;
import ybo.backend.domain.players.repository.HitterRepository;
import ybo.backend.domain.players.repository.PitcherRepository;

@Component
@Transactional
@Profile({"test", "local"})
@Slf4j
public class MockDataCreator implements CommandLineRunner {

    @Autowired HitterRepository hitterRepository;
    @Autowired PitcherRepository pitcherRepository;

    @Override
    public void run(String... args) throws Exception {
        createMockPlayers();
    }

    private void createMockPlayers(){
        hitterRepository.save(Hitter.createHitter("이정후", "키움", 1.003f, 139, 611, 0.351f, 189, 23,
                113, 3, 31, 10, 9.08f, 0.422f, 0.581f));
        hitterRepository.save(Hitter.createHitter("피렐라", "삼성", 0.972f, 134, 599, 0.341f, 181, 27,
                104, 15, 77, 18, 6.96f, 0.412f, 0.559f));
        hitterRepository.save(Hitter.createHitter("나성범", "KIA", 0.92f, 137, 620, 0.318f, 170, 21,
                96, 6, 132, 6, 6.35f, 0.405f, 0.515f));
        hitterRepository.save(Hitter.createHitter("최정", "SSG", 0.915f, 117, 487, 0.275f, 110, 26,
                87, 12, 92, 6, 5.34f, 0.392f, 0.523f));
        hitterRepository.save(Hitter.createHitter("오지환", "LG", 0.816f, 134, 543, 0.261f, 120, 25,
                84, 20, 103, 11, 5.27f, 0.348f, 0.468f));
        hitterRepository.save(Hitter.createHitter("소크라테스", "KIA", 0.866f, 121, 527, 0.318f, 155, 16,
                71, 13, 79, 10, 5.04f, 0.362f, 0.503f));
        hitterRepository.save(Hitter.createHitter("김혜성", "키움", 0.78f, 126, 551, 0.319f, 160, 4,
                47, 34, 83, 9, 4.79f, 0.374f, 0.406f));
        hitterRepository.save(Hitter.createHitter("최지훈", "SSG", 0.792f, 138, 620, 0.304f, 168, 10,
                61, 29, 75, 7, 4.75f, 0.363f, 0.429f));
        hitterRepository.save(Hitter.createHitter("김현수", "LG", 0.851f, 133, 577, 0.282f, 141, 23,
                104, 2, 60, 5, 4.7f, 0.373f, 0.478f));
        hitterRepository.save(Hitter.createHitter("터크먼", "한화", 0.794f, 139, 624, 0.29f, 162, 12,
                41, 18, 102, 12, 4.67f, 0.362f, 0.432f));

        pitcherRepository.save(Pitcher.createPitcher("안우진", "키움", 2.26f, 6.82f, 14, 8,
                0, 0, 183f, 51, 46, 124, 4, 54, 212));
        pitcherRepository.save(Pitcher.createPitcher("김광현", "SSG", 1.99f, 6.19f, 13, 2,
                0, 0, 167.1f, 44, 37, 135, 9, 44, 145));
        pitcherRepository.save(Pitcher.createPitcher("요키시", "키움", 2.56f,5.52f, 10, 8,
                0, 0, 179.1f, 59, 51, 165, 8, 31, 151));
        pitcherRepository.save(Pitcher.createPitcher("고영표", "KT", 2.94f, 5.04f, 13, 7,
                0, 0, 174.1f, 60, 57, 177, 7, 23, 148));
        pitcherRepository.save(Pitcher.createPitcher("폰트", "SSG", 2.8f, 4.88f, 13, 6,
                0, 0, 177f, 62, 55, 138, 18, 32, 162));
        pitcherRepository.save(Pitcher.createPitcher("켈리", "LG", 2.59f, 4.86f, 15, 4,
                0, 0, 159.2f, 49, 46, 138, 10, 32, 148));
        pitcherRepository.save(Pitcher.createPitcher("플럿코", "LG", 2.39f, 4.72f, 15, 5,
                0, 0, 162f, 53, 43, 125, 13, 38, 149));
        pitcherRepository.save(Pitcher.createPitcher("수아레즈", "삼성", 2.62f, 4.55f, 5, 8,
                0, 0, 161.1f, 60, 47, 142, 7, 49, 149));
        pitcherRepository.save(Pitcher.createPitcher("소형준", "KT", 3.08f, 4.39f, 13, 5,
                0, 0, 166.1f, 64, 57, 151, 7, 38, 114));
        pitcherRepository.save(Pitcher.createPitcher("루친스키", "NC", 3.07f, 3.89f, 9, 12,
                0, 0, 187.2f, 77, 64, 179, 14, 33, 186));

    }


}