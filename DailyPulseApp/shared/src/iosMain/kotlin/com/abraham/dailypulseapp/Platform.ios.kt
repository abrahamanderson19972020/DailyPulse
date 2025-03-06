package com.abraham.dailypulseapp

// Import UIKit for iOS-specific code
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.Foundation.NSLog

actual class Platform {
    actual val osName: String
        get() = UIDevice.currentDevice.systemName

    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion

    actual val deviceModel: String
        get() = UIDevice.currentDevice.model

    actual val density: Int
        get() = (UIDevice.mainScreen.scale.toInt())

    actual fun logSystemInfo() {
        NSLog("OS: $osName $osVersion, Device: $deviceModel, Density: $density")
    }
}

