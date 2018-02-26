package railroad.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dnpurdy on 2/26/18.
 */
@RestController
public class SpellingRest {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/spelling")
    public Boolean checkSpelling(@RequestParam(value="word", defaultValue="") String name, @RequestParam(value="suggest", defaultValue="false") String suggest) {
        // TODO implement extra query param that when suggest is true, runs suggestion service on submitted word
        return dictionaryService.isInWordList(name);
    }
}
