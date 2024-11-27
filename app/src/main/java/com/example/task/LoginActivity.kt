package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.task.ui.theme.TaskTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MailCode(modifier = Modifier.padding(innerPadding))
//                    Login(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(horizontal = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.hello),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(17.dp))
            Text(
                text = "Добро пожаловать!",
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Войдите, чтобы пользоваться функциями приложения",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = "Вход по E-mail",
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            color = Color(0xFF7E7E9A)
        )
//        fun isValidEmail(email: String): Boolean {
//            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
//        }
//
//        val check = isValidEmail(textState.value)
        OutlinedTextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            colors = OutlinedTextFieldDefaults.colors(
//                focusedBorderColor = if ((check == false) and (textState.value != "")) Color.Red else Color(0xFFEBEBEB),
                focusedBorderColor = Color(0xFFEBEBEB),
                focusedContainerColor = Color(0xFFF5F5F9),
                unfocusedContainerColor = Color(0xFFF5F5F9),
                unfocusedBorderColor = Color(0xFFEBEBEB),
            ),
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = "example@mail.ru",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0x80000000)
                )
            },
            modifier = Modifier.fillMaxWidth()
//            supportingText = {
//                if ((check == false) and (textState.value != "")) {
//                    Text(text = "Неверный e-mail", color = Color.Red)
//                }
//            }

        )

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp),
//            enabled = (textState.value != "") and (isValidEmail(textState.value)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A6FEE),
                disabledContainerColor = Color(0xFFC9D4FB)
            ),
            onClick = {

            }
        ) {
            Text(
                text = "Далее",
                fontWeight = FontWeight.W600,
                fontSize = 17.sp,
                color = Color.White
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = "Или войдите с помощью",
            fontWeight = FontWeight.W400,
            fontSize = 15.sp,
            color = Color(0xFF939396),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
            border = BorderStroke(1.dp, Color(0xFFEBEBEB)),
            onClick = {

            }
        ) {
            Text(
                text = "Войти с Яндекс",
                fontWeight = FontWeight.W600,
                fontSize = 17.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun MailCode(modifier: Modifier = Modifier) {
    val focusRq1 = remember { FocusRequester() }
    val focusRq2 = remember { FocusRequester() }
    val focusRq3 = remember { FocusRequester() }
    val focusRq4 = remember { FocusRequester() }
    val textState = remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Spacer(Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .padding(start = 24.dp)
                .size(40.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF5F5F9)
            ),
            onClick = {

            }
        ) {
            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = ""
            )
        }
        Spacer(Modifier.height(200.dp))
        Text(
            text = "Введите код из E-mail",
            fontWeight = FontWeight.W600,
            fontSize = 17.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 70.dp, end = 70.dp)
        ) {
            Spacer(Modifier.weight(1f))
            TxtField(
                nextFocusRq = focusRq2,
                currentFocusRq = focusRq1,
                previousFocusRq = null,
                textState = textState,
                count = 1
            )
            Spacer(Modifier.width(15.dp))
            TxtField(
                nextFocusRq = focusRq3,
                currentFocusRq = focusRq2,
                previousFocusRq = focusRq1,
                textState = textState,
                count = 2
            )
            Spacer(Modifier.width(15.dp))
            TxtField(
                nextFocusRq = focusRq4,
                currentFocusRq = focusRq3,
                previousFocusRq = focusRq2,
                textState = textState,
                count = 3
            )
            Spacer(Modifier.width(15.dp))
            TxtField(
                nextFocusRq = null,
                currentFocusRq = focusRq4,
                previousFocusRq = focusRq3,
                textState = textState,
                count = 4
            )
            Spacer(Modifier.weight(1f))
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Отправить код повторно можно\nбудет через 59 секунд",
            fontWeight = FontWeight.W400,
            fontSize = 15.sp,
            color = Color(0xFF939396),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TxtField(
    count: Int,
    currentFocusRq: FocusRequester,
    nextFocusRq: FocusRequester?,
    previousFocusRq: FocusRequester?,
    textState: MutableState<String>
) {
    OutlinedTextField(
        value = if (textState.value.length >= count) {
            textState.value[count - 1].toString()
        } else {
            ""
        },
        onValueChange = {
            if (it.length == 1 && it.isDigitsOnly()) {
                textState.value = textState.value.addCharAtIndex(char = it.toCharArray()[0], index = count - 1)
                        .take(4)
                nextFocusRq?.requestFocus()
            }
            if (it.isEmpty()) {
                textState.value = textState.value.deleteCharAtIndex(count - 1)
            }



        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFEBEBEB),
            focusedContainerColor = Color(0xFFF5F5F9),
            unfocusedContainerColor = Color(0xFFF5F5F9),
            unfocusedBorderColor = Color(0xFFEBEBEB),
        ),
        modifier = Modifier
            .onKeyEvent { keyEvent: KeyEvent ->
                if (keyEvent.key == Key.Backspace && keyEvent.type == KeyEventType.KeyUp && textState.value.isNotEmpty() && textState.value.length < count) {
                    previousFocusRq?.requestFocus()
                    textState.value = textState.value.deleteCharAtIndex(textState.value.length-1)
                }
                true
            }
            .focusRequester(currentFocusRq)
            .size(50.dp),
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(textAlign = TextAlign.Center),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskTheme {
        MailCode(modifier = Modifier)
    }
}