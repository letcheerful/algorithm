package letcheerful.algorithm.woowa

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class number2 {

    // Complete the arrayManipulation function below.
    enum class Type {
        music,
        images,
        movies,
        other
    }

    class File(
        val type: Type,
        val size: Int // In byte
    )

    fun solution(S: String): String {

        val fileMapper = { fileInfo: String ->
            val infos = fileInfo.split(' ')

            val fileName = infos[0]
            val fileSize = infos[1].removeSuffix("b").toInt()
            val fileExtension = fileName.substringAfterLast('.')

            val fileType = when(fileExtension) {
                "mp3", "aac", "flac" -> Type.music
                "jpg", "bmp", "gif" -> Type.images
                "mp4", "avi", "mkv" -> Type.movies
                else -> Type.other
            }

            File(fileType, fileSize)
        }

        val fileInfos = S.split('\n')
        val files = fileInfos.map(fileMapper)

        val musicFiles = ArrayList<File>()
        val imageFiles = ArrayList<File>()
        val movieFiles = ArrayList<File>()
        val otherFiles = ArrayList<File>()

        files.forEach {
            when(it.type) {
                Type.music -> musicFiles.add(it)
                Type.movies -> movieFiles.add(it)
                Type.images -> imageFiles.add(it)
                Type.other -> otherFiles.add(it)
            }
        }

        val musicTotalSize = musicFiles.map { it.size }.sum()
        val movieTotalSize = movieFiles.map { it.size }.sum()
        val imageTotalSize = imageFiles.map { it.size }.sum()
        val otherTotalSize = otherFiles.map { it.size }.sum()

        return Type.music.name + " " + musicTotalSize + "b\n" +
                Type.images.name + " " + imageTotalSize + "b\n" +
                Type.movies.name + " " + movieTotalSize + "b\n" +
                Type.other.name + " " + otherTotalSize + "b"
    }

    @Test
    fun test() {
        val input = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b"
        val output = "music 1011b\nimages 0b\nmovies 10200b\nother 105b"

        println(solution(input))

        Assert.assertEquals(output, solution(input))
    }

}
