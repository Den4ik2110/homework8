class FunctionNotes {
    fun add(title: String, text: String, userId: Int): Int {
        var notes: Notes = Notes(title, text, userId)
        notesMap.put(notesMap.size + 1, notes)
        notes.noteId = notesMap.size
        return notes.noteId
    }

    fun delete(noteId: Int): Boolean {
        return if (notesMap[noteId]?.visibility != true) {
            println("Заметка не найдена. Удаление невозможно!")
            false
        } else {
            val notes = notesMap[noteId]
            if (notes != null) {
                notes.visibility = false
                for (comment in notes.commentsList) {
                    comment.visibility = false
                }
                true
            } else {
                false
            }
        }
    }

    fun edit(noteId: Int, title: String, text: String, userId: Int): Boolean {
        return if (notesMap[noteId]?.visibility == true) {
            notesMap.put(noteId, Notes(title, text, userId))
            println("Заметка отредактирована!")
            true
        } else {
            println("Заметка для редактирования не найдена!")
            false
        }
    }

    fun get(userId: Int) : Boolean {
        var i = 0
        val returnList = mutableListOf<Notes>()
        for (note in notesMap.values) {
            if (note.visibility && note.userId == userId) {
                returnList += note
                i += 1
            }
        }
        println(returnList.toString())
        return i != 0
    }

    fun getById(vararg noteId: Int) : Boolean{
        for (note in noteId) {
            if (notesMap[note]?.visibility == true) {
                println(notesMap[note])
            } else {
                println("Заметка № $note не найдена")
            }
        }
        return true
    }


}

