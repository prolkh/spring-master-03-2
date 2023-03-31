package spring.springmaster032.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * Convenient shorthand annotation (View code)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * Using PathVariable
     * If the variable name is the same, it can be omitted
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId = {}", userId);
        return "ok";
    }

    /**
     * Using Multiple PathVariable
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    /**
     * Additional mapping with a parameter
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode!=debug"
     * params = {"mode=debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * Additional mapping with a specific header
     * headers = "mode"
     * headers = "!mode"
     * headers = "mode=debug"
     * headers = "mode!=debug"
     */
    @GetMapping(value = "/mapping-header", params = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Mapping based on the 'Content-Type' header media type
     * consumes = "application/json"
     * consumes = "!application/json"
     * consumes = "application/*"
     * consumes = "*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @GetMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Media type based on the 'Accept' header
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @GetMapping(value = "/mapping-produce", consumes = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
