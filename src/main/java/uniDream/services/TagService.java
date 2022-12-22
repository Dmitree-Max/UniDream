package uniDream.services;

import uniDream.DVO.ProgramVO;
import uniDream.DVO.TagVO;
import uniDream.entities.Program;
import uniDream.entities.Tag;

import java.util.List;

public interface TagService {
    public Iterable<TagVO> getAllTags();

    Iterable<ProgramVO> findProgramsWithSuchTags(List<Integer> tags);
}
