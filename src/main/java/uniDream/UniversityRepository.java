package uniDream;

import uniDream.entities.Program;
import uniDream.entities.University;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UniversityRepository extends CrudRepository<University, Integer> {

}

//public interface UniversityRepositoryCustom
//public interUniversityRepositoryCustom implements UniversityRepositoryCustom {
//
//    @Override
//    public Iterable<Program> getPrograms(String id) {
//        return null;
//    }
//}