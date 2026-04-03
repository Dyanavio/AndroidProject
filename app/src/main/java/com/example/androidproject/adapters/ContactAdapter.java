package com.example.androidproject.adapters;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.models.Contact;
import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>
{
    private final Contact[] contacts;

    public ContactAdapter(Contact[] contacts)
    {
        this.contacts = contacts;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView logoImageView;
        TextView nameTextView;
        ImageView mutedImageView;
        ImageView verifiedImageView;
        TextView timeTextView;
        ImageView lastUserImageView;
        TextView lastMessageTextView;
        TextView unreadCounter;

        ViewHolder(View v)
        {
            super(v);
            logoImageView = v.findViewById(R.id.logoImageView);
            nameTextView = v.findViewById(R.id.nameTextView);
            mutedImageView = v.findViewById(R.id.mutedImageView);
            verifiedImageView = v.findViewById(R.id.verifiedImageView);
            lastUserImageView = v.findViewById(R.id.lastUserImageView);
            lastMessageTextView = v.findViewById(R.id.lastMessageTextView);
            timeTextView = v.findViewById(R.id.timeTextView);
            unreadCounter = v.findViewById(R.id.unreadCounter);
        }
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        Contact contact = contacts[position];

        holder.logoImageView.setImageResource(contact.getImageId());
        holder.nameTextView.setText(contact.getName());

        if(contact.isMuted())
        {
            holder.mutedImageView.setVisibility(VISIBLE);
        }
        else
        {
            holder.mutedImageView.setVisibility(GONE);
        }

        if(contact.isVerified())
        {
            holder.verifiedImageView.setVisibility(VISIBLE);
        }
        else
        {
            holder.verifiedImageView.setVisibility(GONE);
        }

        var params = holder.lastUserImageView.getLayoutParams();
        if(contact.isPrivate())
        {
            holder.lastUserImageView.setVisibility(INVISIBLE);
            params.width = 0;
        }
        else
        {
            holder.lastUserImageView.setImageResource(contact.getLastUserImageId());
            holder.lastUserImageView.setVisibility(VISIBLE);
            params.width = 40;
        }
        holder.lastUserImageView.setLayoutParams(params);

        holder.lastMessageTextView.setText(contact.getLastMessage());
        holder.timeTextView.setText(contact.getDate());
        if(contact.getUnreadMessages() == 0)
        {
            holder.unreadCounter.setVisibility(INVISIBLE);
        }
        else
        {
            holder.unreadCounter.setVisibility(VISIBLE);
            holder.unreadCounter.setText(String.valueOf(contact.getUnreadMessages()));
        }
    }

    @Override
    public int getItemCount()
    {
        return contacts.length;
    }
}
