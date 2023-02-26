package edu.ucsd.cse110.sharednotes.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    /** The title of the note. Used as the primary key for shared notes (even on the cloud). */
    @PrimaryKey
    @NonNull
    public String title;

    /** The content of the note. */
    @NonNull
    public String content;

    /**
     * When the note was last modified. Used for resolving local (db) vs remote (api) conflicts.
     * Defaults to 0 (Jan 1, 1970), so that if a note already exists remotely, its content is
     * always preferred to a new empty note.
     */
    public long lastModified = 0;

    /** General constructor for a note. */
    public Note(@NonNull String title, @NonNull String content) {
        this.title = title;
        this.content = content;
    }
}
