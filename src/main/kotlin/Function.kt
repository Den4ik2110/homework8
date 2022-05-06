interface Function<T> {
    fun add(entity: T, Id: Int): Int
    fun delete(noteId: Int, commentId: Int): Boolean
    fun edit(noteId: Int, entity: T, commentId: Int): Boolean
    fun get(noteId: Int, count: Int): Boolean
}