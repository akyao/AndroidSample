package jp.ne.akyao.test.activity;


import java.io.InputStream;
import java.net.URL;

import jp.ne.akyao.test.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class WebImageActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_image);
        
        try {
        	//‰æ‘œ‚ÌŽæ“¾
			URL url = new URL("http://farm1.static.flickr.com/115/buddyicons/75238209@N00.jpg?1174741160#75238209@N00");
			InputStream stream = (InputStream) url.getContent();
			Drawable drawable = Drawable.createFromStream(stream, "");
			stream.close();
			
			//‰æ‘œ‚ð“\‚é
			ImageView img = (ImageView) findViewById(R.id.webImageImg); 	
			img.setImageDrawable(drawable);
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}