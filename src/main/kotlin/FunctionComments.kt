class FunctionComments {
    fun createComment(noteId: Int, message: String): Int {
        val note = notesMap[noteId]
        var commentId = 0
        if (note != null) {
            if (note.visibility == true) {
                val commentsList = note.commentsList
                commentId = commentsList.size + 1
                commentsList.add(Comments(noteId, message, commentId = commentId))
            }
        }
        return commentId
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
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

    fun editComment(message: String, commentId: Int, noteId: Int): Boolean {
        var commentsList = notesMap[noteId]?.commentsList
        return if (notesMap[noteId]?.visibility != true) {
            println("Вы пытаетесь отредактировать комментарий у несуществующей заметки!")
            false
        } else {
            if (commentsList != null && commentsList.size >= commentId) {
                commentsList[commentId - 1] = Comments(noteId, message, commentId)
                println("Комментарий обновлен")
                true
            } else {
                println("Комментарий не найден. Обновление невозможно!")
                false
            }
        }
    }

    fun getComments(noteId: Int, count: Int): Boolean {
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

