package com.example.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

class photsAdapter extends PagerAdapter {

   int[] imageRes={R.drawable.thor,R.drawable.loki_8,R.drawable.library};
          Context context;
        LayoutInflater layoutInflater;
    public photsAdapter(Context context) {
        this.context = context;
        /*layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
    }

    @Override
    public int getCount() {
        return imageRes.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;   }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
           View itemview=LayoutInflater.from(context).inflate(R.layout.image_layout,container,false);
        ImageView imageView=itemview.findViewById(R.id.imageView);
        imageView.setImageResource(imageRes[position]);
        container.addView(itemview);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,imageRes[position],Toast.LENGTH_SHORT).show();
              /*  if(imageRes[position]==R.drawable.thor){

                    Toast.makeText(context,"thor",Toast.LENGTH_SHORT).show();


                }else if(imageRes[position]==R.drawable.thor){
                    Toast.makeText(context,"loki",Toast.LENGTH_SHORT).show();

                }else if(imageRes[position]==R.drawable.library){
                    Toast.makeText(context,"libray",Toast.LENGTH_SHORT).show();

                }*/
            }
        });
        return itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

