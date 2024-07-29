import androidx.compose.ui.window.ComposeUIViewController
import org.hellcorp.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
