@file:Suppress("unused")

import platform.windows.*

@CName("enable")
fun enable() {
    // Try this for vista, it will fail on XP
    if (SetThreadExecutionState(ES_CONTINUOUS or ES_SYSTEM_REQUIRED or ES_AWAYMODE_REQUIRED) == 0u) {
        // Try XP variant as well just to make sure
        SetThreadExecutionState(ES_CONTINUOUS or ES_SYSTEM_REQUIRED)
    }
}

@CName("disable")
fun disable() {
    // set state back to normal
    SetThreadExecutionState(ES_CONTINUOUS)
}
