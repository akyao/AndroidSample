package jp.ne.akyao.test.activity;


import jp.ne.akyao.test.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsActivity extends Activity {
	
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
			break;
		case R.id.button:
			Intent intent = new Intent(this, ButtonActivity.class);
			intent.setAction(Intent.ACTION_VIEW);
			startActivity(intent);
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        
        Cursor cursor = managedQuery(ContactsContract.Contacts.CONTENT_URI,
        		null, null, null, ContactsContract.Contacts._ID + " desc");
        
        int count = 0;
        while(cursor.moveToNext()){
        	//1コンタクトごとにループ
        	
        	//電話帳全件回すとエラーが発生するので、件数制限
        	count++;
        	if(count > 20){
        		break;
        	}
        	
        	//コンタクトのIDと表示名を取得
        	String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        	String name = cursor.getString(cursor.getColumnIndex("display_name"));
        	String strContact = id + " " + name;
        	
        	//電話番号を取得
        	String phones = fetch(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        			ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
        			ContactsContract.CommonDataKinds.Phone.NUMBER);
        	strContact = strContact + phones;
        	
        	//Email情報を取得
        	String emails = fetch(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
        			ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + id,
        			ContactsContract.CommonDataKinds.Email.DATA);
        	strContact = strContact + emails;
        	
        	adapter.add(strContact);
        }
        cursor.close();
        
        ListView listview = (ListView) findViewById(R.id.listview);
        
        listview.setAdapter(adapter);
    }
    
    private String fetch(Uri uri, String selection, String columnName){
    	Cursor emails = managedQuery(uri,
    			null,
    			selection,
    			null,
    			null);
    	
    	String content = "";
    	while(emails.moveToNext()){
    		String data = emails.getString(emails.getColumnIndex(columnName));
    		content = content + "/n" + data;
    	}
    	
    	emails.close();
    	return content;
    }
}