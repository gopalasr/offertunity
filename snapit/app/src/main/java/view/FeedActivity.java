package view;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;

import java.io.Serializable;

import data.Feed;
import model.Document;
import snapit.app.R;

public class FeedActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);

        final FeedCardAdapter feedcardAdapter = new FeedCardAdapter(this);
        setListAdapter(feedcardAdapter);

        Feed feed = new Feed(feedcardAdapter);
        feed.execute();

        ImageButton refreshButton = (ImageButton)findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                System.out.println("Button Clicked");
                new Feed(feedcardAdapter).execute();
            }
        });

        ListView feedActivityList = (ListView) findViewById(android.R.id.list);
        feedActivityList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("List Item Clicked");
                Document document = (Document) parent.getItemAtPosition(position);
                //Intent myIntent = new Intent(ChallengesList.this, Challengeview.class);
                //ChallengesList.this.startActivity(myIntent);
                Intent i = new Intent(getApplicationContext(), ImageActivity.class);
                //i.putExtra("object",document);
                i.putExtra("documentobject", document);
                startActivity(i);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
