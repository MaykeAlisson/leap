package br.com.redesenhe.leap.adapter.out.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoogleBook {

    List<Items> items;

    public record Items(
            VolumeInfo volumeInfo
    ){}

    public record VolumeInfo(
            String title,
            List<String> authors,
            Integer pageCount,
            ImageLinks imageLinks
    ){}

    public record ImageLinks(
            String smallThumbnail,
            String thumbnail
    ){
    }
}
