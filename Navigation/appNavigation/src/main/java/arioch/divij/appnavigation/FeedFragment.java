package arioch.divij.appnavigation;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divijdurve on 4/15/14.
 */
public class FeedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_list_view, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new FeedAdapter());

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.add("contentType", "application/json");
        client.get(this.getActivity(), "http://snapit-drona.rhcloud.com/api/feed/user/bzadeh", requestParams, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response) {
                Log.d("Response", response);
                FeedFragment.this.parseJsonResponse(response);
            }
        });

        return view;
    }

    private void parseJsonResponse(String response)
    {
        JsonParser jsonParser = new JsonParser();

        JsonArray jsonArray = jsonParser.parse(response).getAsJsonArray();

        ListView listView = (ListView) this.getView().findViewById(R.id.listView);

        FeedAdapter feedAdapter;
        feedAdapter = (FeedAdapter) listView.getAdapter();

        for(JsonElement jsonElement: jsonArray)
        {
            feedAdapter.feedItems.add(new FeedItem(jsonElement.getAsJsonObject()));
        }
        feedAdapter.notifyDataSetChanged();
        this.getView().findViewById(R.id.progressbar).setVisibility(View.GONE);
    }

    public class FeedAdapter extends BaseAdapter {

        List<FeedItem> feedItems;

        public List<FeedItem> getFeedItems() {
            return feedItems;
        }

        public void setFeedItems(List<FeedItem> feedItems) {
            this.feedItems = feedItems;
        }

        public FeedAdapter()
        {
            this.feedItems = new ArrayList<FeedItem>();
        }

        @Override
        public int getCount() {
            return feedItems.size();
        }

        @Override
        public Object getItem(int i) {
            return feedItems.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View viewFeedRow;
            viewFeedRow = FeedFragment.this.getActivity().getLayoutInflater().inflate(R.layout.feed_row, viewGroup, false);

            ImageView imageView = (ImageView) viewFeedRow.findViewById(R.id.imageViewDocument);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.init(ImageLoaderConfiguration.createDefault(FeedFragment.this.getActivity().getApplicationContext()));
            imageLoader.displayImage(this.feedItems.get(position).getMediaUrl(), imageView);

            TextView textViewActivityType = (TextView) viewFeedRow.findViewById(R.id.textViewActivityType);
            textViewActivityType.setText(this.feedItems.get(position).getActivityType().toString());

            TextView textViewActivityDate = (TextView) viewFeedRow.findViewById(R.id.textViewActivityType);
            textViewActivityDate.setText(this.feedItems.get(position).getActivityDate());

            TextView textViewUploadedBy = (TextView) viewFeedRow.findViewById(R.id.textViewUploadedBy);
            textViewUploadedBy.setText(this.feedItems.get(position).getUploadedBy());

            TextView textViewSubject = (TextView) viewFeedRow.findViewById(R.id.textViewSubject);
            textViewSubject.setText(this.feedItems.get(position).getSubject());


            return viewFeedRow;
        }
    }
}
