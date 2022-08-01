package com.example.my30_recylerview2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//리사이클러뷰 어댑터를 상속받는다.
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonDTOItemClickListener{
    ArrayList<PersonDTO> itemList = new ArrayList<>();
    private static final String TAG = "MainPersonAdapter";
    OnPersonDTOItemClickListener listener;

    //뷰홀더가 만들어질때 작동하는 메서드
    //화면을 인플레이트하고 인플레이트된 화면을 리턴한다.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);
        return new ViewHolder(itemView, listener);
    }

    //뷰홀더가 생길때 dto를 뷰홀더에 넘겨준다.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: position ▶ " + position);
        PersonDTO item = itemList.get(position);
        holder.setItem(item);
    }

    //아이템이 몇 개 들어갔는지 세는 메서드
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //리스트에 DTO를 추가하는 메서드
    public void addItem(PersonDTO item) {
        itemList.add(item);
    }

    //리스트의 해당 인덱스의 DTO 객체를 반환하는 메서드
    public PersonDTO getItem(int position) {
        return itemList.get(position);
    }

    public void setOnItemClickListener(OnPersonDTOItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holderm, View view, int position) {
        if(listener != null){
            listener.onItemClick(holderm, view, position);
        }
    }

    //리사이클러뷰 뷰홀더를 상속받는다.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhoneNum;
        ImageView imageView;

        //생성자를 만든다.
        //여기서 itemView는 화면에 표시되는 각각의 person_item.xml 뷰이다
        public ViewHolder(@NonNull View itemView, final OnPersonDTOItemClickListener listener) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPhoneNum = itemView.findViewById(R.id.tvPhoneNum);
            imageView = itemView.findViewById(R.id.imageView);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   int position = getAdapterPosition();
                   if(listener != null) {
                       listener.onItemClick(ViewHolder.this, view, position);
                   }
               }
           });
        }

        public void setItem(PersonDTO item) {
            tvName.setText(item.getName());
            tvPhoneNum.setText(item.getPhoneNum());
            imageView.setImageResource(item.getResId());
        }
    }
}
