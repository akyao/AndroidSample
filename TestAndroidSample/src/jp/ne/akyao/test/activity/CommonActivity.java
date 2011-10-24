package jp.ne.akyao.test.activity;


import jp.ne.akyao.test.R;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class CommonActivity extends Activity {
	
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
			startActivity(ContactsActivity.class);
			break;
		case R.id.button:
			startActivity(ButtonActivity.class);
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private void startActivity (Class<?> cls){
		Intent intent = new Intent(this, cls);
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);
	}

}