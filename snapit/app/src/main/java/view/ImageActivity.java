package view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.MotionEvent;

import data.ImageDownloader;
import model.Document;

import snapit.app.R;

/**
 * Created by srgopalakrishnan on 5/11/14.
 */
public class ImageActivity extends Activity {
    private final ImageDownloader mImageDownloader = new ImageDownloader();
    private static final int SWIPE_THRESHOLD = 100;
    private float _downX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        Bundle extras = getIntent().getExtras();
        Document document = (Document)extras.getParcelable("documentobject");
        ImageView imageview = (ImageView)findViewById(R.id.imageView);
        String mediaUrl = document.getMediaurl();

        System.out.println("mediaurl..."+mediaUrl);
        mImageDownloader.setMode(ImageDownloader.Mode.CORRECT);
        mImageDownloader.download(mediaUrl, imageview);
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt) {
        switch(evt.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _downX = evt.getX();
            case MotionEvent.ACTION_UP:
                float deltaX = evt.getX() - _downX;

                if(Math.abs(deltaX) > SWIPE_THRESHOLD && deltaX < 0)
                    onLeftSwipe();
        }

        return true;
    }

    public void onLeftSwipe(){
        finish();
    }
}
