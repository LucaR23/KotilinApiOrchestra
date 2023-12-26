package api.banda.borgone.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class MusicSheetRequest (
  @NotBlank @Size(min=5)
  val author: String,
  @NotBlank @Size(min=10)
  val description:String,
  val note:String,
  @NotNull
  val progressiveNumber:Int,
  @NotBlank @Size(min=1)
  val title:String
)
