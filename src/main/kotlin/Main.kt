import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    MaterialTheme {
        Content(Modifier.fillMaxWidth())
    }
}

@Composable
@Preview
fun Content(modifier: Modifier = Modifier) {
    var userText by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("Hello strainger") }

    Column {
        OutlinedTextField(
            userText,
            onValueChange = {userText = it},
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Button(onClick = {
                outputText = userText
            })
            {
                Text("Click me")
            }
            Text(outputText)
        }
    }
}

fun main(): Unit = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
