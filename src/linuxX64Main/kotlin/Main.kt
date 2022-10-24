@file:Suppress("unused")

import platform.linux.*
import x11.XOpenDisplay
import x11.XResetScreenSaver
import kotlin.native.concurrent.SharedImmutable
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
var enabled = false

@SharedImmutable
private val display = XOpenDisplay(":0")

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
    if (enabled)
    XResetScreenSaver(display)
}

@CName("isEnabled")
fun isEnabled(): Boolean {
    return enabled
}
