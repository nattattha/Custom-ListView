package com.ninvisut.natt.customfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new ListviewAdapter());

    }

    private class ListviewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 15;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            ViewHolder viewHolder = null;

            if (convertView == null) {

                //load layout
                convertView = getLayoutInflater().inflate(R.layout.item_listview, null);
                viewHolder = new ViewHolder();
                viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.item_title);
                viewHolder.foodImageView = (ImageView) convertView.findViewById(R.id.item_img);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.titleTextView.setText("Clean food");

            //String imgUrl = "http://www.naasai.com/wp-content/uploads/2014/10/clean-salad.jpg";
            //Glide.with(getApplicationContext()).load(imgUrl).into(viewHolder.foodImageView);

            String imgUrl = "http://www.naasai.com/wp-content/uploads/2014/10/clean-salad.jpg" ;
            Glide.with(getApplicationContext()).load(imgUrl)
                    .transform(new CircleTransform(getApplicationContext(), "#00ff00", 1))
                    .into(viewHolder.foodImageView);

            return convertView;
        }

    }   //adapter

    //Inner Class
    public class ViewHolder {
        TextView titleTextView;
        ImageView foodImageView;
    }

}
