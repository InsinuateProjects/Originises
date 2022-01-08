package originises

import kotlinx.coroutines.runBlocking
import taboolib.common.env.RuntimeDependencies
import taboolib.common.env.RuntimeDependency
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.releaseResourceFile
import taboolib.common.platform.function.submit
import java.io.File
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

/**
 * Originises
 * originises.Originises
 *
 * @author Score2
 * @since 2022/01/07 13:26
 */
@RuntimeDependencies(
    RuntimeDependency("org.jetbrains.intellij.deps:trove4j:1.0.20181211"),
    RuntimeDependency("org.jetbrains.kotlin:kotlin-reflect:1.6.10"),
    RuntimeDependency("org.jetbrains.kotlin:kotlin-main-kts:1.6.10"),
    RuntimeDependency("org.jetbrains.kotlin:kotlin-scripting-common:1.6.10"),
    RuntimeDependency("org.jetbrains.kotlin:kotlin-scripting-jvm:1.6.10"),
    RuntimeDependency("org.jetbrains.kotlin:kotlin-scripting-jvm-host:1.6.10"),
    RuntimeDependency("org.jetbrains.kotlin:kotlin-scripting-compiler-impl-embeddable:1.6.10"),
    RuntimeDependency("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8"),
)
object Originises : Plugin() {

    val mainFile by lazy { releaseResourceFile("core/main.kts") }

    val scriptingHost = BasicJvmScriptingHost()

    override fun onEnable() {
        runBlocking {
            scriptingHost.compiler(mainFile.toScriptSource(), ScriptCompilationConfiguration())
        }
    }

}