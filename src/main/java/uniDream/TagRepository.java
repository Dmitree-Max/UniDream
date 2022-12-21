package uniDream;

import uniDream.entities.Program;
import uniDream.entities.Tag;
import uniDream.entities.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Integer> {
}