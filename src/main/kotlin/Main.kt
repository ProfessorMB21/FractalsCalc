import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.PaintPanel
import viewmodels.MainViewModel

@Composable
@Preview
fun App(viewModel: MainViewModel = MainViewModel()) {
    MaterialTheme {
        PaintPanel(Modifier.fillMaxSize()) {
            viewModel.paint(it)
        }
    }
}

fun main(): Unit = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Fractals 2025"
        ){
        App()
    }
}
