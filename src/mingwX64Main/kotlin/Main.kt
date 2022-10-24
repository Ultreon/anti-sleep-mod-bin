@file:Suppress("unused")

import platform.windows.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
var enabled = false

@CName("enable")
fun enable() {
    // Try this for vista, it will fail on XP
    if (SetThreadExecutionState(ES_CONTINUOUS or ES_SYSTEM_REQUIRED or ES_AWAYMODE_REQUIRED) == 0u) {
        // Try XP variant as well just to make sure
        SetThreadExecutionState(ES_CONTINUOUS or ES_SYSTEM_REQUIRED)
    }

    enabled = true
}

@CName("disable")
fun disable() {
    // set state back to normal
    SetThreadExecutionState(ES_CONTINUOUS)

    enabled = false
}

@CName("update")
fun update() {
    // Doesn't need update for Windows.
}

@CName("isEnabled")
fun isEnabled(): Boolean {
    return enabled
}
