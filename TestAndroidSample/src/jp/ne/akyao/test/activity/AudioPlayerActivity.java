package jp.ne.akyao.test.activity;


import jp.ne.akyao.test.R;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * ‰¹‚Í‚±‚¿‚ç‚Å‚¢‚½‚¾‚«‚Ü‚µ‚½
 * http://homepage1.nifty.com/PICCOLO/P-2-49.htm
 * 
 * @author akyao
 *
 */
public class AudioPlayerActivity extends CommonActivity {
	
	private MediaPlayer mediaPlayer;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_player);

        mediaPlayer = MediaPlayer.create(this, R.raw.air);
        mediaPlayer.start();
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	mediaPlayer.release();
    }
}