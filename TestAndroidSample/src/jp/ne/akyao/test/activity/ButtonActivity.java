package jp.ne.akyao.test.activity;


import jp.ne.akyao.test.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends CommonActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        Button button = (Button) findViewById(R.id.buttonHoge);
        button.setOnClickListener(new MyOnclickListener());
    }
    
    private  class MyOnclickListener implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		Toast.makeText(ButtonActivity.this, "Clicked", Toast.LENGTH_SHORT);    	
    	}
    }
}