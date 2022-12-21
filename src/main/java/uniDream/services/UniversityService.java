package uniDream.services;

import uniDream.DVO.ProgramVO;
import uniDream.DVO.UniversityVO;
import uniDream.entities.Program;
import uniDream.entities.University;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    public Iterable<UniversityVO> getAllProjects();
    public Optional<University> findById(Integer id);

    Iterable<ProgramVO> getPrograms(Integer id);
}
