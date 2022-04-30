import org.junit.Test

import org.junit.Assert.*

class FunctionKtTest {

    @Test
    fun add() {
        // arrange
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val userIdTest = 222

        // act
        notesMap.clear()
        val result = FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)

        // assert
        assertEquals(1, result)
    }

    @Test
    fun deleteIfFalse() {
        // arrange
        val noteId = 5

        // act
        notesMap.clear()
        val result = FunctionNotes().delete(noteId = noteId)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun deleteElseTrue() {
        // arrange
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val userIdTest = 222
        val noteIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        val result = FunctionNotes().delete(noteId = noteIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun editTrue() {
        // arrange
        val noteIdTest = 1
        val editNoteIdTest = 5
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val editTitleTest = "Edit title"
        val editTextTest = "Edit text"
        val userIdTest = 222

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        val result = FunctionNotes().edit(noteId = noteIdTest, title = editTitleTest, text = editTextTest, userId = userIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun editFalse() {
        // arrange
        val noteIdTest = 1
        val editNoteIdTest = 5
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val editTitleTest = "Edit title"
        val editTextTest = "Edit text"
        val userIdTest = 222

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        val result = FunctionNotes().edit(noteId = editNoteIdTest, title = editTitleTest, text = editTextTest, userId = userIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun getFalse() {
        // arrange
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val userIdTest = 222
        val editUserIdTest = 223

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        val result = FunctionNotes().get(userId = editUserIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun getTrue() {
        // arrange
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val userIdTest = 222
        val editUserIdTest = 222

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        val result = FunctionNotes().get(userId = editUserIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun getById() {
        // arrange
        val titleTest = "Title Test"
        val textTest = "Text Test"
        val userIdTest = 222
        val noteIdTest = 1
        val editNoteIdTest = 2

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionNotes().getById(noteIdTest)
        val result = FunctionNotes().getById(editNoteIdTest)


        // assert1
        assertEquals(true, result)
    }

    @Test
    fun createComment() {
        // arrange
        val noteIdText = 1
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        val result = FunctionComments().createComment(noteId = noteIdText, message = messageTest)

        // assert
        assertEquals(1, result)
    }

    @Test
    fun deleteCommentElseTrue() {
        // arrange
        val noteIdText = 1
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdText, message = messageTest)
        val result = FunctionComments().deleteComment(noteId = noteIdText, commentId = commentIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun deleteCommentIfFalse() {
        // arrange
        val noteIdText = 1
        val editNoteTextId = 5
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdText, message = messageTest)
        val result = FunctionComments().deleteComment(noteId = editNoteTextId, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun deleteCommentElseFalse() {
        // arrange
        val noteIdText = 1
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 5

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdText, message = messageTest)
        val result = FunctionComments().deleteComment(noteId = noteIdText, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun editCommentIfFalse() {
        // arrange
        val noteIdTest = 1
        val editNoteIdTest = 5
        val messageTest = "Text Test Comment"
        val editMessageTest = " Edit text"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        val result = FunctionComments().editComment(noteId = editNoteIdTest, commentId = commentIdTest, message = editMessageTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun editCommentElseTrue() {
        // arrange
        val noteIdTest = 1
        val messageTest = "Text Test Comment"
        val editMessageTest = " Edit text"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        val result = FunctionComments().editComment(noteId = noteIdTest, commentId = commentIdTest, message = editMessageTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun editCommentElseFalse() {
        // arrange
        val noteIdTest = 1
        val messageTest = "Text Test Comment"
        val editMessageTest = " Edit text"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 5

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        val result = FunctionComments().editComment(noteId = noteIdTest, commentId = commentIdTest, message = editMessageTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun getCommentsTrue() {
        // arrange
        val noteIdTest = 1
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val countTest = 1
        val messageTest = "Text Test Comment"

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        val result = FunctionComments().getComments(noteId = noteIdTest, count = countTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun getCommentsFalse() {
        // arrange
        val noteIdTest = 1
        val editNoteIdTest = 5
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val countTest = 1
        val messageTest = "Text Test Comment"

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        val result = FunctionComments().getComments(noteId =editNoteIdTest, count = countTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun restoreCommentElseTrue() {
        // arrange
        val noteIdTest = 1
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        FunctionComments().deleteComment(noteId = noteIdTest, commentId = commentIdTest)
        val result = FunctionComments().restoreComments(noteId = noteIdTest, commentId = commentIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun restoreCommentIfFalse() {
        // arrange
        val noteIdTest = 1
        val editNoteTestId = 5
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        FunctionComments().deleteComment(noteId = noteIdTest, commentId = commentIdTest)
        val result = FunctionComments().restoreComments(noteId = editNoteTestId, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun restoreCommentElseFalse() {
        // arrange
        val noteIdTest = 1
        val messageTest = "Text Test Comment"
        val titleTest = " "
        val textTest = " "
        val userIdTest = 222
        val commentIdTest = 5

        // act
        notesMap.clear()
        FunctionNotes().add(title = titleTest, text = textTest, userId = userIdTest)
        FunctionComments().createComment(noteId = noteIdTest, message = messageTest)
        FunctionComments().deleteComment(noteId = noteIdTest, commentId = commentIdTest)
        val result = FunctionComments().restoreComments(noteId = noteIdTest, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }
}



