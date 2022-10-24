@file:Suppress("unused")

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
    // Doesn't need update for macOS.
}

@CName("isEnabled")
fun isEnabled(): Boolean {
    return enabled
}
