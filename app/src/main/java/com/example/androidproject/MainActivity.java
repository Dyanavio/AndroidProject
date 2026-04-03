package com.example.androidproject;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.*;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.*;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.*;

import com.example.androidproject.adapters.ContactAdapter;
import com.example.androidproject.models.Contact;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

public class MainActivity extends AppCompatActivity
{
    private final Contact[] contacts = {
        new Contact(R.drawable.akane, "Kurokawa Akane",
                false, false, "20:57", true, R.drawable.akane, "Screening lasts 5 hours.", 0),
        new Contact(R.drawable.notion, "Notion Community",
                false, true, "Mon", false, R.drawable.notion, "New update dropped...", 4),
        new Contact(R.drawable.c_sharp, "P26",
                true, true, "Mon", false, R.drawable.black, "Сегодня не будет", 1),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactAdapter adapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(adapter);

    }

}