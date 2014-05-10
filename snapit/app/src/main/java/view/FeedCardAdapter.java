package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import model.Document;
import snapit.app.R;

/**
 * Created by srgopalakrishnan on 5/8/14.
 */
public class FeedCardAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Document> lDocument = new ArrayList<Document>();


    public FeedCardAdapter(Context context){
        mContext = context;
        mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount(){
        return lDocument.size();
    }

    @Override
    public Object getItem(int position) {
        return lDocument.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateDocuments(ArrayList<Document> document) {
        lDocument = document;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout feedCardView;
        if (convertView == null){
            feedCardView = (RelativeLayout) mLayoutInflater.inflate(R.layout.feedcard, parent, false);
        }else{
            feedCardView = (RelativeLayout) convertView;
        }

        ImageView imageView = (ImageView) feedCardView.findViewById(R.id.listImage);
        TextView titleText = (TextView) feedCardView.findViewById(R.id.listTitle);
        TextView activityPostDate = (TextView) feedCardView.findViewById(R.id.listPostDate);
        TextView commentText = (TextView)feedCardView.findViewById(R.id.listComment);
        // Fetch all needed data from the Document Object


        String mediaUrl = lDocument.get(position).getMediaurl();

    System.out.println("mediaurl..."+mediaUrl);
        String subject = lDocument.get(position).getSubject();
        String activityDate = lDocument.get(position).getActivity_date();
        String comment = lDocument.get(position).getComment();
        String student = lDocument.get(position).getStudent();
        String uploadedDate = lDocument.get(position).getUploaded_date();
        String activity = lDocument.get(position).getActivity();

        // Construct the title string
        String title = subject + activity + "on" + activityDate + "posted for"+student;
        //Set post title
        titleText.setText(title);
        //set post date
        activityPostDate.setText(uploadedDate);
        //set comment
        commentText.setText(comment);

        return feedCardView;
    }
}
