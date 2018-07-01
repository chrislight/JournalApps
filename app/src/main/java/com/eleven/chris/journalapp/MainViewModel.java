package com.eleven.chris.journalapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

import com.eleven.chris.journalapp.database.AppDatabase;
import com.eleven.chris.journalapp.database.JournalEntry;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<JournalEntry>> journalEntries;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the journal entries from the DataBase");
        journalEntries = database.entryDao().loadAllEntries();
    }

    public LiveData<List<JournalEntry>> getJournalEntries() {
        return journalEntries;
    }
}
