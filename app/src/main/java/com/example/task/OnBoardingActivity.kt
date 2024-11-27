package com.example.task

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskTheme


class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Pages(
                        modifier = Modifier.padding(innerPadding),
                        endOnBoarding = {
                            startActivity(
                                Intent(
                                    this@OnBoardingActivity,
                                    LoginActivity::class.java
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pages(modifier: Modifier = Modifier, endOnBoarding: () -> Unit) {
    val pagerState = rememberPagerState { 3 }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        // Меняющийся текст
        HorizontalPager(pagerState, modifier = Modifier) {
            var ill: Painter = painterResource(R.drawable.illustration_1)
            var text1: String = ""
            var text2: String = ""
            when (it) {
                0 -> {
                    ill = painterResource(R.drawable.illustration_1)
                    text1 = "Анализы"
                    text2 = "Экспресс сбор и получение проб"
                }

                1 -> {
                    ill = painterResource(R.drawable.illustration_2)
                    text1 = "Уведомления"
                    text2 = "Вы быстро узнаете о результатах"
                }

                2 -> {
                    ill = painterResource(R.drawable.illustration_3)
                    text1 = "Мониторинг"
                    text2 = "Наши врачи всегда наблюдают \n" +
                            "за вашими показателями здоровья"
                }
            }
            OnBoardingScreen(
                ill = ill,
                text1 = text1,
                text2 = text2
            )
        }
        // Кнопка пропустить и иконка
        Box(modifier = Modifier.align(alignment = Alignment.TopCenter)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = if (pagerState.currentPage == pagerState.pageCount - 1) "Завершить" else "Пропустить",
                    modifier = Modifier
                        .padding(start = 30.dp, top = 5.dp)
                        .clickable(
                            remember { MutableInteractionSource() },
                            indication = null
                        )
                        {
                            endOnBoarding.invoke()
                        },
                    color = Color(0xFF57A9FF),
                    fontWeight = FontWeight(500),
                    fontSize = 25.sp
                )
                Icon(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = "plus",
                    tint = Color(0xFF57A9FF),
                    modifier = Modifier.size(165.dp)
                )
            }
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // позиция страницы
            repeat(3) {
                Box(
                    modifier = Modifier
                        .background(
                            color = if (it == pagerState.currentPage) Color(0xFF57A9FF) else Color.Transparent,
                            shape = CircleShape
                        )
                        .border(
                            color = if (it == pagerState.currentPage) Color.Transparent else Color(
                                0x8057A9FF
                            ),
                            width = 1.dp, shape = CircleShape
                        )
                        .size(15.dp)
                )
            }

        }

    }

}


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    ill: Painter,
    text1: String,
    text2: String
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(165.dp))
            Spacer(Modifier.weight(1f))
            // текст
            Text(
                text = text1,
                color = Color(0xFF00B712),
                fontSize = 30.sp,
                fontWeight = FontWeight.W500
            )
            Spacer(Modifier.height(50.dp))
            Text(
                text = text2,
                color = Color(0xFF939396),
                fontSize = 17.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.weight(1f))
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // иллюстрация
            Image(
                painter = ill,
                contentDescription = "image1",
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnBoardingScreenPreview() {
    TaskTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            OnBoardingScreen(
                modifier = Modifier.padding(innerPadding),

                ill = painterResource(R.drawable.illustration_1),
                text1 = "Анализы",
                text2 = "Экспресс сбор и получение проб"
            )
        }
    }
}
