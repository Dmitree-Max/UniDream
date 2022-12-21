package uniDream.services;
import org.assertj.core.util.Streams;
import uniDream.DVO.ProgramVO;
import uniDream.DVO.UniversityVO;
import uniDream.entities.Program;
import uniDream.entities.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniDream.UniversityRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;


    @Override
    public Iterable<UniversityVO> getAllProjects() {
        return Streams.stream(universityRepository.findAll())
                .map(x -> x.getVO()).toList();
    }

    @Override
    public Optional<University> findById(Integer id) {
        return universityRepository.findById(Integer.valueOf(id));
    }

    @Override
    public Iterable<ProgramVO> getPrograms(Integer id) {
        Optional<University> university = findById(id);
        if (university.isEmpty()) {
            return (Iterable<ProgramVO>) Collections.emptyIterator();
        }

        return Streams.stream(university.get().getProgram())
                .map(x -> x.getVO()).toList();
    }
}

