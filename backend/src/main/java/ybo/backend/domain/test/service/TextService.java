package ybo.backend.domain.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.test.domain.Text;
import ybo.backend.domain.test.repository.TextRepository;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class TextService {
    private final TextRepository textRepository;

    @Transactional
    public Text save(Text text) {
        return textRepository.save(text);
    }

    public List<Text> findAll(){
        return textRepository.findAll();
    }
}
