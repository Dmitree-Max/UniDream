package uniDream.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniDream.TagRepository;
import uniDream.entities.Program;
import uniDream.entities.Tag;

import java.util.Collections;
import java.util.List;

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
    public Iterable<Program> findProgramsWithSuchTags(List<String> tags) {
        return (Iterable<Program>) Collections.emptyIterator();
    }
}