package com.example.dat09.supportemail.ui.template;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dat09.supportemail.R;
import com.example.dat09.supportemail.model.Template;
import com.example.dat09.supportemail.ui.composer.ComposerActivity;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Dat09 on 9/25/2017.
 */

public class CustomTemplateAdapter extends RecyclerView.Adapter<CustomTemplateAdapter.TemplateHolder>{

    private List<Template> templates;
    private Context context;

    public CustomTemplateAdapter(List<Template> templates, Context context) {
        this.templates = templates;
        this.context = context;
    }

    @Override
    public TemplateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new TemplateHolder(v);
    }

    @Override
    public void onBindViewHolder(TemplateHolder holder, final int position) {
        holder.tvTitle.setText(templates.get(position).getTitle());
        holder.lineItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Template template = templates.get(position);
                Gson gson = new Gson();
                String json = gson.toJson(template);

                Intent intent = new Intent(context, ComposerActivity.class);
                intent.putExtra("template",json);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return templates.size();
    }

    public static class TemplateHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public LinearLayout lineItem;
        public TemplateHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            lineItem = (LinearLayout) itemView.findViewById(R.id.line_item);
        }
    }
}
