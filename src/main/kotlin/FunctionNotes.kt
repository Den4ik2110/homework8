class FunctionNotes(val nullCode: Int = 0): Function<Notes> {
    override fun add(notes: Notes, nullCode: Int): Int {
        notesMap.put(notesMap.size + 1, notes)
        notes.noteId = notesMap.size
        return notes.noteId
    }

    override fun delete(noteId: Int, nullCode: Int): Boolean {
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

    override fun edit(noteId: Int, notes: Notes, nullCode: Int): Boolean {
        return if (notesMap[noteId]?.visibility == true) {
            notesMap.put(noteId, notes)
            println("Заметка отредактирована!")
            true
        } else {
            println("Заметка для редактирования не найдена!")
            false
        }
    }

    override fun get(userId: Int, nullCode: Int) : Boolean {
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

