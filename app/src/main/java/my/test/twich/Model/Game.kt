package my.test.twich

data class Game(
    val cover: String,
    val name: String,
    val numberOfChannals: Int,
    val numberOfViewers: Int,
    val followers_url: String,
)

data class Result(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<Game>
)
