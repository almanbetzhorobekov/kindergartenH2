package api.kindergartensb.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final String DHL_API_URL = "https://autocomplete2.postdirekt.de/autocomplete2/search/de/cities";
    private final String DHL_API_KEY = "";

    @GetMapping("/cities")
    public ResponseEntity<?> getCities(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String postal_code
    ) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = DHL_API_URL + "?";
            if (query != null) {
                url += "query=" + query;
            } else if (postal_code != null) {
                url += "postal_code=" + postal_code;
            }

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + DHL_API_KEY);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            Map body = response.getBody();
            List<Map<String, String>> suggestions = (List<Map<String, String>>) body.get("suggestions");


            List<Map<String, String>> cities = suggestions.stream()
                    .map(s -> Map.of(
                            "cityName", s.get("cityName"),
                            "plz", s.get("plz")
                    ))
                    .toList();

            return ResponseEntity.ok(Map.of("cities", cities));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}