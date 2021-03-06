package uk.co.bigdogconsultants.giflib.data;

import org.springframework.stereotype.Component;
import uk.co.bigdogconsultants.giflib.model.Gif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Steve on 27/01/2016.
 */
@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 1, LocalDate.of(2015, 2, 13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", 2, LocalDate.of(2015, 10, 30), "Ben Jakuben", true),
            new Gif("book-dominos",3,  LocalDate.of(2015, 9, 15), "Craig Dennis", false),
            new Gif("compiler-bot", 1, LocalDate.of(2015, 2, 13), "Ada Lovelace", true),
            new Gif("cowboy-coder", 2, LocalDate.of(2015, 2, 13), "Grace Hopper", false),
            new Gif("infinite-andrew", 3,LocalDate.of(2015, 8, 23), "Marissa Mayer", true)
    );

    public Gif findByName(String name){
        for(Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<Gif>();
        for(Gif gif : ALL_GIFS){
            if (gif.getCategoryId() == id) {
                gifs.add(gif);
            }
        }
        return gifs;
    }

    public List<Gif> getFavorites(){
        List<Gif> faves = new ArrayList<Gif>();
        for(Gif gif : ALL_GIFS){
            if (gif.isFavorite()){
                faves.add(gif);
            }
        }
        return faves;
    }

    public List<Gif> search(String term){
        List<Gif> searchList = new ArrayList<Gif>();
        String gifName;
        term = term.toLowerCase();
        for(Gif gif : ALL_GIFS){
            gifName = gif.getName().toLowerCase();
            if(gifName.contains(term)){
                searchList.add(gif);
            }
        }
        return searchList;
    }
}
