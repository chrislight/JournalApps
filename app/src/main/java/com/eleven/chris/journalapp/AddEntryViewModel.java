package com.eleven.chris.journalapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.eleven.chris.journalapp.database.AppDatabase;
import com.eleven.chris.journalapp.database.JournalEntry;

public class AddEntryViewModel extends ViewModel {

    private LiveData<JournalEntry> journalEntryLiveData;

    public AddEntryViewModel(AppDatabase database, int entryId) {
        journalEntryLiveData = database.entryDao().loadEntryById(entryId);
    }

    // Create a getter for the journalEntry variable
    public LiveData<JournalEntry> getJournalEntry() {
        return journalEntryLiveData;
    }
}
