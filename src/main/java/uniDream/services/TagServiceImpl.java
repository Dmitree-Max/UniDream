package uniDream.services;

import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniDream.DVO.ProgramVO;
import uniDream.TagRepository;
import uniDream.entities.Program;
import uniDream.entities.Tag;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Iterable<ProgramVO> findProgramsWithSuchTags(List<Integer> tags) {
        boolean initialized = false;
        Set<Program> matchedPrograms = new HashSet<>();
        for (Integer tagId : tags) {
            Optional<Tag> tag = tagRepository.findById(tagId);
            if (tag.isEmpty()) {
                return null;
            }
            if (!initialized) {
                initialized = true;
                matchedPrograms = tag.get().getPrograms();
            } else {
                matchedPrograms.retainAll(tag.get().getPrograms());
            }
        }
        return matchedPrograms.stream()
                .map(x -> x.getVO()).toList();
    }
}