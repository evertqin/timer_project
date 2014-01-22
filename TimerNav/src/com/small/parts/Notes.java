package com.small.parts;

import java.util.Collection;
import java.util.SortedSet;
import java.util.Vector;


public class Notes {
	private String name;
	private Vector<Note> notes;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector<Note> getNotes() {
		return notes;
	}
	public void setNotes(Vector<Note> notes) {
		this.notes = notes;
	}
	public void addNote(Note note) {
		notes.add(note);
	}
	
}
