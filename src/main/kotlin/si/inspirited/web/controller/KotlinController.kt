package si.inspirited.web.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class KotlinController {

    @GetMapping("/")
    fun blog(model:Model): String {
        model["title"] = "Blog"
        return "blog"
    }

    @GetMapping("/index")
    fun index(model:Model): String {
        model["title"] = "Blog"
        return "index"
    }

    @GetMapping("/another")
    fun another(model:Model): String {
        model["title"] = "Another"
        return "another"
    }
}