package hust.soict.globalict.lab08.ver2.utils.comparator;

import hust.soict.globalict.lab08.ver2.model.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCategoryCost implements Comparator<Media> {
    // Sort by title: the system displays all the
    // DVDs in the alphabet sequence by title.
    // In case they have the same title,
    // the DVDs having the higher cost will be displayed first.

    @Override
    public int compare(Media o1, Media o2) {

        if (!o1.getTitle().equalsIgnoreCase(o2.getTitle())){
            return o1.getTitle().toLowerCase().compareTo(o2.getTitle().toLowerCase());
        }

        if(!o1.getCategory().equalsIgnoreCase(o2.getCategory())){
            return o1.getCategory().toLowerCase().compareTo(o2.getCategory().toLowerCase());
        }

        if (o1.getCost() != o2.getCost()){
            return (int) (o1.getCost() - o2.getCost());
        }

        return 0;
    }
}
