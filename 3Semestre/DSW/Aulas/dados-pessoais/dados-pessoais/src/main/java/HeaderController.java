
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

class HeaderController {

    @GetMapping("/header/user-agent")
    public String obterUserAgent(@RequestHeader("User-agent") String userAgent) {
        return userAgent;
    }
}
