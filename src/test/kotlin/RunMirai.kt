package org.example.mirai.plugin

import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.console.MiraiConsole
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.enable
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.load
import net.mamoe.mirai.console.terminal.MiraiConsoleTerminalLoader
import net.mamoe.mirai.utils.BotConfiguration

suspend fun main() {
    MiraiConsoleTerminalLoader.startAsDaemon()

    //如果是Kotlin
//    PluginMain.load()
//    PluginMain.enable()
    //如果是Java
    JavaPluginMain.INSTANCE.load()
    JavaPluginMain.INSTANCE.enable()

    val bot = MiraiConsole.addBot(1187214533, "[password]") {
        BotConfiguration.MiraiProtocol.ANDROID_PAD
        fileBasedDeviceInfo()
    }.alsoLogin()

    MiraiConsole.job.join()
}