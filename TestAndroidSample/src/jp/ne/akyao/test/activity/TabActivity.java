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
        
        TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("tab1 Label");
        tab1.setContent(R.id.tabContent1);
        
        TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("tab2 Label");
        tab2.setContent(R.id.tabContent2);
        
        TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setIndicator("tab3 Label");
        tab3.setContent(R.id.tabContent3);
        
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        
    }
}