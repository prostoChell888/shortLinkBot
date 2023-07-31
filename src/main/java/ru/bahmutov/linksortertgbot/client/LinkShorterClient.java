package ru.bahmutov.linksortertgbot.client;

import dto.UrlMappingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "client", url = "http://26.143.183.5:8080")
public interface LinkShorterClient {

    @PostMapping("/short")
    String redirectToPageToOriginalUrl(UrlMappingDTO urlMappingDTO);


}
