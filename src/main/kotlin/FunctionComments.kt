class FunctionComments: Function<Comments> {
    override fun add(comments: Comments, noteId: Int): Int {
        val note = notesMap[noteId]
        var commentId = 0
        if (note != null) {
            if (note.visibility == true) {
                val commentsList = note.commentsList
                commentId = commentsList.size + 1
                commentsList.add(comments)
            }
        }
        return commentId
    }

    override fun delete(noteId: Int, commentId: Int): Boolean {
        val commentsList = notesMap[noteId]?.commentsList
        return if (notesMap[noteId]?.visibility != true) {
            println("Вы пытаетесь удалить комментарий у несуществующей заметки!")
            false
        } else {
            if (commentsList != null && commentsList.size >= commentId) {
                commentsList[commentId - 1].visibility = false
                println("Комментарий удален!")
                true
            } else {
                println("Комментарий не найден. Удаление невозможно!")
                false
            }
        }
    }

    override fun edit(noteId: Int, comments: Comments, commentId: Int): Boolean {
        var commentsList = notesMap[noteId]?.commentsList
        return if (notesMap[noteId]?.visibility != true) {
            println("Вы пытаетесь отредактировать комментарий у несуществующей заметки!")
            false
        } else {
            if (commentsList != null && commentsList.size >= commentId) {
                commentsList[commentId - 1] = comments
                println("Комментарий обновлен")
                true
            } else {
                println("Комментарий не найден. Обновление невозможно!")
                false
            }
        }
    }

    override fun get(noteId: Int, count: Int): Boolean {
        var i = 0
        for (note in notesMap.values) {
            if (note.visibility && note.noteId == noteId && (count - 1) < note.commentsList.size) {
                println(note.commentsList.slice(0 until count))
                i += 1
            }
        }
        return i != 0
    }

    fun restoreComments(noteId: Int, commentId: Int): Boolean {
        val commentsList = notesMap[noteId]?.commentsList
        return if (notesMap[noteId]?.visibility != true) {
            println("Вы пытаетесь восстановить комментарий у несуществующей заметки!")
            false
        } else {
            if (commentsList != null && commentsList.size >= commentId) {
                commentsList[commentId - 1].visibility = true
                println("Комментарий восстановлен")
                true
            } else {
                println("Комментарий не найден. Восстановление невозможно!")
                false
            }
        }
    }
}

