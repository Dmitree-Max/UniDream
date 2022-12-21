package uniDream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.server.ResponseStatusException;
import uniDream.DVO.ProgramVO;
import uniDream.DVO.UniversityVO;
import uniDream.entities.Program;
import uniDream.entities.Tag;
import uniDream.entities.University;
import uniDream.services.UniversityService;
import uniDream.services.TagService;
import uniDream.services.UniversityServiceImpl;
import uniDream.services.TagServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/v0") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired
    UniversityService universityService;

    @Autowired
    TagService tagService;


    @GetMapping(path = "/universities")
    public @ResponseBody Iterable<UniversityVO> getUniversities() {
        // This returns a JSON or XML with the universities
        return universityService.getAllProjects();
    }

    @GetMapping(path = "/university")
    public @ResponseBody Iterable<ProgramVO> getAllPrograms(@RequestParam String id) {
        // This returns a JSON or XML with programs of the university
        Iterable<ProgramVO> programs = universityService.getPrograms(Integer.valueOf(id));

        if (programs == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "wrong university id"
            );
        }

        return programs;
    }

    @GetMapping(path = "/programs")
    public @ResponseBody Iterable<ProgramVO> getProgramsByTags(@RequestParam List<Integer> tags) {
        // This returns a JSON or XML with the programs by tags
        Iterable<ProgramVO> result = tagService.findProgramsWithSuchTags(tags);
        // #TO DO fix to exceptions
        if (result == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "wrong tag"
            );
        }

        return result;
    }

    @GetMapping(path = "/tags")
    public @ResponseBody Iterable<Tag> getTags() {
        // This returns a JSON or XML with the all tags
        return tagService.getAllTags();
    }
}

