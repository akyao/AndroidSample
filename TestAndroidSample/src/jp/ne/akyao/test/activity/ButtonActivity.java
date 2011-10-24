package jp.ne.akyao.test.activity;


import jp.ne.akyao.test.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends Activity {
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.contacts:
			Intent intent = new Intent(this, ContactsActivity.class);
			intent.setAction(Intent.ACTION_VIEW);
			startActivity(intent);
			break;
		case R.id.button:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
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