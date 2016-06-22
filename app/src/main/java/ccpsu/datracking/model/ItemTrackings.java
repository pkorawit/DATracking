package ccpsu.datracking.model;

import java.util.List;

/**
 * Created by korawit on 6/20/2016.
 */
public class ItemTrackings {

    public List<ItemTracking> getItems() {
        return items;
    }

    public void setItems(List<ItemTracking> items) {
        this.items = items;
    }

    List<ItemTracking> items;
}
