package ybo.backend.domain.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.test.domain.Text;


public interface TextRepository extends JpaRepository<Text, Long>{

}
