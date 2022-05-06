import org.junit.Test

import org.junit.Assert.*

class FunctionKtTest {

    @Test
    fun add() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)

        // act
        notesMap.clear()
        val result = FunctionNotes().add(notes = notesTest, 0)

        // assert
        assertEquals(1, result)
    }

    @Test
    fun deleteIfFalse() {
        // arrange
        val noteId = 5

        // act
        notesMap.clear()
        val result = FunctionNotes().delete(noteId = noteId, 0)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun deleteElseTrue() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val noteIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        val result = FunctionNotes().delete(noteId = noteIdTest, 0)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun editTrue() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val notesTestEdit = Notes("Title Test", "Text Test", 222)
        val noteIdTest = 1

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        val result = FunctionNotes().edit(noteId = noteIdTest, notes = notesTestEdit, 0)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun editFalse() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val notesTestEdit = Notes("Title Test", "Text Test", 222)
        val editNoteIdTest = 5

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        val result = FunctionNotes().edit(noteId = editNoteIdTest, notes = notesTestEdit, 0)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun getFalse() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val editUserIdTest = 223

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        val result = FunctionNotes().get(userId = editUserIdTest, 0)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun getTrue() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val editUserIdTest = 222

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        val result = FunctionNotes().get(userId = editUserIdTest, 0)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun getById() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val noteIdTest = 1
        val editNoteIdTest = 2

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionNotes().getById(noteIdTest)
        val result = FunctionNotes().getById(editNoteIdTest)


        // assert1
        assertEquals(true, result)
    }

    @Test
    fun createComment() {
        // arrange
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        val result = FunctionComments().add(commentTest, 1)

        // assert
        assertEquals(1, result)
    }

    @Test
    fun deleteCommentElseTrue() {
        // arrange
        val noteIdText = 1
        val commentIdTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().delete(noteId = noteIdText, commentId = commentIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun deleteCommentIfFalse() {
        // arrange
        val editNoteTextId = 5
        val commentIdTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().delete(noteId = editNoteTextId, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun deleteCommentElseFalse() {
        // arrange
        val noteIdText = 1
        val commentIdTest = 5
        val notesTest: Notes = Notes("Title Test", "Text Test", 222)
        val commentTest: Comments = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().delete(noteId = noteIdText, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun editCommentIfFalse() {
        // arrange
        val editNoteIdTest = 5
        val commentIdTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")
        val commentTestEdit = Comments(1, "Edit Text")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result =
            FunctionComments().edit(noteId = editNoteIdTest, commentId = commentIdTest, comments = commentTestEdit)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun editCommentElseTrue() {
        // arrange
        val noteIdTest = 1
        val commentIdTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")
        val commentTestEdit = Comments(1, "Edit Text")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().edit(noteId = noteIdTest, commentId = commentIdTest, comments = commentTestEdit)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun editCommentElseFalse() {
        // arrange
        val noteIdTest = 1
        val commentIdTest = 5
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")
        val commentTestEdit = Comments(1, "Edit Text")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().edit(noteId = noteIdTest, commentId = commentIdTest, comments = commentTestEdit)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun getCommentsTrue() {
        // arrange
        val noteIdTest = 1
        val countTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().get(noteId = noteIdTest, count = countTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun getCommentsFalse() {
        // arrange
        val editNoteIdTest = 5
        val countTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        val result = FunctionComments().get(noteId = editNoteIdTest, count = countTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun restoreCommentElseTrue() {
        // arrange
        val noteIdTest = 1
        val commentIdTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        FunctionComments().delete(noteId = noteIdTest, commentId = commentIdTest)
        val result = FunctionComments().restoreComments(noteId = noteIdTest, commentId = commentIdTest)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun restoreCommentIfFalse() {
        // arrange
        val noteIdTest = 1
        val editNoteTestId = 5
        val commentIdTest = 1
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        FunctionComments().delete(noteId = noteIdTest, commentId = commentIdTest)
        val result = FunctionComments().restoreComments(noteId = editNoteTestId, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }

    @Test
    fun restoreCommentElseFalse() {
        // arrange
        val noteIdTest = 1
        val commentIdTest = 5
        val notesTest = Notes("Title Test", "Text Test", 222)
        val commentTest = Comments(1, "Text Test Comment")

        // act
        notesMap.clear()
        FunctionNotes().add(notes = notesTest, 0)
        FunctionComments().add(commentTest, 1)
        FunctionComments().delete(noteId = noteIdTest, commentId = commentIdTest)
        val result = FunctionComments().restoreComments(noteId = noteIdTest, commentId = commentIdTest)

        // assert
        assertEquals(false, result)
    }
}



