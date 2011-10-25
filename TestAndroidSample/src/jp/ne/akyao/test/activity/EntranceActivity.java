package jp.ne.akyao.test.activity;


import java.util.ArrayList;
import java.util.List;

import jp.ne.akyao.test.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class EntranceActivity extends Activity {
	
	List<OreValuePair> list = new ArrayList<OreValuePair>(){{
		add(new OreValuePair("Button", ButtonActivity.class));
		add(new OreValuePair("Contacts", ContactsActivity.class));
		add(new OreValuePair("GoogleMap", GoogleMapActivity.class));
		add(new OreValuePair("WebImage", WebImageActivity.class));
	}};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance);
     
        ListAdapter adapter = new ArrayAdapter<OreValuePair>(this, 
        		android.R.layout.simple_list_item_1,
        		list);
        
        ListView view = (ListView) findViewById(R.id.entranceList);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new MyItemClickListener());
    }
    
    private void startActivity (Class<?> cls){
		Intent intent = new Intent(this, cls);
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);
	}
    
    static class OreValuePair{
    	private String name;
    	private Class<? extends Activity> clazz;
    	public OreValuePair(String name, Class<? extends Activity> clazz) {
    		this.name = name;
    		this.clazz = clazz;
    	}
    	@Override
    	public String toString() {
    		return name;
    	}
    }
    
    class MyItemClickListener implements OnItemClickListener{
    	@Override
    	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
    			long arg3) {
    		OreValuePair pair =  list.get(arg2);
    		startActivity(pair.clazz);
    	}
    }
}