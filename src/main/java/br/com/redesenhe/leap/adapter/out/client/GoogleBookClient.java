package br.com.redesenhe.leap.adapter.out.client;

import br.com.redesenhe.leap.adapter.out.client.model.GoogleBook;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleBook", url = "https://www.googleapis.com/books/v1/volumes")
public interface GoogleBookClient {
    @GetMapping
    GoogleBook findByName(@RequestParam(value="q") String quey);
}
