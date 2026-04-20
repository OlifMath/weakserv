package br.com.dunasdev.WeakServApi.Shared.Utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScalarController {

    @GetMapping("/docs")
    @ResponseBody
    public String scalar() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>WeakServ API</title>
            <meta charset="utf-8"/>
        </head>
        <body>
            <script
                id="api-reference"
                data-url="http://localhost:8080/v3/api-docs">
            </script>
            <script src="https://cdn.jsdelivr.net/npm/@scalar/api-reference"></script>
        </body>
        </html>
    """;
    }
}