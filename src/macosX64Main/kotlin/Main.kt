@file:Suppress("unused")

import platform.darwin.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
var enabled = false

@CName("enable")
fun enable() {
    enabled = true
}

@CName("disable")
fun disable() {
    enabled = false
}

@CName("update")
fun update() {
    UpdateSystemActivity(OverallAct)
}

@CName("isEnabled")
fun isEnabled(): Boolean {
    return enabled
}
