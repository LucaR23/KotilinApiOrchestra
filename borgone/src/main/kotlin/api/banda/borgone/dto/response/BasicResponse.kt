package api.banda.borgone.dto.response

import java.util.Objects
import java.util.Optional
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class BasicResponse (
    var status:Boolean,var body:List<out Any>?=null, var message:String
)