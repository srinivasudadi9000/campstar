package m.srinivas.campstar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Group_Adapter extends RecyclerView.Adapter<Group_Adapter.MyHolder> {
    OneFragment context;
    ArrayList<Groups> groups;
    int Rowlayout;
    public Group_Adapter(OneFragment oneFragment, ArrayList<Groups> groups, int group_single) {
     this.context = oneFragment;
     this.groups = groups;
     this.Rowlayout = group_single;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(Rowlayout, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.group_title_tv.setText(groups.get(position).getGroupname());
        holder.post_img.setImageDrawable(context.getResources().getDrawable(groups.get(position).getPavan()));
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView group_title_tv;
        ImageView post_img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            post_img = itemView.findViewById(R.id.post_img);
            group_title_tv = itemView.findViewById(R.id.group_title_tv);
        }
    }

}
