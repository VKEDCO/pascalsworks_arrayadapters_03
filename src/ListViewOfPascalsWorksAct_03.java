package org.vkedco.mobappdev.listviewofpascalsworks_arrayadptr_03;

/*
 ************************************************************ 
 * IDE: Eclipse Juno
 * OS: Ubuntu 12.04 LTS
 * bugs to vladimir dot kulyukin at gmail dot com
 ************************************************************
 */

import android.os.Bundle;
import android.app.ListActivity;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class ListViewOfPascalsWorksAct_03 extends ListActivity {
	
	static String[] mPascalsWorks = null;
	static int[] mPascalsYears = null;
	
	static final String LOGTAG = "Pascal's Works 03";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view_of_pascals_works_act_03);
        Resources res = this.getResources();
        mPascalsWorks = res.getStringArray(R.array.pascals_titles);
        mPascalsYears = res.getIntArray(R.array.pascals_titles_years);
        
        setListAdapter(new ArrayAdapter<String>(this, 
        		R.layout.list_item_layout, 
        		mPascalsWorks));
        this
        	.getListView()
        	.setOnItemClickListener(
        			new OnItemClickListener() {
        				@Override
        				public void onItemClick(AdapterView<?> parent, View child, int position, long id) {
        					// 6. This is a subtle point: we cannot specify this as the
        					// first argument to makeText, because we are inside OnItemClickListener.
        					// Thus, we have to getApplicationContext() explicitly.
        					Toast t = 
        							Toast
        								.makeText(getApplicationContext(), 
        										Integer.toString(mPascalsYears[position]), 
        										Toast.LENGTH_LONG);
        					t.show();
        					Log.d(LOGTAG, Integer.toString(mPascalsYears[position]));
			}

			});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_of_pascals_works__act_03, menu);
        return true;
    }
    
}
