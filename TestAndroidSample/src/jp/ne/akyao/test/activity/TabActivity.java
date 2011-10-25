package jp.ne.akyao.test.activity;


import jp.ne.akyao.test.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabActivity extends android.app.TabActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //TODO 同じようなレイアウトを共有する方法
        //TODO プログラム上でid, textなどを動的に設定し、同じxmlを複数のviewで共有したい
        
        TabHost tabHost = getTabHost();
        
        LayoutInflater inflater = getLayoutInflater();
        
        inflater.inflate(R.layout.tab_content1, tabHost.getTabContentView(), true);
        inflater.inflate(R.layout.tab_content2, tabHost.getTabContentView(), true);
        inflater.inflate(R.layout.tab_content3, tabHost.getTabContentView(), true);
        
        tabHost.addTab(createTabSpec(tabHost, "tab1", "tab1 Label", R.id.tabContent1));
        tabHost.addTab(createTabSpec(tabHost, "tab2", "tab2 Label", R.id.tabContent2));
        tabHost.addTab(createTabSpec(tabHost, "tab3", "tab3 Label", R.id.tabContent3));
    }
    
    private TabSpec createTabSpec(TabHost tabHost, String tabName, String tabLabel, int content){
    	TabSpec spec = tabHost.newTabSpec(tabName);
    	spec.setIndicator(tabLabel);
    	spec.setContent(content);
    	return spec;
    }
}