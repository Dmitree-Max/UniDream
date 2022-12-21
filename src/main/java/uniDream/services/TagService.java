package uniDream.services;

import uniDream.entities.Program;
import uniDream.entities.Tag;

import java.util.List;

public interface TagService {
    public Iterable<Tag> getAllTags();

    Iterable<Program> findProgramsWithSuchTags(List<String> tags);
}
