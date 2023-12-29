package api.banda.borgone.dto.response

data class MusicSheetResponse (
    val idMusicSheet:Long,val title:String, val progressiveNumber:Int,
    val author:String, val description:String, val note:String, val active:Boolean
)