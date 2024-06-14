package ru.sberbank.jd.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.input.Cd;
import ru.sberbank.jd.lesson10.output.Album;
import ru.sberbank.jd.lesson10.output.Artist;
import ru.sberbank.jd.lesson10.output.Country;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Преобразование к новому формату.
 */
public class TransformationData {
    /**
     * Преобоазование каталога кновому формату.
     *
     * @param catalog Каталог
     * @return Реестр
     */
    public Registry convertToRegistry(Catalog catalog) {
        List<Country> countries = new ArrayList<>();

        Map<String, List<Cd>> cdListByCountry = catalog.getCds().stream()
                .collect(Collectors.groupingBy(Cd::getCountry, Collectors.toList()));

        for (Map.Entry<String, List<Cd>> entryCountry : cdListByCountry.entrySet()) {

            List<Artist> listArtists = new ArrayList<>();

            Map<String, List<Cd>> cdListByArtist = entryCountry.getValue().stream()
                    .collect(Collectors.groupingBy(Cd::getArtist, Collectors.toList()));

            for (Map.Entry<String, List<Cd>> entryArtist : cdListByArtist.entrySet()) {

                List<Album> album = new ArrayList<>();

                List<Cd> listAlbumFromArtist = entryArtist.getValue();

                for (Cd cdAlb : listAlbumFromArtist) {
                    album.add(new Album(cdAlb.getTitle(), cdAlb.getYear()));
                }

                listArtists.add(new Artist(entryArtist.getKey(), album));
            }
            countries.add(new Country(entryCountry.getKey(), listArtists));
        }
        return new Registry(countries);
    }
}
