package data;

import android.os.AsyncTask;
import model.Document;
import view.FeedCardAdapter;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


/**
 * Created by srgopalakrishnan on 5/7/14.
 */
public class Feed extends AsyncTask<Void, Void, ArrayList<Document>> {

    private String SERVER_URL = "pit-drona.rhcloud.com/api/feed/user/bzadeh";
    private final FeedCardAdapter mFeedCardAdapter;

    public Feed(FeedCardAdapter adapter){
        mFeedCardAdapter = adapter;
    }

    private String getResponseAsString(String url){
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        HttpResponse response = null;
        String responseString = "";

        try{
            response = client.execute(get);
            HttpEntity getResponseEntity = response.getEntity();
            responseString = EntityUtils.toString(getResponseEntity,"UTF-8");

        }catch(IOException ioe){
            get.abort();
        }
        return responseString;
    }

    @Override
    protected ArrayList<Document> doInBackground(Void... params) {

        String response = getResponseAsString(SERVER_URL);
        return parseJsonResponse(response);

    }

    protected void onPostExecute(ArrayList<Document> lDocument) {
        mFeedCardAdapter.updateDocuments(lDocument);
    }

    private ArrayList<Document> parseJsonResponse(String response)
    {
        ArrayList lDocument = new ArrayList();
        Document document;
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(response).getAsJsonArray();

        for(JsonElement jsonElement: jsonArray)
        {
            lDocument.add(new Document(jsonElement.getAsJsonObject()));
        }

        return lDocument;
    }
}