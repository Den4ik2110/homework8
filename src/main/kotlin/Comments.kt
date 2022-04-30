class Comments(
    var noteId: Int,
    var message: String,
    var commentId: Int = 0,
    val replyTo: Int? = null,
    var visibility: Boolean = true
) {
    override fun toString(): String {
        val result = " message: $message, " + "commentId: $commentId, " + "visibility: $visibility "
        return result
    }
}
