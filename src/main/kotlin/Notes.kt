class Notes(
    var title: String,
    var text: String,
    var userId: Int,
    var noteId: Int = 0,
    var visibility: Boolean = true,
    var commentsList: MutableList<Comments> = mutableListOf()
) {
    override fun toString(): String {
        val result = " { title: $title, " + " text: $text, " + "userId: $userId, " + " noteId: $noteId, " + " visibility: $visibility }"
        return result
    }

}



