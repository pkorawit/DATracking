package ccpsu.datracking.restapi;

import ccpsu.datracking.model.ItemTracking;
import ccpsu.datracking.model.ItemTrackings;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ItemTrackingAPI {

    @GET("ItemTrackings/")
    Call<ItemTracking> getTrackingInfo(@Query("id") String id);

    @GET("ItemTrackings/")
    Call<ItemTracking[]> getAllTrackingInfo();

}