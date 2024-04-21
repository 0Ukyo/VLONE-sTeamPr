package com.example.myappication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Imagea> mData;

    public ImageAdapter(List<Imagea> data) {
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_piture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

                int a=position;
        Imagea imageUrl = mData.get(position);
        // 加载图片到ImageView
        Bitmap bitmap=imageUrl.getImage();
        holder.imageView.setImageBitmap(bitmap);
        holder.textView.setText("商品："+imageUrl.getDescribe()+"售价："+imageUrl.getName()+"元");
       // holder.textView.setTextSize(10);
       // holder.textView.setTextScaleX(10);
       // Glide.with(holder.imageView.getContext()).load(imageUrl).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    ImageView imageView=v.findViewById(R.id.ImageView_item);
                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    TextView textView=v.findViewById(R.id.Text_item);
                    String name=textView.getText().toString();
                    mListener.onItemClick(position,bitmap,imageUrl.getName(),imageUrl.getDescribe());
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ImageView_item);
            textView=itemView.findViewById(R.id.Text_item);
        }




    }
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position, Bitmap bitmap,String price,String name );
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


}