package hust.soict.globalict.lab08.ver2.utils.comparator;

import hust.soict.globalict.lab08.ver2.model.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitleCategory implements Comparator<Media> {
    // Sort by cost: the system the system displays all the DVDs in DECREASING cost order.
    // In case they have the same cost,
    // the DVDs will be ordered by alphabet sequence by title
    @Override
    public int compare(Media o1, Media o2) {
        if (o1.getCost() != o2.getCost()){
            return (int) (o2.getCost() - o1.getCost());
        }

        if (!o1.getTitle().equals(o2.getTitle())){
            return o1.getTitle().compareTo(o2.getTitle());
        }

        if(!o1.getCategory().equals(o2.getCategory())){
            return o1.getCategory().compareTo(o2.getCategory());
        }

        return 0;
    }
}
